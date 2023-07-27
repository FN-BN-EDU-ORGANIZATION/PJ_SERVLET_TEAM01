package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberAddController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAddController execute!");

	}
}
