package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import model.CatDTO;
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
}
