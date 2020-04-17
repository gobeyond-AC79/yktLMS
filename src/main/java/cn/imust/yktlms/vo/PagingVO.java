package cn.imust.yktlms.vo;


/**
 * 分页信息实体类
 * @author SERENDIPITY
 */
public class PagingVO {

    /**
     * 当前页码,默认第一页
     */
    private Integer curentPageNo = 1;

    /**
     * 总页数
     */
    private Integer totalCount;

    /**
     * 页面容量
     */
    private Integer pageSize=8;

    /**
     * 上一页
     */
    private Integer upPageNo;

    /**
     * 下一页
     */
    private Integer nextPageNo;

    /**
     * 要前往的页码，默认0
     */
    private Integer toPageNo = 0;

    public void setToPageNo(Integer toPageNo) {
        //新一页
        this.toPageNo = (toPageNo-1) * pageSize ;
        //设置跳转后当前的页码
        setCurentPageNo(toPageNo);
    }

    public Integer getTopageNo() {
        return toPageNo;
    }

    public int getCurentPageNo() {
        return curentPageNo;
    }

    //设置当前页码
    public void setCurentPageNo(int curentPageNo) {
        if (curentPageNo != 1) {
            this.upPageNo = curentPageNo - 1;
        }
        this.nextPageNo = curentPageNo + 1;

        this.curentPageNo = curentPageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount%pageSize > 0) {
            this.totalCount = (totalCount/pageSize)+1;
        } else {
            this.totalCount = totalCount/pageSize;
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUpPageNo() {
        return upPageNo;
    }

    public void setUpPageNo(int upPageNo) {
        this.upPageNo = upPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }
}

