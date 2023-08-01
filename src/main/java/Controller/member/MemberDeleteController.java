package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberDeleteController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberDeleteController execute!");
		
		try {
			String id = req.getParameter("id");
			String sid = req.getParameter("sid");
			
			if (id != null && !id.isEmpty()) {
                sid = ""; // id 입력 시, sid 초기화
            } else if (sid != null && !sid.isEmpty()) {
                id = ""; // sid 입력 시, id 초기화
            } else {
                System.out.println("id 또는 sid를 입력해주세요.");
                resp.sendRedirect(req.getContextPath() + "/mypage.do");
                return;
            }
			
//			MemberDao memberDao = MemberDaoImpl.getInstance();
			boolean result = service.memberDelete(id,sid);
			
			if(result) {
				HttpSession session = req.getSession();
				session.setAttribute("deleteMessage", "아웃!!");
				System.out.println("아웃");
				resp.sendRedirect(req.getContextPath()+"/mypage.do");
			}else {
				System.out.println("실패다...");
				resp.sendRedirect(req.getContextPath()+"/mypage.do");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
