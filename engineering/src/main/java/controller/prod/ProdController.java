package controller.prod;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.GoodsOrderCommand;
import command.ProductCommand;
import service.product.CartAddService;
import service.product.CartListService;
import service.product.CartQtyDownService;
import service.product.GoodsOrderService;
import service.product.PaymentService;
import service.product.ProdAutoNumService;
import service.product.ProdBuyService;
import service.product.ProductDeleteService;
import service.product.ProductInfoService;
import service.product.ProductJoinService;
import service.product.ProductListService;
import service.product.ProductModifyService;
import service.product.PurchaseListService;
import service.product.ReviewModifyService;
import service.product.ReviewUpdateService;
import service.product.ReviewWriteService;

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
	
	@RequestMapping("prodInfo")
	public String prodInfo(
			@RequestParam(value="prodNo") String prodNo, Model model) {
		productInfoService.prodInfo(model, prodNo);
		return "product/prodInfo";
	}
	
	@Autowired
	CartAddService cartAddService;
	@RequestMapping("cartAdd")
	public String cartAdd(
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="cartQty") String cartQty,
			@RequestParam(value="prodPrice") String prodPrice,
			@RequestParam(value="catNum") String catNum,
			Model model, HttpSession session) {
		cartAddService.cartAdd(prodNo, cartQty, prodPrice, catNum, session);;
		return "redirect:cartList";
	}
	
	@Autowired
	CartListService cartListService;
	@RequestMapping("cartList")
	public String cartList(HttpSession session, Model model) {
		cartListService.cartList(session, model);
		return "product/cartList";
	}
	
	@Autowired
	CartQtyDownService cartQtyDownService;
	@RequestMapping("goodsCartQtyDown")
	public String goodsCartQtyDown(
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="prodPrice") String prodPrice,
			HttpSession session) {
		cartQtyDownService.cartQtyDown(prodNo, prodPrice,session);
		return "redirect:cartList";
	}
	
	@Autowired
	ProdBuyService prodBuyService;
	@RequestMapping("prodBuy")
	public String prodBuy(
			@RequestParam(value="prodCk") String [] prodCk,
			HttpSession session, Model model) {
		prodBuyService.prodBuy(prodCk, session, model);
		return "product/order";
	}
	
	@Autowired
	GoodsOrderService goodsOrderService;
	@RequestMapping("goodsOrder")
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		String purchNo = goodsOrderService.goodsOrder(goodsOrderCommand, session);
		return "redirect:paymentOk?purchNo="+purchNo+"&payPrice="+goodsOrderCommand.getPurchTotal();
	}
	
	@Autowired
	PurchaseListService purchaseListService;
	@RequestMapping("purchCon")
	public String purchCon(HttpSession session, Model model) {
		purchaseListService.purchList(session, model);
		return "product/purchCon";
	}
	
	@RequestMapping("paymentOk")
	public String paymentOk(
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="payPrice") String payPrice,
			Model model) {
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("payPrice", payPrice);
		return "product/payment";
	}
	
	// 자동할당
	@Autowired
	PaymentService paymentService;
	@RequestMapping("doPayment")
	public String doPayment(
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="payPrice") String payPrice,
			@RequestParam(value="payAccNum") String payAccNum,
			@RequestParam(value="payCardBank") String payCardBank,
			HttpSession session) {
		paymentService.payment(purchNo, payPrice, payAccNum, payCardBank, session);
		return "redirect:purchCon";
	}
	
	@RequestMapping("goodsReview")
	public String goodsReview(
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="prodName") String prodName,
			Model model) {
		model.addAttribute("prodNo", prodNo);
		model.addAttribute("purchNo", purchNo);
		model.addAttribute("prodName", prodName);
		return "product/prodReview";
	}
	
	@Autowired
	ReviewWriteService reviewWriteService;
	@RequestMapping("reviewOk")
	public String reviewOk(
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="reviewContent") String reviewContent) {
		reviewWriteService.reviewWrite(prodNo, purchNo, reviewContent);
		return "redirect:purchCon";
	}
	
	@Autowired
	ReviewUpdateService reviewUpdateService;
	@RequestMapping("goodsReviewUpdate")
	public String goodsReviewUpdate(
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="prodName") String prodName,
			Model model) {
		reviewUpdateService.reviewUpdate(prodNo, purchNo, prodName, model);
		return "product/reviewUpdate";
	}
	
	@Autowired
	ReviewModifyService reviewModifyService;
	@RequestMapping("goodsReviewUpdateOk")
	public String goodsReviewUpdateOk(
			@RequestParam(value="prodNo") String prodNo,
			@RequestParam(value="purchNo") String purchNo,
			@RequestParam(value="reviewContent") String reviewContent) {
		reviewModifyService.reviewUpdate(prodNo, purchNo, reviewContent);
		return "redirect:purchCon";
	}
}
