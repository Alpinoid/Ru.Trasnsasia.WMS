package ru.transasia.wms.service;

import ru.transasia.wms.domain.Branches;
import ru.transasia.wms.domain.Orders;

import java.sql.Date;
import java.util.List;

public interface OrdersService {
    
	public List<Orders> getAllOrders();
	
	public List<Orders> getOrdersByDate(Date orderDate);

	public List<Orders> getOrdersByBranches(List<Branches> ordersBranch);
	
	public List<Orders> getOrdersByDateAndBranches(Date orderDate, List<Branches> ordersBranch);

}