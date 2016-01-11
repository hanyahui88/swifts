package com.swifts.frame.modules.wx.fastweixin.company.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.response.BaseResponse;

/**
 *  Response -- 创建新标签
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class CreateTagResponse extends BaseResponse {

    private Integer tagid;

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}
