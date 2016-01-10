package com.swifts.frame.modules.fastweixin.company.message;

import com.swifts.frame.modules.fastweixin.message.Article;

/**
 *  
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class QYArticle extends Article {

    private String picurl;

    public QYArticle(String title, String description, String picUrl, String url) {
        super(title, description, null, url);
        this.picurl = picUrl;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}
