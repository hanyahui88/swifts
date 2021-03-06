package com.swifts.frame.modules.wx.fastweixin.company.api.handle;

import com.swifts.frame.modules.wx.fastweixin.company.api.config.QYConfigChangeNotice;
import com.swifts.frame.modules.wx.fastweixin.handle.ApiConfigChangeHandle;
import com.swifts.frame.modules.wx.fastweixin.util.BeanUtil;

import java.util.Observable;

/**
 *  
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public abstract class AbstractQYApiConfigChangeHandle implements ApiConfigChangeHandle{

    public void update(Observable o, Object arg){
        if(BeanUtil.nonNull(arg) && arg instanceof QYConfigChangeNotice){
            configChange((QYConfigChangeNotice) arg);
        }
    }

    /**
     * 子类实现，当配置变化时触发该方法
     * @param notice 消息
     */
    public abstract void configChange(QYConfigChangeNotice notice);
}
