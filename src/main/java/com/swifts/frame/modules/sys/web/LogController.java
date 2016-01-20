/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.common.web.BaseController;
import com.swifts.frame.modules.sys.entity.Log;
import com.swifts.frame.modules.sys.service.LogService;

/**
 * 日志Controller
 * @author ThinkGem
 * @version 2013-6-2
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/log")
public class LogController extends BaseController {

	@Autowired
	private LogService logService;
	
	@RequiresPermissions("sys:log:view")
	@RequestMapping(value = {"list", ""})
	public String list(Log log, HttpServletRequest request, HttpServletResponse response, Model model) {
        PageInfo<Log> page = logService.findPage(super.getPageNum(request),super.getPageSize(request),log);
        model.addAttribute("page", page);
		return "modules/sys/logList";
	}

}
