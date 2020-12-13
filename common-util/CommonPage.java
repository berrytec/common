package util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页工具类
 * Create by Levc on 2020/10/24 : 12:56 上午
 */
public class CommonPage<T> {
    // 当前页数
    private Integer pageNum;
    // 分页大小
    private Integer pageSize;
    // 总页数
    private Long totalPage;
    //分页中的页数
    private List<T> list;

    public CommonPage() {
    }

    public static <T> CommonPage<T> page(List<T> list) {
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotalPage(pageInfo.getTotal());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }

    @Override
    public String toString() {
        return "CommonPage{" + "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
