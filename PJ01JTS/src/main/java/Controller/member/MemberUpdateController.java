package Controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain1.Dto.MemberDto;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberUpdateController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberUpdateController execute!");
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		String name = (String) req.getParameter("name");
		String addr = (String) req.getParameter("addr");
		String phone = (String) req.getParameter("phone");
		String role = (String)req.getParameter("role");

		// 2 입력값 검증
		if (name.isEmpty() || addr.isEmpty() || phone.isEmpty()) {
			System.out.println("[ERROR] Data Validation Check Error !");
			req.setAttribute("msg", "[ERROR] 공백인 칸을 모두 채워주세요!");
			return ;
		}
		// 3 서비스 실행
		MemberDto dto = new MemberDto(id, pw, name, addr, phone, role);
		System.out.println("Dto : " + dto);
		Boolean rValue = false;
		try {
			rValue = service.memberUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4 View로 전달
		if (isUpdate) {
			//mypage.do 이동 - Redirect
			resp.sendRedirect(req.getContextPath() + "/mypage.do");
		} else {
			// login.do 이동 - Forward
			req.getRequestDispatcher("/WEB-INF/view/member/update.jsp").forward(req, resp);
		}

	}
}
