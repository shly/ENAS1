package com.neusoft.utils;

public class CutPage {

	/**
	 * 当前页
	 */
	private int pageNo = 1;
	/**
	 * 开始页
	 */
	private int beginPage;
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

	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 上一页
	 */
	private int prePage;
	
	/**
	 * 构造函数
	 */
	public CutPage() {
	}

	/**
	 * 带参数的构造函数
	 */

	public int getPageNo() {
		return pageNo;
	}

	public CutPage(int pageNo, int beginPage, int pageSize, int countItems,
			int countPages, int nextPage, int prePage) {
		super();
		this.pageNo = pageNo;
		this.beginPage = beginPage;
		this.pageSize = pageSize;
		this.countItems = countItems;
		this.countPages = countPages;
		this.nextPage = nextPage;
		this.prePage = prePage;
		
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getBeginPage() {
		return (pageNo - 1) * pageSize;
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

	public int getNextPage() {
		return pageNo + 1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getProPage() {
		return pageNo - 1;
	}

	public void setProPage(int prePage) {
		this.prePage = prePage;
	}

}
