package com.swifts.frame.modules.wx.fastweixin.api.entity;

import com.swifts.frame.modules.wx.fastweixin.util.JSONUtil;

/**
 * 抽象实体类
 *
 * @author peiyu
 */
public abstract class BaseModel implements Model {
    @Override
    public String toJsonString() {
        return JSONUtil.toJson(this);
    }
}
