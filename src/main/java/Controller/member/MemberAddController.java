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

public class MemberAddController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAddController execute!");

		try {
		    String Id = req.getParameter("id");

		 
		    MemberDto memberDto = new MemberDto();
		    memberDto.setId(Id);

		    MemberDao memberDao = MemberDaoImpl.getInstance();
		    int result = memberDao.insert(memberDto);

		    if (result > 0) {
		        HttpSession session = req.getSession();
		        session.setAttribute("selectedMember", memberDto);
		        System.out.println("삽입 완료 ID: " + Id);
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    } else {
		        System.out.println("회원 삽입 실패.");
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    }
		} catch (Exception e) {
		    // 예외 처리
		    e.printStackTrace();
		}
	}
}