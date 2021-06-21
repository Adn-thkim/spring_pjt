package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;

import model.AuthInfo;
import repository.EmployeeRepository;

public class EmployeeDelService {
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	EmployeeRepository employeeRepository;
	public void empDeleteOk(HttpSession session,
			String empPw) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String pw = authInfo.getUserPw();
		String userId = authInfo.getUserId();
		
		if(bcryptPasswordEncoder.matches(empPw, pw)) {
			employeeRepository.empDel(userId);
		}
	}
}
