package service.employees;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import command.EmployeeCommand;
import model.AuthInfo;
import model.EmployeeDTO;
import repository.EmployeeRepository;

public class EmployeeUpdateService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public int empUpdateOk(HttpSession session, EmployeeCommand employeeCommand) {
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setEmpDeptNumber(employeeCommand.getEmpDeptNumber());
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		dto.setEmpPhoneNumber(employeeCommand.getEmpPhoneNumber());
		dto.setHireDate(employeeCommand.getHireDate());
		dto.setSalary(employeeCommand.getSalary());
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		dto.setEmpId(employeeCommand.getEmpId());
		
		if(bcryptPasswordEncoder.matches(employeeCommand.getEmpPw(), authInfo.getUserPw())) {
			employeeRepository.employeeUpdate(dto);
			session.removeAttribute("pwFail2");
			return 1;
		}else {
			session.setAttribute("pwFail2", "비밀번호가 틀렸습니다.");
			return 2;
		}
		
	}
}
