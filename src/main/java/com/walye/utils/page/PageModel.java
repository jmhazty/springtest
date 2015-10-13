package com.walye.utils.page;

import java.util.List;

public class PageModel<T> {  
    
    public static final int TEXT_MODEL = 1;  
      
    public static final int NUM_MODEL = 2;  
      
    private int model = 1;  
      
    private String url;  
      
    private Page<T> page = null;  
      
    private StringBuffer strHtml = null;  
  
      
    private int numCount = 5;  
  
      
    public PageModel(Page<T> page, String url) {  
        super();  
        this.url = url;  
        this.page = page;  
    }  
      
    public PageModel(Page<T> page, String url, int model) {  
        super();  
        this.model = model;  
        this.url = url;  
        this.page = page;  
    }  
      
    public PageModel(Page<T> page, String url, int model, int numCount) {  
        super();  
        this.model = model;  
        this.url = url;  
        this.page = page;  
        this.numCount = numCount;  
    }  
      
    public String getPageModel() {  
        // 组装页码模型  
        createURL();  
        return createModel();  
    }  
  
      
    private void createURL() {  
        url = url.contains("?") ? url + "&page=" : url + "?page=";  
    }  
  
      
    private String createModel() {  
        strHtml = new StringBuffer();  
        switch (model) {  
        case TEXT_MODEL:// 文本模型  
            buildTextModel();  
            break;  
        case NUM_MODEL:// 数字模型  
            buildNumModel();  
            break;  
        default:// 文本模型  
            buildTextModel();  
            break;  
        }  
        return strHtml.toString();  
    }  
  
      
    private void buildNumModel() {  
        int currentPage = page.getCurrentPage();  
        int countPage = page.getCountPage();  
        strHtml.append(  
                "<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")  
                .append("<tr><td height='24' align='center'>");  
        // 构造格式：第一页 1 2 3 4 5 最后一页  
        PageIndex pageIndex = PageIndex.getPageIndex(numCount, currentPage,  
                countPage);  
        // 不是第一页时，显示首页  
        if (currentPage > 1) {  
            strHtml.append("<a href='").append(url)  
                    .append("1'>首页</a>&nbsp;&nbsp;");  
        }  
        if (currentPage <= countPage) {  
            for (int i = pageIndex.getStartIndex(); i <= pageIndex  
                    .getEndIndex(); i++) {  
                // 当前页加粗  
                if (currentPage == i) {  
                    strHtml.append("<b>").append(i).append("</b>&nbsp;&nbsp;");  
                } else {  
                    strHtml.append("<a href='").append(url).append(i)  
                            .append("'>").append(i).append("</a>&nbsp;&nbsp;");  
                }  
            }  
            // 不是最后一页显示末页  
            if (currentPage < countPage) {  
                strHtml.append("<a href='").append(url).append(countPage)  
                        .append("'>末页</a>");  
            }  
        }  
        strHtml.append("</td></tr></table>");  
    }  
  
      
    private void buildTextModel() {  
        int currentPage = page.getCurrentPage();  
        int countPage = page.getCountPage();  
        strHtml.append(  
                "<table width='100%'  border='0' cellspacing='0' cellpadding='0'>")  
                .append("<tr> <td height='24' align='center'>当前页数：[")  
                .append(currentPage).append("/").append(countPage)  
                .append("]&nbsp;&nbsp;");  
        if (currentPage > 1) {  
            strHtml.append("<a href='").append(url).append("1'>首页</a>")  
                    .append("&nbsp;&nbsp;<a href='").append(url)  
                    .append(currentPage - 1).append("'>上一页</a>");  
        }  
        if (currentPage < countPage) {  
            strHtml.append("&nbsp;&nbsp;<a href='").append(url)  
                    .append(currentPage + 1)  
                    .append("'>下一页</a>&nbsp;&nbsp;<a href='").append(url)  
                    .append(countPage).append("'>末页</a>");  
        }  
        strHtml.append("</td></tr></table>");  
    }  
  
    public List<T> getList() {  
        return page.getList();  
    }  
}  