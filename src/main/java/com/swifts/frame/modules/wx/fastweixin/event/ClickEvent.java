package com.swifts.frame.modules.wx.fastweixin.event;

import com.swifts.frame.modules.wx.fastweixin.handle.EventHandle;
import com.swifts.frame.modules.wx.fastweixin.message.BaseMsg;
import com.swifts.frame.modules.wx.fastweixin.message.req.BaseEvent;

/**
 * Created by yahui on 2016/1/10.
 */
public class ClickEvent implements EventHandle<BaseEvent>{
    @Override
    public BaseMsg handle(BaseEvent event) {
        return null;
    }

    @Override
    public boolean beforeHandle(BaseEvent event) {

        return false;
    }
}
