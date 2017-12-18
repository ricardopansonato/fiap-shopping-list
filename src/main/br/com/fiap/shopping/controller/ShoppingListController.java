package br.com.fiap.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.shopping.model.Product;
import br.com.fiap.shopping.repository.ProductRepository;

@Controller
@RequestMapping(value = "/product")
public class ShoppingListController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView cadastrar(final HttpSession session, final Product product) {
		ModelAndView mv = new ModelAndView("product");
		final List<Product> productList = productRepository.findAll();
		if (StringUtils.isEmpty(product.getName())) {
			mv.addObject("products", productList);
			mv.addObject("error", "Name is empty, please check and try again!");
		} else {
			try {
				productRepository.save(product);
				mv = new ModelAndView("redirect:/product/list");
			} catch (DataIntegrityViolationException e) {
				mv.addObject("products", productList);
				mv.addObject("error", "The item is already in your shopping list!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listar(final HttpSession session, final Product product) {
		final ModelAndView mv = new ModelAndView("product");
		final List<Product> productList = productRepository.findAll();
		mv.addObject("products", productList);
		return mv;
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView remover(final HttpSession session, final Product product, final Long id) {
		ModelAndView mv = new ModelAndView("product");
		final List<Product> productList = productRepository.findAll();
		try {
			productRepository.delete(id);
			mv = new ModelAndView("redirect:/product/list");
		} catch (Exception e) {
			mv.addObject("error", "Error when remove item of the list!");
			mv.addObject("products", productList);
		}
		return mv;
	}
}
