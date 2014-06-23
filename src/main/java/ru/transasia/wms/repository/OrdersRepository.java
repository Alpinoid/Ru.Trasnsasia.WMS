package ru.transasia.wms.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import ru.transasia.wms.domain.Orders;

import java.lang.Integer;
import java.util.Date;
import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{
	
	List<Orders> findAll(Sort sort);
	
	List<Orders> findByOrderDate(Date orderDate);

/*	List<Orders> findByOrdersBranch(Branches branch);
	
	List<Orders> findByOrderDateAndOrdersBranch(Date orderDate, Branches branch);*/


}
