package com.swifts.frame.modules.fastweixin.company.api.response;/**
 * Created by Nottyjay on 2015/6/11.
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.swifts.frame.modules.fastweixin.api.response.BaseResponse;
import com.swifts.frame.modules.fastweixin.company.api.entity.QYUser;

import java.util.List;

/**
 * ====================================================================
 *
 * --------------------------------------------------------------------
 *
 * @author Nottyjay
 * @version 1.0.beta
 *          ====================================================================
 */
public class GetQYUserInfo4DepartmentResponse extends BaseResponse {

    @JSONField(name = "userlist")
    public List<QYUser> userList;

    public List<QYUser> getUserList() {
        return userList;
    }

    public void setUserList(List<QYUser> userList) {
        this.userList = userList;
    }
}