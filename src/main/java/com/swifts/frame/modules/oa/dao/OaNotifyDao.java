/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.oa.dao;

import com.swifts.frame.common.persistence.CrudDao;
import com.swifts.frame.common.persistence.annotation.MyBatisDao;
import com.swifts.frame.modules.oa.entity.OaNotify;

/**
 * 通知通告DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface OaNotifyDao extends CrudDao<OaNotify> {
	
	/**
	 * 获取通知数目
	 * @param oaNotify
	 * @return
	 */
	public Long findCount(OaNotify oaNotify);
	
}