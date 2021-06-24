package service.product;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import command.GoodsOrderCommand;
import model.AuthInfo;
import model.CartDTO;
import model.PurchaseDTO;
import repository.ProductRepository;

public class GoodsOrderService {

	@Autowired
	ProductRepository productRepository;
	public String goodsOrder(GoodsOrderCommand goodsOrderCommand,
			HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		
		PurchaseDTO dto = new PurchaseDTO();
		
		dto.setMembId(membId);
		dto.setPurchAddr(goodsOrderCommand.getPurchAddr());
		dto.setPurchMsg(goodsOrderCommand.getPurchMsg());
		dto.setPurchPhoneNumber(goodsOrderCommand.getPurchPhoneNumber());
		dto.setPurchReceiver(goodsOrderCommand.getPurchReceiver());
		dto.setPurchTotal(goodsOrderCommand.getPurchTotal());
		// purchNo : 구매번호를 날짜로 사용  <<<--- why??
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String purchNo = df.format(new Date());
		dto.setPurchNo(purchNo);
		productRepository.purchInsert(dto);
		
		String [] prodNums = goodsOrderCommand.getProdNums().split(",");
		for(String prodNum : prodNums) {
			// 장바구니(Cart)에 있는 제품 정보를 구매리스트에 복사
			CartDTO d = new CartDTO();
			d.setPurchNo(purchNo);
			d.setMembId(membId);
			d.setProdNo(prodNum);
			productRepository.purchListInsert(d);
			productRepository.cartProdDel(d);
		}
		return purchNo;
	}
}
