/**
 * There are <a href="https://github.com/hanyahui88/swifts">swifts</a> code generation
 */
package com.swifts.frame.modules.oa.dao;

import com.swifts.frame.common.persistence.CrudDao;
import com.swifts.frame.modules.oa.entity.Leave;
import com.swifts.frame.common.persistence.annotation.MyBatisDao;

/**
 * 请假DAO接口
 * @author liuj
 * @version 2013-8-23
 */
@MyBatisDao
public interface LeaveDao extends CrudDao<Leave> {
	
	/**
	 * 更新流程实例ID
	 * @param leave
	 * @return
	 */
	public int updateProcessInstanceId(Leave leave);
	
	/**
	 * 更新实际开始结束时间
	 * @param leave
	 * @return
	 */
	public int updateRealityTime(Leave leave);
	
}
