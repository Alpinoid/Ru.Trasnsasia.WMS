package ru.transasia.wms.web.form;

import java.sql.Date;

public class OrdersFilter {
	
	private Date filterOrdersByDate;
	
	public OrdersFilter() {
		this.filterOrdersByDate = null;
	}

	public OrdersFilter(Date filterOrdersByDate) {
		this.filterOrdersByDate = filterOrdersByDate;
	}
	
	public OrdersFilter(String filterOrdersByDate) {
		this.filterOrdersByDate = Date.valueOf(filterOrdersByDate);
	}

	public Date getFilterOrdersByDate() {
		return filterOrdersByDate;
	}

	public void setFilterOrdersByDate(Date filterOrdersByDate) {
		this.filterOrdersByDate = filterOrdersByDate;
	}
	
	public void setFilterOrdersByDate(String filterOrdersByDate) {
		this.filterOrdersByDate = Date.valueOf(filterOrdersByDate);
	}

}
