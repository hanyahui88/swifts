/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.test.service;

import java.util.List;

import com.swifts.frame.common.utils.JedisUtils;
import com.swifts.frame.common.utils.SpringContextHolder;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.common.service.CrudService;
import com.swifts.frame.modules.test.entity.TestData;
import com.swifts.frame.modules.test.dao.TestDataDao;

/**
 * 测试生成表Service
 * @author alvin
 * @version 2016-01-07
 */
@Service
@Transactional(readOnly = true)
@CacheConfig(cacheNames = "default")
public class TestDataService extends CrudService<TestDataDao, TestData> {

	public TestData get(String id) {
		return super.get(id);
	}
	public List<TestData> findList(TestData testData) {
		return super.findList(testData);
	}
	
	public PageInfo<TestData> findPage(int pageNum,int pageSize,  TestData testData) {
		return super.findPage(pageNum,pageSize, testData);
	}
	
	@Transactional(readOnly = false)
	public void save(TestData testData) {
		super.save(testData);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestData testData) {
		super.delete(testData);
	}
	
}