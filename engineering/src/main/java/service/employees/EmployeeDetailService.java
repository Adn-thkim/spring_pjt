package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.AuthInfo;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeDetailService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	public void empDetail(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String empId = authInfo.getUserId();
		EmployeeDTO dto = employeeRepository.empDetail(empId);
		model.addAttribute("dto", dto);
	}
}
