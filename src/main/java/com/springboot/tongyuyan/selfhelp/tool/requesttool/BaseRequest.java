package com.springboot.tongyuyan.selfhelp.tool.requesttool;



import java.io.Serializable;

/**
 *
 * @ClassName: CommonQueryDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @yangchoa.cool@gmail.com
 * @date 2017年7月28日 下午5:32:36
 *
 */
public class BaseRequest implements Serializable {
    /**
     * @Fields serialVersionUID
     */

    private static final long serialVersionUID = 6661424981957689006L;

    private Integer currentPage = 1;

    private Integer pageNum = 1;

    private Integer pageSize = 6;

    //商品添加
    private Integer productpageSize=100;

    public BaseRequest() {
    }

    public BaseRequest(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getProductpageSize() {
        return productpageSize;
    }

    public void setProductpageSize(Integer productpageSize) {
        this.productpageSize = productpageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageNum() {
        return null == pageNum ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "CommonQueryDTO [currentPage=" + currentPage + ", pageNum=" + pageNum + "]";
    }

}
