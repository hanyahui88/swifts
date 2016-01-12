package com.swifts.frame.modules.wx.fastweixin.company.api.response;/**
 * Created by Nottyjay on 2015/6/11.
 */

import com.swifts.frame.modules.wx.fastweixin.api.response.BaseResponse;

/**
 * ====================================================================
 *
 * --------------------------------------------------------------------
 *
 * @author Nottyjay
 * @version 1.0.beta
 *          ====================================================================
 */
public class GetQYUserInviteResponse extends BaseResponse {
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
