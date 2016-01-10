package com.swifts.frame.modules.fastweixin.company.api.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.swifts.frame.modules.fastweixin.api.response.BaseResponse;
import com.swifts.frame.modules.fastweixin.company.api.entity.QYAgent;

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
public class GetQYAgentListResponse extends BaseResponse {

    @JSONField(name = "agentlist")
    public List<QYAgent> agentList;

    public List<QYAgent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<QYAgent> agentList) {
        this.agentList = agentList;
    }
}
