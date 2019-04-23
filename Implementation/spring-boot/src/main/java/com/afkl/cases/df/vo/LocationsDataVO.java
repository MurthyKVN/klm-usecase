package com.afkl.cases.df.vo;

public class LocationsDataVO {
	
	private DataVO _embedded;
	private PageInfoVO page;

	public DataVO get_embedded() {
		return _embedded;
	}

	public void set_embedded(DataVO _embedded) {
		this._embedded = _embedded;
	}
	
	public PageInfoVO getPage() {
		return page;
	}

	public void setPage(PageInfoVO page) {
		this.page = page;
	}

}
