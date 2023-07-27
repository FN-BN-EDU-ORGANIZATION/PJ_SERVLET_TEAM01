package Controller.member;

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

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		String phone = req.getParameter("phone");
		String role = req.getParameter("role");
		String sid = req.getParameter("sid");

		// 2 입력값 검증
		if (id == null || pw == null || name == null || role == null) {
			System.out.println("[ERROR] Data Validation Check Error !");	
		}
		// 3 서비스 실행
		MemberDto dto = new MemberDto(id, pw, name, addr, phone, role);
		System.out.println("Dto : " + dto);
		Boolean rValue = false;
		try {
			rValue = service.memberUpdate(dto, sid);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
