/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.act.dao;

import com.swifts.frame.common.persistence.CrudDao;
import com.swifts.frame.common.persistence.annotation.MyBatisDao;
import com.swifts.frame.modules.act.entity.Act;

/**
 * 审批DAO接口
 * @author admin
 * @version 2014-05-16
 */
@MyBatisDao
public interface ActDao extends CrudDao<Act> {

	public int updateProcInsIdByBusinessId(Act act);
	
}
