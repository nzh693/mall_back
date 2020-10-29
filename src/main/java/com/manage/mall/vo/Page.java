package com.manage.mall.vo;

/***
 * 分页实体
 * @param <T>
 */
public class Page<T> {


    private static final Integer PAGE_CAPITAL=10;

    private Integer curPage;//当前页

    private Integer startIndex;//起始下标

    private Integer pageSize=PAGE_CAPITAL;//页大小

    private Integer totalCount;//数据总条数

    private Integer totalpage;//总页数

    private T data;//页数据

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void Page(Integer curPage,Integer pageSize ,Integer startIndex,Integer totalCount,Integer totalpage,T data){
        this.curPage=curPage;
        this.startIndex=startIndex;
        this.totalCount=totalCount;
        this.totalpage=totalpage;
        this.pageSize=pageSize;
        setData(data);

    }
    public void Page(Integer curPage,Integer startIndex,Integer totalCount){
        this.curPage=curPage;
        this.startIndex=startIndex;
        this.totalCount=totalCount;

    }

    @Override
    public String toString() {
        return "Page{" +
                "curPage=" + curPage +
                ", startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalpage=" + totalpage +
                ", data=" + data +
                '}';
    }
}
