package ru.transasia.wms.service.jpa;

import ru.transasia.wms.domain.Orders;
import ru.transasia.wms.repository.OrdersRepository;
import ru.transasia.wms.service.OrdersService;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaOrderService")
@Repository
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository orderRepository;

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	public List<Orders> getAllOrders() { 
		Sort sort = new Sort(Direction.ASC, "orderNumber");
        return orderRepository.findAll(sort);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Orders> getOrdersByDate(Date orderDate) {
		return orderRepository.findByOrderDate(orderDate.toString()+" 00:00:00");
	}
	
//	@Override
//	@Transactional(readOnly=true)
//	public List<Orders> getOrdersByBranch(Branches branch) {
//		return orderRepository.findByOrdersBranch(branch);
//	}
//
//	@Override
//	@Transactional(readOnly=true)
//	public List<Orders> getOrdersByDateAndBranch(Date orderDate, Branches branch) {
//		return orderRepository.findByOrderDateAndOrdersBranch(orderDate, branch);
//	}

	
}