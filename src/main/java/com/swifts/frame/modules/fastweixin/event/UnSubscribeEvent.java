package com.swifts.frame.modules.fastweixin.event;

import com.swifts.frame.modules.fastweixin.handle.EventHandle;
import com.swifts.frame.modules.fastweixin.message.BaseMsg;
import com.swifts.frame.modules.fastweixin.message.req.BaseEvent;

/**
 * 取消关注事件
 * Created by yahui on 2016/1/10.
 */
public class UnSubscribeEvent implements EventHandle<BaseEvent> {
    @Override
    public BaseMsg handle(BaseEvent event) {
        return null;
    }

    @Override
    public boolean beforeHandle(BaseEvent event) {
        return false;
    }
}
