package com.swifts.frame.modules.wx.fastweixin.company.message;

import com.swifts.frame.modules.wx.fastweixin.api.entity.Article;

/**
 *  
 *  ====================================================================
 *
 *  --------------------------------------------------------------------
 *  @author Nottyjay
 *  @version 1.0.beta
 *  ====================================================================
 */
public class QYMpArticle extends Article {

    public QYMpArticle(String thumbMediaId, String author, String title, String contentSourceUrl, String content, String digest, Integer showConverPic) {
        super(thumbMediaId, author, title, contentSourceUrl, content, digest, showConverPic);
    }

}
