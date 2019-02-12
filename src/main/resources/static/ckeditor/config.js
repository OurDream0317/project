/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';

    // 图片上传相关
    config.filebrowserImageUploadUrl = '/context/uploadpath'; // 上传图片 的 Action
    config.image_previewText = ' '; // 图片信息面板预览区内容的文字内容，默认显示CKEditor自带的内容
    config.removeDialogTabs = 'image:advanced;image:Link'; // 移除图片上传页面的'高级','链接'页签

    //config.language = 'zh-cn'; // 配置语言
    //config.skin = 'kama';// 界面v2,kama,office2003
    //config.toolbar = 'MyToolbar';// 工具栏风格（基础'Basic'、全能'Full'、自定义）

    config.font_names='宋体/SimSun;新宋体/NSimSun;仿宋_GB2312/FangSong_GB2312;楷体_GB2312/KaiTi_GB2312;黑体/SimHei;微软雅黑/Microsoft YaHei;'+ config.font_names;
};
