/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.sys.service;

import com.swifts.frame.common.pagehelper.PageHelper;
import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.common.service.TreeService;
import com.swifts.frame.modules.sys.dao.OfficeDao;
import com.swifts.frame.modules.sys.entity.Office;
import com.swifts.frame.modules.sys.utils.UserUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 机构Service
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = {"default"})
public class OfficeService extends TreeService<OfficeDao, Office> {
    public List<Office> findAll() {
        return UserUtils.getOfficeList();
    }
    public List<Office> findList(Boolean isAll) {
        if (isAll != null && isAll) {
            return UserUtils.getOfficeAllList();
        } else {
            return UserUtils.getOfficeList();
        }
    }

    @Transactional(readOnly = true)
    public List<Office> findList(Office office) {
        if (office != null) {
            office.setParentIds(office.getParentIds() + "%");
            return dao.findByParentIdsLike(office);
        }
        return new ArrayList<Office>();
    }

    @Transactional(readOnly = false)
    public void save(Office office) {
        super.save(office);
        UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
    }

    @Transactional(readOnly = false)
    public void delete(Office office) {
        super.delete(office);
        UserUtils.removeCache(UserUtils.CACHE_OFFICE_LIST);
    }


    public PageInfo<Office> findPage(){
        Office office=new Office();
        PageInfo<Office> officePageInfo=new PageInfo<>();
        officePageInfo.setPageSize(4);
        officePageInfo.setPageNum(1);
        officePageInfo.setList(dao.findList(office));
        return null;
    }
    public PageInfo<Office> findPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize,true);
        Office office=new Office();
        PageInfo<Office> page=new PageInfo<>(dao.findList(office));
        return page;
    }

}
