package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "mappers.employeeMapper";
	private String statement;
	
	public void empDelete(String empNo) {
		statement = namespace + ".employeeDelete";
		sqlSession.delete(statement, empNo);
	}
	
	public void empUpdate(EmployeeDTO dto) {
		statement = namespace + ".employeeUpdate";
		sqlSession.update(statement, dto);
	}
	
	public void insertEmployee(EmployeeDTO dto) {
		statement = namespace + ".employeeInsert";
		sqlSession.insert(statement, dto);
	}
	
	public EmployeeDTO empInfo(String empNo) {
		statement = namespace + ".empInfo";
		return sqlSession.selectOne(statement, empNo);
	}
	
	public int getEmpNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
	
	public List<EmployeeDTO> empAllList(){
		statement = namespace + ".empAllList";
		return sqlSession.selectList(statement);
	}
	
	public EmployeeDTO empDetail(String empId) {
		statement = namespace + ".empDetail";
		return sqlSession.selectOne(statement, empId);
	}
	
	public void employeeUpdate(EmployeeDTO dto) {
		statement = namespace + ".empUpdate";
		sqlSession.update(statement, dto);
	}
	
	public void pwChange(EmployeeDTO dto) {
		statement = namespace + ".pwChange";
		sqlSession.update(statement, dto);
	}
	
	public void empDel(String userId) {
		statement = namespace + ".empDel";
		sqlSession.delete(statement, userId);
	}
}
