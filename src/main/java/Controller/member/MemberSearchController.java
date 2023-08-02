package Controller.member;

import javax.servlet.ServletRequest;
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
			
			MemberDto dto = new MemberDto();
			
			String id = req.getParameter("id");
			String role = ((ServletRequest) resp).getParameter("role")
;		
			if (id != null && !id.isEmpty()) {
                role = ""; 
            } else if (role != null && !role.isEmpty()) {
                id = ""; 
            } else {
                System.out.println("id 또는 sid를 입력해주세요.");
                resp.sendRedirect(req.getContextPath() + "/mypage.do");
                return;
            }
			
//		    MemberDao memberDao = MemberDaoImpl.getInstance();
		    MemberDto result = service.memberSearchOne(id,role);
		    System.out.println("야스오 나와");
		    if (result != null) {
		        HttpSession session = req.getSession();
		        session.setAttribute("selectedMember", result);
		        System.out.println("검색완료 ID : "+ result);
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