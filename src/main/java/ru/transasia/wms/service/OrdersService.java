package ru.transasia.wms.service;

import ru.transasia.wms.domain.Orders;

import java.util.Date;
import java.util.List;

public interface OrdersService {
    
	public List<Orders> getAllOrders();
	
	public List<Orders> getOrdersByDate(Date orderDate);

//	public List<Orders> getOrdersByBranch(Branches branch);
//	
//	public List<Orders> getOrdersByDateAndBranch(Date orderDate, Branches branch);

}