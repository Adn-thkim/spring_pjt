package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import command.ProductCommand;
import service.product.ProdAutoNumService;
import service.product.ProductJoinService;

@Controller
@RequestMapping("prod")
public class ProdController {
	
	@RequestMapping("prodList")
	public String prodList() {
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
}
