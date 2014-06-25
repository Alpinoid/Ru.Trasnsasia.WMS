package ru.transasia.wms.web.form;

import java.sql.Date;
import java.util.List;

public class OrdersFilter {
	
	private Date filterOrdersByDate;
	private List<String> filterOrdersByBranchesList;
	
	public OrdersFilter() {
		this.filterOrdersByDate = null;
		this.filterOrdersByBranchesList = null;
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

	public List<String> getFilterOrdersByBranchesList() {
		return filterOrdersByBranchesList;
	}

	public void setFilterOrdersByBranchesList(List<String> filterOrdersByBranchesList) {
		this.filterOrdersByBranchesList = filterOrdersByBranchesList;
	}

}
