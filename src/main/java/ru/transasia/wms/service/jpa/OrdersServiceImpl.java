package ru.transasia.wms.service.jpa;

import ru.transasia.wms.domain.Branches;
import ru.transasia.wms.domain.Orders;
import ru.transasia.wms.repository.OrdersRepository;
import ru.transasia.wms.service.OrdersService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
        return orderRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Orders> getOrdersByDate(Date orderDate) {
		return orderRepository.findByOrderDate(orderDate.toString()+" 00:00:00");
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Orders> getOrdersByBranches(List<Branches> ordersBranch) {
		// TODO Пернеснести 4 нижнии строки в некую функцию
		List<String> listBranchesNames = new ArrayList<String>();
		for (Branches branch : ordersBranch) {
			listBranchesNames.add(branch.getBranchName());
		}
		return orderRepository.findByOrdersBranchIn(listBranchesNames);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Orders> getOrdersByDateAndBranches(Date orderDate, List<Branches> ordersBranch) {
		List<String> listBranchesNames = new ArrayList<String>();
		for (Branches branch : ordersBranch) {
			listBranchesNames.add(branch.getBranchName());
		}
		return orderRepository.findByOrderDateAndOrdersBranchIn(orderDate.toString()+" 00:00:00", listBranchesNames);
	}
	
}