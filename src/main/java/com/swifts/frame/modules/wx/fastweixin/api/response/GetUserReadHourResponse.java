package com.swifts.frame.modules.wx.fastweixin.api.response;

import com.swifts.frame.modules.wx.fastweixin.api.entity.UserReadHour;

import java.util.List;

/**
 * @author peiyu
 */
public class GetUserReadHourResponse extends BaseResponse {

    private List<UserReadHour> list;

    public List<UserReadHour> getList() {
        return list;
    }

    public void setList(List<UserReadHour> list) {
        this.list = list;
    }
}
