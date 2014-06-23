package ru.transasia.wms.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.transasia.wms.domain.Orders;
import ru.transasia.wms.service.OrdersService;
import ru.transasia.wms.web.form.PageParams;


@RequestMapping("/orders")
@Controller
public class OrdersController {
	
	@ModelAttribute("pageParams")
	public PageParams setPageParams(HttpServletRequest httpServletRequest, Locale locale) {
		PageParams pageParams = new PageParams();
		pageParams.setMenuText("action_home_orders", messageSource, locale);
		pageParams.setMenuUrl("/orders", httpServletRequest);
		return pageParams;
	}

	@Autowired
	MessageSource messageSource;

	@Autowired
    private OrdersService orderService;

	@RequestMapping(method=RequestMethod.GET)
    public String list(@ModelAttribute("pageParams") PageParams pageParams, Model uiModel, Locale locale) {
    	List<Orders> orders = orderService.getAllOrders();

    	pageParams.setHeaderText("label_order_list", messageSource, locale);

    	uiModel.addAttribute("orders", orders);
    	
    	return "orders/list";
    }

}