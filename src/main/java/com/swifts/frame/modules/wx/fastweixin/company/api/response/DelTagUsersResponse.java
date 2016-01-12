package com.swifts.frame.modules.wx.fastweixin.company.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.response.BaseResponse;

import java.util.List;

/**
 *  Response -- 删除标签内成员
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class DelTagUsersResponse extends BaseResponse {
    private String invalidlist;
    private List<Integer> invalidparty;

    public String getInvalidlist() {
        return invalidlist;
    }

    public void setInvalidlist(String invalidlist) {
        this.invalidlist = invalidlist;
    }

    public List<Integer> getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(List<Integer> invalidparty) {
        this.invalidparty = invalidparty;
    }
}
