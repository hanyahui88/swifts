/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.swifts.frame.test.dao;

import com.swifts.frame.common.persistence.TreeDao;
import com.swifts.frame.common.persistence.annotation.MyBatisDao;
import com.swifts.frame.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * @author ThinkGem
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}