package ru.transasia.wms.repository;

import org.springframework.data.repository.CrudRepository;

import ru.transasia.wms.domain.Orders;

import java.lang.Integer;
import java.util.List;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{
	
	List<Orders> findAll();

	List<Orders> findByOrderDate(String orderDate);

	List<Orders> findByOrdersBranchIn(List<String> ordersBranch);
	
	List<Orders> findByOrderDateAndOrdersBranchIn(String orderDate, List<String> ordersBranch);
	
}
