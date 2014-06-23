package ru.transasia.wms.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.transasia.wms.domain.Slots;
import ru.transasia.wms.service.SlotsService;
import ru.transasia.wms.web.form.Message;
import ru.transasia.wms.web.form.PageParams;

@RequestMapping("/slots")
@Controller
public class SlotsController {
	
	static final Logger logger = LoggerFactory.getLogger(SlotsController.class);
	
	@ModelAttribute("pageParams")
	public PageParams setPageParams(HttpServletRequest httpServletRequest, Locale locale) {
		PageParams pageParams = new PageParams();
		pageParams.setMenuText("action_home_slot", messageSource, locale);
		pageParams.setMenuUrl("/slots", httpServletRequest);
		return pageParams;
	}

	@Autowired
	MessageSource messageSource;

	@Autowired
    private SlotsService slotService;
	
	@RequestMapping(method=RequestMethod.GET)
    public String list(@ModelAttribute("pageParams") PageParams pageParams, Model uiModel, Locale locale) {
    	List<Slots> slots = slotService.getAllSlots();
    	pageParams.setHeaderText("label_slot_list", messageSource, locale);

    	uiModel.addAttribute("slots", slots);
    	
    	return "slots/list";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(@ModelAttribute("slot") @Valid Slots slot,
    					 BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest,
    					 RedirectAttributes redirectAttributes, Locale locale) {
		
        if (bindingResult.hasErrors()) {
        	uiModel.addAttribute("message", new Message("error", messageSource.getMessage("message_save_fail", new Object[]{}, locale)));        	
            uiModel.addAttribute("slot", slot);
            return "slots/edit";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage("message_save_success", new Object[]{}, locale)));   
        
        slotService.save(slot);
        logger.info("Altered slot: {}", slot);
        return "redirect:/slots";
    }	

   	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@ModelAttribute("pageParams") PageParams pageParams,
    						 @PathVariable("id") String id, Model uiModel, Locale locale) {
    	pageParams.setHeaderText("label_slot_update", messageSource, locale);

        uiModel.addAttribute("slot", slotService.getSlotByCell(id));

        return "slots/edit";
	}
	
	@RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(@ModelAttribute("Slot") @Valid Slots slot,
    					 BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest,
    					 RedirectAttributes redirectAttributes, Locale locale) {

        if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message", new Message("error", messageSource.getMessage("message_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("slot", slot);
            return "slots/create";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage("message_save_success", new Object[]{}, locale)));     
        
        slotService.save(slot);
        logger.info("Added new slot: {}", slot);
        return "redirect:/slots";
    }	

	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute("pageParams") PageParams pageParams, Model uiModel, Locale locale) {
		Slots slot = new Slots();
		pageParams.setHeaderText("label_slot_new", messageSource, locale);

        uiModel.addAttribute("slot", slot);

        return "slots/edit";
    }

	@RequestMapping(value = "/{id}", params = "delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id) {
		slotService.delete(slotService.getSlotByCell(id));
        logger.info("Deleted slot with Articul: {}", id);
        return "redirect:/slots";
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.GET)
    public String deleteAll() {
		slotService.deleteAllSlots();
        logger.info("Deleted all slots");
        return "redirect:/slots";
	}
    
}