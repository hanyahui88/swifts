/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.test.dao;

import com.swifts.frame.common.persistence.CrudDao;
import com.swifts.frame.common.persistence.annotation.MyBatisDao;
import com.swifts.frame.modules.test.entity.TestData;

/**
 * 测试生成表DAO接口
 * @author alvin
 * @version 2016-01-07
 */
@MyBatisDao
public interface TestDataDao extends CrudDao<TestData> {
	
}