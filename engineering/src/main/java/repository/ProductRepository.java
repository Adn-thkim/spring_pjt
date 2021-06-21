package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CartDTO;
import model.CatDTO;
import model.ProductCartDTO;
import model.ProductDTO;

public class ProductRepository {
	
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.productMapper";
	private String statement;
	
	public String autoNum() {
		statement = namespace + ".autoNum";
		return sqlSession.selectOne(statement);
	}
	
	public List<CatDTO> catList(){
		statement = namespace + ".catList";
		return sqlSession.selectList(statement);
	}
	
	public void productInfo(ProductDTO dto) {
		statement = namespace + ".prodInsert";
		sqlSession.insert(statement, dto);
	}
	
	public List<ProductDTO> prodList(){
		statement = namespace + ".prodList";
		return sqlSession.selectList(statement);
	}
	
	public ProductDTO prodInfo(String prodNo){
		statement = namespace + ".prodInfo";
		return sqlSession.selectOne(statement, prodNo);
	}
	
	public void prodUpdate(ProductDTO dto) {
		statement = namespace + ".prodUpdate";
		sqlSession.update(statement, dto);
	}
	
	public void prodDel(String prodNo) {
		statement = namespace + ".prodDelete";
		sqlSession.update(statement, prodNo);
	}
	
	public void cartAdd(CartDTO dto) {
		statement = namespace + ".cartAdd";
		sqlSession.insert(statement, dto);
	}
	
	public List<String> memCart(String membId) {
		statement = namespace + ".memCart";
		return sqlSession.selectList(statement, membId);
	}
	
	public ProductCartDTO cartList(CartDTO dto) {
		statement = namespace + ".cartList";
		return sqlSession.selectOne(statement, dto);
	}
}