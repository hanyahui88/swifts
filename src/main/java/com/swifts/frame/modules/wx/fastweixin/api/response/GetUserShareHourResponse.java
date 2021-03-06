package com.swifts.frame.modules.wx.fastweixin.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.entity.UserShareHour;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserShareHourResponse extends BaseResponse {

    private List<UserShareHour> list;

    public List<UserShareHour> getList() {
        return list;
    }

    public void setList(List<UserShareHour> list) {
        this.list = list;
    }
}
