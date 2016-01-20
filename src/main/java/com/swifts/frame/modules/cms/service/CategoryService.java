/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.cms.service;

import java.util.List;
import java.util.Set;

import com.swifts.frame.common.config.Global;
import com.swifts.frame.common.pagehelper.PageHelper;
import com.swifts.frame.common.service.TreeService;
import com.swifts.frame.modules.cms.entity.Category;
import com.swifts.frame.modules.cms.utils.CmsUtils;
import com.swifts.frame.modules.sys.dao.MenuDao;
import com.swifts.frame.modules.sys.dao.RoleDao;
import com.swifts.frame.modules.sys.entity.Menu;
import com.swifts.frame.modules.sys.entity.Role;
import com.swifts.frame.modules.sys.service.SystemService;
import com.swifts.frame.modules.sys.utils.UserUtils;
import com.swifts.frame.modules.sys.entity.Office;
import com.swifts.frame.modules.sys.entity.User;
import groovy.transform.AutoClone;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.modules.cms.dao.CategoryDao;
import com.swifts.frame.modules.cms.entity.Site;

/**
 * 栏目Service
 * @author ThinkGem
 * @version 2013-5-31
 */
@Service
@Transactional(readOnly = true)
public class CategoryService extends TreeService<CategoryDao, Category> {

	public static final String CACHE_CATEGORY_LIST = "categoryList";
	
	private Category entity = new Category();
	@Autowired
	private MenuDao menuDao;
	@SuppressWarnings("unchecked")
	public List<Category> findByUser(boolean isCurrentSite, String module){
		List<Category> list = (List<Category>) UserUtils.getCache(CACHE_CATEGORY_LIST);
		if (list == null||list.size()<=0){
			User user = UserUtils.getUser();
			Category category = new Category();
			category.setOffice(new Office());
			List<Role> roles=user.getRoleList();
			Boolean flag=true;
			for(Role role :roles){
				Menu menu=new Menu();
				menu.setUserId(user.getId());
				List<Menu> menus=menuDao.findByUserId(menu);
				if(Role.DATA_SCOPE_ALL.equals(role.getDataScope())){
					//所有的数据
					for(Menu item:menus){
						if("cms:category:view".equals(item.getPermission())){
							flag=false;
							break;
						}
					}
				}
			}
			if(flag){
				category.getSqlMap().put("dsf", dataScopeFilter(user, "o", "u"));
			}
			category.setSite(new Site());
			category.setParent(new Category());
			list = dao.findList(category);
			// 将没有父节点的节点，找到父节点
			Set<String> parentIdSet = Sets.newHashSet();
			for (Category e : list){
				if (e.getParent()!=null && StringUtils.isNotBlank(e.getParent().getId())){
					boolean isExistParent = false;
					for (Category e2 : list){
						if (e.getParent().getId().equals(e2.getId())){
							isExistParent = true;
							break;
						}
					}
					if (!isExistParent){
						parentIdSet.add(e.getParent().getId());
					}
				}
			}
			UserUtils.putCache(CACHE_CATEGORY_LIST, list);
		}
		if (isCurrentSite){
			List<Category> categoryList = Lists.newArrayList(); 
			for (Category e : list){
				if (Category.isRoot(e.getId()) || (e.getSite()!=null && e.getSite().getId() !=null 
						&& e.getSite().getId().equals(Site.getCurrentSiteId()))){
					if (StringUtils.isNotEmpty(module)){
						if (module.equals(e.getModule()) || "".equals(e.getModule())){
							categoryList.add(e);
						}
					}else{
						categoryList.add(e);
					}
				}
			}
			return categoryList;
		}
		return list;
	}

	public List<Category> findByParentId(String parentId, String siteId){
		Category parent = new Category();
		parent.setId(parentId);
		entity.setParent(parent);
		Site site = new Site();
		site.setId(siteId);
		entity.setSite(site);
		return dao.findByParentIdAndSiteId(entity);
	}
	
	public PageInfo<Category> find(int pageNum,int pageSize, Category category) {
//		DetachedCriteria dc = dao.createDetachedCriteria();
//		if (category.getSite()!=null && StringUtils.isNotBlank(category.getSite().getId())){
//			dc.createAlias("site", "site");
//			dc.add(Restrictions.eq("site.id", category.getSite().getId()));
//		}
//		if (category.getParent()!=null && StringUtils.isNotBlank(category.getParent().getId())){
//			dc.createAlias("parent", "parent");
//			dc.add(Restrictions.eq("parent.id", category.getParent().getId()));
//		}
//		if (StringUtils.isNotBlank(category.getInMenu()) && Category.SHOW.equals(category.getInMenu())){
//			dc.add(Restrictions.eq("inMenu", category.getInMenu()));
//		}
//		dc.add(Restrictions.eq(Category.FIELD_DEL_FLAG, Category.DEL_FLAG_NORMAL));
//		dc.addOrder(Order.asc("site.id")).addOrder(Order.asc("sort"));
//		return dao.find(page, dc);
//		page.setSpringPage(dao.findByParentId(category.getParent().getId(), page.getSpringPage()));
//		return page;
		PageHelper.startPage(pageNum,pageSize,true);
		category.setInMenu(Global.SHOW);
		PageInfo<Category> page=new PageInfo<>(dao.findModule(category));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void save(Category category) {
		category.setSite(new Site(Site.getCurrentSiteId()));
		if (StringUtils.isNotBlank(category.getViewConfig())){
            category.setViewConfig(StringEscapeUtils.unescapeHtml4(category.getViewConfig()));
        }
		super.save(category);
		UserUtils.removeCache(CACHE_CATEGORY_LIST);
		CmsUtils.removeCache("mainNavList_"+category.getSite().getId());
	}
	
	@Transactional(readOnly = false)
	public void delete(Category category) {
		super.delete(category);
		UserUtils.removeCache(CACHE_CATEGORY_LIST);
		CmsUtils.removeCache("mainNavList_"+category.getSite().getId());
	}
	
	/**
	 * 通过编号获取栏目列表
	 */
	public List<Category> findByIds(String ids) {
		List<Category> list = Lists.newArrayList();
		String[] idss = StringUtils.split(ids,",");
		if (idss.length>0){
//			List<Category> l = dao.findByIdIn(idss);
//			for (String id : idss){
//				for (Category e : l){
//					if (e.getId().equals(id)){
//						list.add(e);
//						break;
//					}
//				}
//			}
			for(String id : idss){
				Category e = dao.get(id);
				if(null != e){
					//System.out.println("e.id:"+e.getId()+",e.name:"+e.getName());
					list.add(e);
				}
				//list.add(dao.get(id));
				
			}
		}
		return list;
	}
	
}
