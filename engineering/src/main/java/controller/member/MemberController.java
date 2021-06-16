package controller.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.MemberCommand;
import model.AuthInfo;
import service.member.MemberDeleteOkService;
import service.member.MemberDeleteService;
import service.member.MemberDetailService;
import service.member.MemberInfoService;
import service.member.MemberJoinService;
import service.member.MemberListService;
import service.member.MemberModifyService;
import service.member.MemberPwChangeService;
import service.member.MemberUpdateService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberUpdateService memberUpdateService;
	@Autowired
	MemberDeleteOkService memberDeleteOkService;
	@Autowired
	MemberPwChangeService memberPwChangeService;
	
	@RequestMapping("agree")
	public String agree() {
		
		return "member/agree";
	}
	@RequestMapping("memReget")
	public String memReget() {
		return "member/memberForm";
	}
	@RequestMapping(value="memJoin", method=RequestMethod.POST)
	public String memJoin(MemberCommand memberCommand) {
		memberJoinService.memberInsert(memberCommand);
		return "redirect:../main";
	}
	@RequestMapping("memList")
	public String memList(Model model) {
		memberListService.memList(model);
		return "member/memberList";
	}
	@RequestMapping("memInfo")
	public String memInfo(
			@RequestParam(value = "membId") String membId, Model model) {
		memberInfoService.memInfo(membId, model);
		return "member/memberInfo"; 
	}
	@RequestMapping("memModify")
	public String memModify(
			@RequestParam(value = "membId") String membId, Model model) {
		memberInfoService.memInfo(membId, model);
		return "member/memberModify";
	}
	@RequestMapping("memModifyOk")
	public String memModifyOk(MemberCommand memberCommand) {
		memberModifyService.memUpdate(memberCommand);
		return "redirect:memInfo?membId="+memberCommand.getMembId();
	}
	@RequestMapping("memDel")
	public String memDel(
			@RequestParam(value = "membId") String membId, Model model) {
		memberDeleteService.memDel(membId);
		return "redirect:memList";
	}
	@RequestMapping("memMyPage")
	public String myPage() {
		return "member/memMyPage";
	}
	@RequestMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memDetail";
	}
	@RequestMapping("memUpdate")
	public String memUpdate(HttpSession session, Model model) {
		memberDetailService.memInfo(session, model);
		return "member/memUpdate";
	}
	@RequestMapping("memUpdateOk")
	public String updateOk(MemberCommand memberCommand, HttpSession session) {
		int i = memberUpdateService.memUpdate(memberCommand, session);
		if(i == 1) {
			return "redirect:myInfo";
		}else {
			return "redirect:memUpdate";
		}
	}
	@RequestMapping("memDelete")
	public String memDelete() {
		
		return "member/memDelete";
	}
	@RequestMapping("memDeleteOk")
	public String memDeleteOk(
			@RequestParam(value="membPw") String membPw, HttpSession session) {
		memberDeleteOkService.del(session, membPw);
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("pwChange")
	public String pwChange() {
		
		return "member/pwChange";
	}
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	@RequestMapping("pwChangeCnf") // 얘가 주소명
	public String pwChangeCnf(HttpSession session, @RequestParam(value="membPw") String mambPw) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userPw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(mambPw, userPw)){
			return "member/pwChangeCnf";
		}else {
			return "member/pwChange";
		}
	}
	@RequestMapping("pwChangeOk")
	public String pwChangeOk(HttpSession session,
			@RequestParam(value="membPw") String membPw,
			@RequestParam(value="newPw") String newPw,
			@RequestParam(value="newPwCon") String newPwCon) {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		String pw = authInfo.getUserPw();
		if(bcryptPasswordEncoder.matches(membPw, pw)) {
			if(newPw.equals(newPwCon)) { // 비밀번호 변경
				newPw = bcryptPasswordEncoder.encode(newPw);
				memberPwChangeService.pwOk(userId, newPw);
				return "redirect:../main";
			}else { // 변경 비밀번호와 비밀번호 확인 미일치
				return "member/pwChangeCnf";
			}
		}else { // 현재 비밀번호 잘못 입력
			return "member/pwChangeCnf";
		}
	}
	
}
