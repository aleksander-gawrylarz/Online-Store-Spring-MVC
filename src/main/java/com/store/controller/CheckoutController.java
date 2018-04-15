package com.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.store.entity.ShippingForm;
import com.store.service.CartService;

@Controller
@ControllerAdvice
public class CheckoutController {
	
	@Autowired
	private CartService cartService;
	
	@ModelAttribute
	public void addAttributesToModel(Model model) {
		
		model.addAttribute("cartItems", cartService.getCartItems());
		model.addAttribute("totalPrice", cartService.totalPrice());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/checkout")
	public String showOrderForm(Model model) {

		model.addAttribute("shippingForm", new ShippingForm());

		return "order-form";
	}

	@PostMapping("/confirmation")
	public String showOrderConfirmation(@Valid @ModelAttribute("shippingForm") ShippingForm shippingForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "order-form";
		} else
			return "order-confirmation";
	}
}
