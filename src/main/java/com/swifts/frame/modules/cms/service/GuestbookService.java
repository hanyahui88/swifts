/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.cms.service;

import com.swifts.frame.common.pagehelper.PageHelper;
import com.swifts.frame.common.service.CrudService;
import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.modules.cms.entity.Guestbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swifts.frame.modules.cms.dao.GuestbookDao;

/**
 * 留言Service
 * @author ThinkGem
 * @version 2013-01-15
 */
@Service
@Transactional(readOnly = true)
public class GuestbookService extends CrudService<GuestbookDao, Guestbook> {

	public Guestbook get(String id) {
		return dao.get(id);
	}
	
	public PageInfo<Guestbook> findPage(int pageNum,int pageSize, Guestbook guestbook) {
//		DetachedCriteria dc = dao.createDetachedCriteria();
//		if (StringUtils.isNotEmpty(guestbook.getType())){
//			dc.add(Restrictions.eq("type", guestbook.getType()));
//		}
//		if (StringUtils.isNotEmpty(guestbook.getContent())){
//			dc.add(Restrictions.like("content", "%"+guestbook.getContent()+"%"));
//		}
//		dc.add(Restrictions.eq(Guestbook.FIELD_DEL_FLAG, guestbook.getDelFlag()));
//		dc.addOrder(Order.desc("createDate"));
//		return dao.find(page, dc);
		PageHelper.startPage(pageNum,pageSize,true);
		guestbook.getSqlMap().put("dsf", dataScopeFilter(guestbook.getCurrentUser(), "o", "u"));
		PageInfo<Guestbook> page=new PageInfo<>(dao.findList(guestbook));
		return page;
	}
	
	@Transactional(readOnly = false)
	public void delete(Guestbook guestbook, Boolean isRe) {
		//dao.updateDelFlag(id, isRe!=null&&isRe?Guestbook.DEL_FLAG_AUDIT:Guestbook.DEL_FLAG_DELETE);
		dao.delete(guestbook);
	}
	
	/**
	 * 更新索引
	 */
	public void createIndex(){
		//dao.createIndex();
	}
	
	/**
	 * 全文检索
	 */
	//FIXME 暂不提供
	public PageInfo<Guestbook> search(int pageNum,int pageSize, String q, String beginDate, String endDate){
		
		// 设置查询条件
//		BooleanQuery query = dao.getFullTextQuery(q, "name","content","reContent");
//		
//		// 设置过滤条件
//		List<BooleanClause> bcList = Lists.newArrayList();
//
//		bcList.add(new BooleanClause(new TermQuery(new Term(Guestbook.FIELD_DEL_FLAG, Guestbook.DEL_FLAG_NORMAL)), Occur.MUST));
//		
//		if (StringUtils.isNotBlank(beginDate) && StringUtils.isNotBlank(endDate)) {   
//			bcList.add(new BooleanClause(new TermRangeQuery("createDate", beginDate.replaceAll("-", ""),
//					endDate.replaceAll("-", ""), true, true), Occur.MUST));
//		}
//
//		bcList.add(new BooleanClause(new TermQuery(new Term("type", "1")), Occur.SHOULD));
//		bcList.add(new BooleanClause(new TermQuery(new Term("type", "2")), Occur.SHOULD));
//		bcList.add(new BooleanClause(new TermQuery(new Term("type", "3")), Occur.SHOULD));
//		bcList.add(new BooleanClause(new TermQuery(new Term("type", "4")), Occur.SHOULD));
//		
//		BooleanQuery queryFilter = dao.getFullTextQuery((BooleanClause[])bcList.toArray(new BooleanClause[bcList.size()]));
//
//		System.out.println(queryFilter);
//		
//		// 设置排序（默认相识度排序）
//		Sort sort = null;//new Sort(new SortField("updateDate", SortField.DOC, true));
//		// 全文检索
//		dao.search(page, query, queryFilter, sort);
//		// 关键字高亮
//		dao.keywordsHighlight(query, page.getList(), 30, "name");
//		dao.keywordsHighlight(query, page.getList(), 1300, "content");
//		dao.keywordsHighlight(query, page.getList(), 1300, "reContent");
		
		return null;
	}
	
}
