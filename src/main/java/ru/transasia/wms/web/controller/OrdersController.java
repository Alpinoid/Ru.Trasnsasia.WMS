package ru.transasia.wms.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ru.transasia.wms.domain.Branches;
import ru.transasia.wms.domain.Orders;
import ru.transasia.wms.service.BranchesService;
import ru.transasia.wms.service.OrdersService;
import ru.transasia.wms.web.form.OrdersFilter;
import ru.transasia.wms.web.form.PageParams;

@RequestMapping("/orders")
@Controller
@SessionAttributes({"ordersFilter"})
public class OrdersController {
	
	@ModelAttribute("pageParams")
	public PageParams setPageParams(HttpServletRequest httpServletRequest, Locale locale) {
		PageParams pageParams = new PageParams();
		pageParams.setMenuText("action_home_orders", messageSource, locale);
		pageParams.setMenuUrl("/orders", httpServletRequest);
		return pageParams;
	}
	
	@ModelAttribute("ordersFilter")
	public OrdersFilter getOrdersFilter() {
        return new OrdersFilter();
	}

	@Autowired
	MessageSource messageSource;

	@Autowired
    private OrdersService orderService;
	
	@Autowired
    private BranchesService branchService;
	
	@RequestMapping(method=RequestMethod.GET)
    public String list(@ModelAttribute("pageParams") PageParams pageParams,
    					@ModelAttribute("ordersFilter") OrdersFilter ordersFilter,
    					BindingResult bindingResult, Model uiModel, Locale locale) {
		
		List<Orders> orders= null;
		List<Branches> listBranches = branchService.getAllBranches();
			
		if (ordersFilter.getFilterOrdersByDate() == null && ordersFilter.getFilterOrdersByBranchesList(listBranches) == null) {
    		orders = orderService.getAllOrders();
    	} else if (ordersFilter.getFilterOrdersByDate() != null && ordersFilter.getFilterOrdersByBranchesList(listBranches) == null) {
    		orders = orderService.getOrdersByDate(ordersFilter.getFilterOrdersByDate());
		} else if (ordersFilter.getFilterOrdersByDate() == null && ordersFilter.getFilterOrdersByBranchesList(listBranches) != null) {
			orders = orderService.getOrdersByBranches(ordersFilter.getFilterOrdersByBranchesList(listBranches));
		} else {
			orders = orderService.getOrdersByDateAndBranches(ordersFilter.getFilterOrdersByDate(), ordersFilter.getFilterOrdersByBranchesList(listBranches));
		}
    	
		int sumOrders = orders.size();
		int sumRows = 0;
    	BigDecimal sumBoxes = new BigDecimal(0);
    	for (Orders currentOrder : orders) {
    		currentOrder.setOrderDate(currentOrder.getOrderDate().substring(0, 10));
    		sumRows += currentOrder.getRowsCount();
    		sumBoxes = sumBoxes.add(currentOrder.getBoxQuantity());
    	}

    	pageParams.setHeaderText("label_order_list", messageSource, locale);

    	uiModel.addAttribute("ordersFilter", ordersFilter);
    	uiModel.addAttribute("listBranches", listBranches);
    	uiModel.addAttribute("orders", orders);
    	uiModel.addAttribute("sumOrders", sumOrders);
    	uiModel.addAttribute("sumRows", sumRows);
    	uiModel.addAttribute("sumBoxes", sumBoxes);
    	
    	return "orders/list";
    }

}