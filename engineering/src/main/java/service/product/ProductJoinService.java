package service.product;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import command.ProductCommand;
import model.AuthInfo;
import model.ProductDTO;
import repository.ProductRepository;

public class ProductJoinService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void prodJoin(ProductCommand productCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empNo = authInfo.getGrade();
		ProductDTO dto = new ProductDTO();
		dto.setCatNum(productCommand.getCatNum());
		dto.setEmpNo(empNo);
		dto.setProdInfo(productCommand.getProdInfo());
		dto.setProdName(productCommand.getProdName());
		dto.setProdNo(productCommand.getProdNo());
		dto.setProdPrice(productCommand.getProdPrice());
		
		// 파일 처리
		String path = "WEB-INF/view/product/upload"; // 파일 저장 경로
		String filepath = session.getServletContext().getRealPath(path); // 
		System.out.println(filepath);
		// C:\Users\taehokim\Documents\Java\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\engineering\WEB-INF\view\product\\upload\b841053e4cbe4f53844dc5192f4e34ba.png
		// 이 경로에 선택된 이미지 파일이 지정된 이름으로 저장됨
		String goodsImage="";
		if(productCommand.getProdImage() != null) {
			// ProductCommand의 MultipartFile [] prodImage에서 한개씩 불러들임
			for(MultipartFile mf : productCommand.getProdImage()) {
				String original = mf.getOriginalFilename();
				// 이미지 파일의 확장자 가져오기
				String originalExt = original.substring(original.lastIndexOf("."));
				// UUID : unique ID 를 문자열로 변경, -를 삭제 후 확장자를 붙여서 파일명 명명
				String store = UUID.randomUUID().toString().replace("-", "")
								+ originalExt;
				goodsImage += store + ",";
				// 파일 저장
				File file = new File(filepath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		dto.setProdImage(goodsImage);
		productRepository.productInfo(dto);
	}
}
