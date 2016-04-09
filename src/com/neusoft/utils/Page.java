package com.neusoft.utils;

public class Page {

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
	 * 分页显示
	 */
	private String pageInfo;

	public String getPageInfo() {

		return getBase();
	}

	private String getBase() {
		String str = "<div class=\"pagination\">";
		str += "<ul>";
		if (pageNo != 1) {
			// 首页
			str += "<li><a href=\"javascript:pageSub(1);\">首页</a></li>\n";
			// 上一页
			str += "<li><a href=\"javascript:pageSub(" + this.getPrePage()
					+ ")\"><<</a></li>\n";
		}
		str += "<li class=\"active\"><a href=\"javascript:pageSub("
				+ this.getPageNo() + ")\" >" + this.pageNo + "</a></li>";

		if (pageNo < this.getCountPages()) {
			// 下一页
			str += "<li><a href=\"javascript:pageSub(" + this.getNextPage()
					+ ")\">" + this.getNextPage() + "</a><li>";
			if ((pageNo + 1) < this.getCountPages()) {
				str += "<li class=\"disabled\"><a>...</a></li>";
			}
			str += "<li><a href=\"javascript:pageSub(" + this.getNextPage()
					+ ")\">>></a><li>";
			// 尾页
			str += "<li><a href=\"javascript:pageSub(" + this.getCountPages()
					+ ")\">末页</a><li>";
		}
		str+="<li>";
		str += "<input type=\"number\"  class=\"input-mini\" id=\"input-page\" min=\"1\" max='"
			+this.getCountPages()+"' value='"+this.getPageNo()+"' />";
		str+="<li>";
		str += "<button id=\"page-btn\"  class=\"btn\">Go!</button>";
		str+="</li>";

		str += "</ul>";
		str += "</div>";
		return str;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
	 * 构造函数
	 */
	public Page() {
	}

	/**
	 * 带参数的构造函数
	 */

	public int getPageNo() {
		return pageNo;
	}

	public Page(int pageNo, int beginPage, int pageSize, int countItems,
			int countPages, int nextPage, int prePage, String pageInfo) {
		super();
		this.pageNo = pageNo;
		this.beginPage = beginPage;
		this.pageSize = pageSize;
		this.countItems = countItems;
		this.countPages = countPages;
		this.nextPage = nextPage;
		this.prePage = prePage;
		this.pageInfo = pageInfo;
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

	public int getPrePage() {
		return pageNo - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

}
