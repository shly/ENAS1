package com.neusoft.utils;

public class PageHelper {

	/**
	 * 当前页
	 */
	private int pageNo = 1;
	/**
	 * 开始页
	 */
	private int beginPage=1;//从第一页开始，默认
	/**
	 * 每一页的条数
	 */
	private int pageSize = 3;
	/**
	 * 总条数
	 */
	private int countItems;
	/**
	 * 总页数
	 */
	private int countPages;
	/**
	 * 显示信息
	 */
	
	public PageHelper(){
		this.beginPage=1;
		this.pageSize=10;
	}
	
	public PageHelper(int beginPage,int pageSize)
	{
		this.beginPage=beginPage;
		this.pageSize=pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCountItems() {
		return countItems;
	}
	public void setCountItems(int countItems) {
		this.countItems = countItems;
	}
	public int getCountPages() {
		if (countItems % pageSize == 0) {
			countPages = countItems / pageSize;
		} else {
			countPages = countItems / pageSize + 1;
		}
		return countPages;
	}
	public void setCountPages(int countPages) {
		this.countPages = countPages;
	}
}
