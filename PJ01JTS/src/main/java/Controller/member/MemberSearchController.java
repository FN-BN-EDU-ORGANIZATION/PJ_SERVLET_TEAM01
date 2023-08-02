package Controller.member;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain1.Dto.MemberDto;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberSearchController implements SubController {

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute!");

		try {
			MemberDto userInfo = service.memberSearchOne(req);
			System.out.println(userInfo);
			

			// JAVA -> JSON 변환
			ObjectMapper objectMapper = new ObjectMapper(); // 날짜정보도 포함되어있음..

			String jsonConverted = objectMapper.writeValueAsString(userInfo);

			// 4 View로 전달
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonConverted);

			if (userInfo != null) {
				HttpSession session = req.getSession();
				session.setAttribute("userInfo", userInfo);
				System.out.println("검색완료 ID : " + userInfo.getId());
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