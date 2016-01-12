package com.swifts.frame.modules.wx.fastweixin.api.enums;

/**
 * 微信事件类型
 * Created by yahui on 2016/1/10.
 */
public enum EventType {
    /**
     * 点击事件
     */
    CLICK("click"),
    /**
     * 关注事件
     */
    SUBSCRIBE("subscribe"),
    /**
     * 取消关注事件
     */
    UNSUBSCRIBE("unsubscribe"),
    scan("scan"),
    report_location("report_location"),
    view("view"),
    scan_code("scan_code"),
    pic("pic"),
    location_select("location_select"),
    mass_send_jon_finish("mass_send_jon_finish"),
    template_send_jon_finish("template_send_jon_finish");


    String value;

    EventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
