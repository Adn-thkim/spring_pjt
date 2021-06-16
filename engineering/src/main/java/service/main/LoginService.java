package service.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.AuthInfo;
import repository.LoginRepository;

public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public void login(String loginId, String loginPw, HttpServletRequest request) {
		AuthInfo authInfo = loginRepository.login(loginId);
		HttpSession session = request.getSession();
		// model은 controller에서 정의할 때 return값에 jsp파일이 지정되어 있어야 값 반환 가능
		// 직접 페이지로 이동하지 않고 redirect로 이동하는데 값을 전달해야하는 경우에는 model대신에 session 사용
		if(authInfo == null) {
			session.setAttribute("userFail", "아이디가 존재하지 않습니다");
		}else {
			if(bcryptPasswordEncoder.matches(loginPw, authInfo.getUserPw())){
				// 로그인 정보를 가진 session
				session.setAttribute("authInfo", authInfo);
				session.removeAttribute("pwFail");
				session.removeAttribute("userFail");
			}else {
				session.removeAttribute("userFail");
				session.setAttribute("pwFail", "비밀번호가 일치하지 않습니다.");
			}
		}
	}
}
