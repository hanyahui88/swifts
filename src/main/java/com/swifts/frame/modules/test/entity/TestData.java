/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.swifts.frame.common.persistence.DataEntity;

/**
 * 测试生成表Entity
 * @author alvin
 * @version 2016-01-07
 */
public class TestData extends DataEntity<TestData> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	
	public TestData() {
		super();
	}

	public TestData(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}