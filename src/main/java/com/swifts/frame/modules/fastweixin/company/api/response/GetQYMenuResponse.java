package com.swifts.frame.modules.fastweixin.company.api.response;

import com.swifts.frame.modules.fastweixin.api.response.BaseResponse;
import com.swifts.frame.modules.fastweixin.company.api.entity.QYMenu;

/**
 *  Response -- 获取菜单
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class GetQYMenuResponse extends BaseResponse {

    private QYMenu menu;

    public QYMenu getMenu() {
        return menu;
    }

    public void setMenu(QYMenu menu) {
        this.menu = menu;
    }
}
