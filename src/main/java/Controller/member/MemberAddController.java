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
            String id = req.getParameter("id");
            String pw = req.getParameter("pw");
            String name = req.getParameter("name");
            String address = req.getParameter("addr");
            String phone = req.getParameter("phone");
            String role = "ROLE_USER";

            // pw와 pwCheck가 일치하는지 검사 (클라이언트 측에서도 검사 가능하지만, 서버에서도 추가 검사를 수행하는 것이 좋음)
            String pwCheck = req.getParameter("pwc_input");
            if (!pw.equals(pwCheck)) {
                System.out.println("비밀번호 확인이 일치하지 않습니다.");
                resp.sendRedirect(req.getContextPath() + "/join.do");
                return;
            }

            MemberDto memberDto = new MemberDto();
            memberDto.setId(id);
            memberDto.setPw(pw);
            memberDto.setName(name);
            memberDto.setAddr(address);
            memberDto.setPhone(phone);
            memberDto.setRole(role);

<<<<<<< HEAD
           // MemberDao memberDao = MemberDaoImpl.getInstance();
=======
//            MemberDao memberDao = MemberDaoImpl.getInstance();
>>>>>>> branch 'ycy' of https://github.com/FN-BN-EDU-ORGANIZATION/PJ_SERVLET_TEAM01.git
            boolean result = service.memberJoin(memberDto);

            if (result) {
                HttpSession session = req.getSession();
                session.setAttribute("selectedMember", memberDto);
                System.out.println("삽입 완료 ID: " + id);
                resp.sendRedirect(req.getContextPath() + "/index.do");
                
                
            } else {
                System.out.println("회원 삽입 실패.");
                resp.sendRedirect(req.getContextPath() + "/join.do");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
