package Controller.member;

import java.util.List;

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
		    String Id = req.getParameter("id");
		    MemberDao memberDao = MemberDaoImpl.getInstance();
		    MemberDto result = memberDao.select(Id);
		    
		    if (result != null) {
		    	System.out.println("검색완료");
		        HttpSession session = req.getSession();
		        session.setAttribute("selectedMember", result);
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    } else {
		        System.out.println("회원을 찾을 수 없습니다.");
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		
	}
}
