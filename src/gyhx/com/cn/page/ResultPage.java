package gyhx.com.cn.page;

import java.util.List;

public class ResultPage<T> {
    private List<T> list;//页面的数据
    private int page;//当前页
    private int pageCount;//总页数
    private int count;//总共多少记录

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ResultPage{" +
                "list=" + list +
                ", page=" + page +
                ", pageCount=" + pageCount +
                ", count=" + count +
                '}';
    }
}
