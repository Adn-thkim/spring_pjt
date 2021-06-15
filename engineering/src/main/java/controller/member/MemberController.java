package controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.MemberCommand;
import service.member.MemberJoinService;
import service.member.MemberListService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberListService memberListService;
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

}
