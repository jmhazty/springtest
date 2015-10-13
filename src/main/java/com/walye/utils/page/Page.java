package com.walye.utils.page;

import java.util.List;

public class Page<T> {  
    
    private int countPage;  
      
    private int countRecord;  
      
    private int currentPage = 1;  
      
    private List<T> list = null;  
      
    private int onePageCount = 10;  
      
    private int startIndex;  
  
    public Page() {  
    }  
  
      
    public Page(int currentPage, int countRecord) {  
        this.currentPage = currentPage;  
        this.countRecord = countRecord;  
        calculate();  
    }  
  
      
    public Page(int currentPage, int countRecord, int onePageCount) {  
        super();  
        this.countRecord = countRecord;  
        this.currentPage = currentPage;  
        this.onePageCount = onePageCount;  
        calculate();  
    }  
  
      
    private void calculate() {  
        // 计算开始索引  
        this.startIndex = (currentPage - 1) * onePageCount;  
        // 计算总页数  
        this.countPage = (countRecord % onePageCount == 0) ? (countRecord / onePageCount)  
                : (countRecord / onePageCount + 1);  
    }  
  
    public int getCountPage() {  
        return countPage;  
    }  
  
    public int getCountRecord() {  
        return countRecord;  
    }  
  
    public int getCurrentPage() {  
        return currentPage;  
    }  
  
    public List<T> getList() {  
        return list;  
    }  
  
    public int getOnePageCount() {  
        return onePageCount;  
    }  
  
    public int getStartIndex() {  
        return startIndex;  
    }  
  
    public void setCountPage(int countPage) {  
        this.countPage = countPage;  
    }  
  
    public void setCountRecord(int countRecord) {  
        this.countRecord = countRecord;  
    }  
  
    public void setCurrentPage(int currentPage) {  
        this.currentPage = currentPage;  
    }  
  
    public void setList(List<T> list) {  
        this.list = list;  
    }  
  
    public void setOnePageCount(int onePageCount) {  
        this.onePageCount = onePageCount;  
    }  
  
    public void setStartIndex(int startIndex) {  
        this.startIndex = startIndex;  
    }  
}  
