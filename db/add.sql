-- 添加第三方登陆的字段
ALTER TABLE sys_user add COLUMN qq_open_id VARCHAR(255) COMMENT 'qq的openid' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wx_open_id VARCHAR(255) COMMENT '微信的openid' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wb_open_id VARCHAR(255) COMMENT '微博的openid' AFTER `photo`;
ALTER TABLE sys_user add COLUMN qq_nickname VARCHAR(255) COMMENT 'qq的昵称' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wx_nickname VARCHAR(255) COMMENT '微信的昵称' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wb_nickname VARCHAR(255) COMMENT '微博的昵称' AFTER `photo`;
ALTER TABLE sys_user add COLUMN qq_avatar VARCHAR(255) COMMENT 'qq的头像' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wx_avatar VARCHAR(255) COMMENT '微信的头像' AFTER `photo`;
ALTER TABLE sys_user add COLUMN wb_avatar VARCHAR(255) COMMENT '微博的头像' AFTER `photo`;