package com.swifts.frame.modules.sys.listener;

import javax.servlet.ServletContext;

import com.swifts.frame.common.utils.SpringContextHolder;
import com.swifts.frame.modules.sys.service.OfficeService;
import com.swifts.frame.modules.sys.service.SystemService;
import org.springframework.web.context.WebApplicationContext;

public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {

	@Override
	public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
		if (!SystemService.printKeyLoadMessage()){
			return null;
		}
		WebApplicationContext webApplicationContext=super.initWebApplicationContext(servletContext);
		//TODO 添加
		return webApplicationContext;
	}
}
