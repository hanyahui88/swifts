package com.swifts.frame.modules.wx.fastweixin.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.entity.UpstreamMsgDistWeek;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUpstreamMsgDistWeekResponse extends BaseResponse {

    private List<UpstreamMsgDistWeek> list;

    public List<UpstreamMsgDistWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistWeek> list) {
        this.list = list;
    }
}
