package com.swifts.frame.modules.fastweixin.api.response;

import com.swifts.frame.modules.fastweixin.api.entity.Menu;

/**
 * @author peiyu
 */
public class GetMenuResponse extends BaseResponse {

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
