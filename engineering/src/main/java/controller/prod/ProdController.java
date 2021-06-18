package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProductCommand;
import service.product.ProdAutoNumService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;

@Controller
@RequestMapping("prod")
public class ProdController {
	
	@Autowired
	ProductListService productListService;
	@RequestMapping("prodList")
	public String prodList(Model model) {
		productListService.prodList(model);
		return "product/productList";
	}
	
	@Autowired
	ProdAutoNumService prodAutoNumService;
	@RequestMapping("prodJoin")
	public String prodJoin(Model model) {
		prodAutoNumService.autoNum(model);
		return "product/prodForm";
	}
	
	@Autowired
	ProductJoinService productJoinService;
	@RequestMapping("prodJoinOk")
	public String prodJoinOk(ProductCommand productCommand,
			HttpSession session) {
		productJoinService.prodJoin(productCommand, session);
		return "redirect:prodList";
	}
	
	@Autowired
	ProductInfoService productInfoService;
	@RequestMapping("prodUpdate")
	public String prodUpdate(
			@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodModify";
	}
	
	@Autowired
	ProductModifyService productModifyService;
	@RequestMapping(value="prodModifyOk", method=RequestMethod.POST)
	public String prodModifyOk(ProductCommand productCommand) {
		productModifyService.prodUpdate(productCommand);
		return "redirect:prodList";
	}
	
	@Autowired
	ProductDeleteService productDeleteService;
	@RequestMapping("prodDel")
	public String prodDel(
			@RequestParam(value="prodNo") String prodNo, HttpSession session) {
		productDeleteService.prodDel(prodNo, session);
		return "redirect:prodList";
	}
}
