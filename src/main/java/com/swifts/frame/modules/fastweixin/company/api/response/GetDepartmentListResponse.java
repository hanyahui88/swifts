package com.swifts.frame.modules.fastweixin.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.swifts.frame.modules.fastweixin.api.response.BaseResponse;
import com.swifts.frame.modules.fastweixin.company.api.entity.QYDepartment;

import java.util.List;

/**
 *  
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class GetDepartmentListResponse extends BaseResponse {

    @JSONField(name = "department")
    private List<QYDepartment> departments;

    public List<QYDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<QYDepartment> departments) {
        this.departments = departments;
    }
}
