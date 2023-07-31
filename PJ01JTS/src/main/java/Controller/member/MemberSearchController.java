package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Dto.MemberDto;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberSearchController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute!");

		try {
			MemberDto memberDto = new MemberDto();
			String id = req.getParameter("id");
			String role = memberDto.getRole();
		
	            memberDto.setId(id);
	            memberDto.setRole(role);
	         
	           
			
			
//		    MemberDao memberDao = MemberDaoImpl.getInstance();
		    MemberDto result = service.memberSearchOne(id,role);
		    System.out.println("야스오 나와");
		    System.out.println(id+role);
		    if (result != null) {
		        HttpSession session = req.getSession();
		        session.setAttribute("selectedMember", result);
		        System.out.println("검색완료 ID : "+ result);
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    } else {
		        System.out.println("회원을 찾을 수 없습니다.");
		        req.setAttribute("msg", "회원을 찾을 수 없습니다.");
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}