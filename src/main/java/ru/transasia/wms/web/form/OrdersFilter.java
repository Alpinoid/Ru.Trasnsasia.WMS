package ru.transasia.wms.web.form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ru.transasia.wms.domain.Branches;

public class OrdersFilter {
	
	private Date filterOrdersByDate;
	private List<Integer> filterOrdersByBranchID;
	//private List<Branches> filterOrdersByBranchesList;
	
	public OrdersFilter() {
		this.filterOrdersByDate = null;
		this.filterOrdersByBranchID = null;
		//this.filterOrdersByBranchesList = null;
	}

	public OrdersFilter(Date filterOrdersByDate) {
		this.filterOrdersByDate = filterOrdersByDate;
		this.filterOrdersByBranchID = null;
		//this.filterOrdersByBranchesList = null;		
	}
	
	public OrdersFilter(String filterOrdersByDate) {
		this.filterOrdersByDate = Date.valueOf(filterOrdersByDate);
		this.filterOrdersByBranchID = null;
		//this.filterOrdersByBranchesList = null;
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
	

	public List<Integer> getFilterOrdersByBranchID() {
		return filterOrdersByBranchID;
	}

	public void setFilterOrdersByBranchID(List<Integer> filterOrdersByBranchID) {
		this.filterOrdersByBranchID = filterOrdersByBranchID;
	}

	public List<Branches> getFilterOrdersByBranchesList(List<Branches> listAllBranches) {
		List<Branches> filterOrdersByBranchesList = new ArrayList<Branches>();
		if (this.filterOrdersByBranchID != null) {
			for (Integer branchID : this.filterOrdersByBranchID) {
				filterOrdersByBranchesList.add(Branches.getBranchByID(listAllBranches, branchID));
			}
		}
		if (filterOrdersByBranchesList.size() > 0) {
			return filterOrdersByBranchesList;
		} else {
			return null;
		}
	}

//	public void setFilterOrdersByBranchesList(List<Branches> filterOrdersByBranchesList) {
//		this.filterOrdersByBranchesList = filterOrdersByBranchesList;
//	}
	
	@Override
	public String toString() {
		String result = "Filter info - Date: " + this.getFilterOrdersByDate() + "; Branches ID: ";
		if (filterOrdersByBranchID != null) {
			for (Integer branchID : filterOrdersByBranchID) {
				result = result + branchID + ", ";
			}
		} else {
			result = result + "null";
		}
		return result;
	}

}
