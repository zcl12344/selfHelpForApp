package com.springboot.tongyuyan.selfhelp.tool.responestool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * 
 * 分页转换
 * 
* @ClassName: PageEx
* @Description: TODO
* @yangchoa.cool@gmail.com
* @date 2017年7月29日 下午2:18:35
*
 */
public class BasePageEx<T>  implements Serializable {
	/**
	* @Fields serialVersionUID :
	*/
	
	private static final long serialVersionUID = 6000937383097489450L;
	
	private Integer pages;//总页数
	
	private Integer pageNum =1;//当前页数
	

    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;

    //由于startRow和endRow不常用，这里说个具体的用法
    //可以在页面中"显示startRow到endRow 共size条数据"

    //当前页面第一个元素在数据库中的行号
    private int startRow;
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    //总记录数
    private long total;
  
    //前一页
    private int prePage;
    //下一页
    private int nextPage;

    //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    //导航页码数
    private int navigatePages;
    //所有导航页号
    private int[] navigatepageNums;
    //导航条上的第一页
    private int navigateFirstPage;
    //导航条上的最后一页
    private int navigateLastPage;
    
    

	private List<T> data = new ArrayList<T>();//数据
	
	
	
	
	public BasePageEx() {
		super();
	}

	public BasePageEx(Page<T> page) {
		PageInfo<T> pageInfo = page.toPageInfo();
		
		try {
			BeanUtils.copyProperties(pageInfo, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.pages = pageInfo.getPages();
		
		this.pageNum = pageInfo.getPageNum();
		
		data.addAll(pageInfo.getList());
		
		
		
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}


	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public int getNavigateFirstPage() {
		return navigateFirstPage;
	}

	public void setNavigateFirstPage(int navigateFirstPage) {
		this.navigateFirstPage = navigateFirstPage;
	}

	public int getNavigateLastPage() {
		return navigateLastPage;
	}

	public void setNavigateLastPage(int navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}



	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getPageNum() {
		return null == pageNum ? 1 : pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	@Override
	public String toString() {
		return "BasePageEx [pages=" + pages + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", size=" + size
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", total=" + total + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + ", isFirstPage=" + isFirstPage + ", isLastPage=" + isLastPage
				+ ", hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage + ", navigatePages="
				+ navigatePages + ", navigatepageNums=" + Arrays.toString(navigatepageNums) + ", navigateFirstPage="
				+ navigateFirstPage + ", navigateLastPage=" + navigateLastPage + ", data=" + data + "]";
	}

}
