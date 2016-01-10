package com.swifts.frame.modules.fastweixin.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.swifts.frame.modules.fastweixin.api.response.BaseResponse;
import com.swifts.frame.modules.fastweixin.company.api.entity.QYTag;

import java.util.List;

/**
 *  Response -- 获取标签列表
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class GetTagListResponse extends BaseResponse {

    @JSONField(name = "taglist")
    private List<QYTag> tags;

    public List<QYTag> getTags() {
        return tags;
    }

    public void setTags(List<QYTag> tags) {
        this.tags = tags;
    }
}
