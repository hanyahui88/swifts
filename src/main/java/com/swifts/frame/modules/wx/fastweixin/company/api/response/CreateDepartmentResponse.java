package com.swifts.frame.modules.wx.fastweixin.company.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.response.BaseResponse;

/**
 *  
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class CreateDepartmentResponse extends BaseResponse {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CreateDepartmentResponse{" +
                "id=" + id +
                '}';
    }
}
