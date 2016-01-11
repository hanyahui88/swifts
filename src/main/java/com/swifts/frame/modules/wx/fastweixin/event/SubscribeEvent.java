package com.swifts.frame.modules.wx.fastweixin.event;

import com.swifts.frame.modules.wx.fastweixin.handle.EventHandle;
import com.swifts.frame.modules.wx.fastweixin.message.BaseMsg;
import com.swifts.frame.modules.wx.fastweixin.message.req.BaseEvent;

/**
 * 关注事件
 * Created by yahui on 2016/1/10.
 */
public class SubscribeEvent implements EventHandle<BaseEvent>{
    @Override
    public BaseMsg handle(BaseEvent event) {
        return null;
    }

    @Override
    public boolean beforeHandle(BaseEvent event) {

        return false;
    }
}
