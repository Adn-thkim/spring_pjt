package service.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.AuthInfo;
import model.CartDTO;
import repository.ProductRepository;

public class CartAddService {

	@Autowired
	ProductRepository productRepository;
	public void cartAdd(String prodNo, String cartQty, String prodPrice, String catNum,
			HttpSession session) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String membId = authInfo.getUserId();
		CartDTO dto = new CartDTO();
		int totalPrice = Integer.parseInt(cartQty) * Integer.parseInt(prodPrice);
		
		dto.setCartPrice(Integer.toString(totalPrice));
		dto.setCartQty(cartQty);
		dto.setCatNum(catNum);
		dto.setMembId(membId);
		dto.setProdNo(prodNo);
		
		productRepository.cartAdd(dto);
	}
}
