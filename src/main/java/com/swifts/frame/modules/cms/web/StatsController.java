/**
 * Copyright &copy; 2015-2016 <a href="https://github.com/hanyahui88/swifts">swifts</a> All rights reserved.
 */
package com.swifts.frame.modules.cms.web;

import java.util.List;
import java.util.Map;

import com.swifts.frame.common.pagehelper.PageHelper;
import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.common.web.BaseController;
import com.swifts.frame.modules.cms.entity.Category;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swifts.frame.modules.cms.service.StatsService;

import javax.servlet.http.HttpServletRequest;

/**
 * 统计Controller
 * @author ThinkGem
 * @version 2013-5-21
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/stats")
public class StatsController extends BaseController {

	@Autowired
	private StatsService statsService;
	
	/**
	 * 文章信息量
	 * @param paramMap
	 * @param model
	 * @return
	 */
	@RequiresPermissions("cms:stats:article")
	@RequestMapping(value = "article")
	public String article(@RequestParam Map<String, Object> paramMap, Model model, HttpServletRequest request) {
		PageHelper.startPage(super.getPageNum(request),super.getPageSize(request),true);
		PageInfo<Category> categoryPageInfo=new PageInfo<>(statsService.article(paramMap));
		model.addAttribute("page", categoryPageInfo);
		model.addAttribute("paramMap", paramMap);
		return "modules/cms/statsArticle";
	}

}
