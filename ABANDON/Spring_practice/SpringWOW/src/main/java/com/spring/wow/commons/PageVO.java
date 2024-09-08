package com.spring.wow.commons;


public class PageVO {

	private Integer page;
	private Integer countPerPage;
	
	public PageVO() {
		this.page = 1;
		this.countPerPage=10;
	}
	
	public Integer getFirstPage() {
		return (countPerPage*(this.page -1))+1;
	}
	

	
	public Integer getLastPage() {
	
		return page*countPerPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public Integer getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(Integer countPerPage) {
		
		if(countPerPage <= 0 || countPerPage > 50) {
			this.countPerPage = 10;
			return;
		}
		this.countPerPage = countPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}
	

	
	
	
}
