package com.swifts.frame.modules.wx.fastweixin.company.api.entity;

import com.swifts.frame.modules.wx.fastweixin.api.entity.BaseModel;

/**
 *  企业通讯录-标签
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  @since 1.3.6
 *  ====================================================================
 */
public class QYTag extends BaseModel {

    private String tagname;
    private Integer tagid;

    public QYTag() {
    }

    public QYTag(String tagname) {
        this.tagname = tagname;
    }

    public QYTag(String tagname, Integer tagid) {
        this.tagname = tagname;
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }
}
