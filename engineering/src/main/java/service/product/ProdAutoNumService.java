package service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.CatDTO;
import repository.ProductRepository;

public class ProdAutoNumService {
	
	@Autowired
	ProductRepository productRepository;
	public void autoNum(Model model) {
		String autoNum = productRepository.autoNum();
		List<CatDTO> list = productRepository.catList();
		model.addAttribute("autoNum", autoNum);
		model.addAttribute("lists", list);
	}
}
