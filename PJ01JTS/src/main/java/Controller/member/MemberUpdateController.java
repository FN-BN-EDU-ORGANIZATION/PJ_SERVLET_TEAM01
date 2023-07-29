package Controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Dto.MemberDto;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberUpdateController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			if(req.getMethod().equals("GET")) {
				req.getRequestDispatcher("/WEB-INF/view/member/update.jsp").forward(req, resp);
				return ;
			}
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("MemberUpdateController execute!");
		String id = (String) req.getParameter("id");
//		String pw = (String) req.getParameter("pw");
//		String name = (String) req.getParameter("name");
//		String addr = (String) req.getParameter("addr");
//		String phone = (String) req.getParameter("phone");

		// 2 입력값 검증
//		if (name.isEmpty() || addr.isEmpty() || phone.isEmpty()) {
//			System.out.println("[ERROR] Data Validation Check Error !");
//			req.setAttribute("msg", "[ERROR] 공백인 칸을 모두 채워주세요!");
//			return ;
//		}
		// 3 서비스 실행
		MemberDao memberDao = MemberDaoImpl.getInstance();
	    MemberDto result = new MemberDto();
		try {
			result = memberDao.select(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Dto : " + result);
		Boolean isUpdate = false;
		System.out.println("됐나?");
		try {
			isUpdate = service.memberUpdate(req);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4 View로 전달
		if (isUpdate) {
			
			
		}
		
	}
		
	}
