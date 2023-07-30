package Controller.member.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class LoginController  implements SubController{

	private MemberService service= MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("LoginController execute");
		
		//GET 요청 처리
		if(req.getMethod().equals("GET"))
		{
			try {
				req.getRequestDispatcher("/WEB-INF/view/loginpage.jsp").forward(req, resp);
			
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ;
		}
		
		//POST 요청 처리
		//1 파라미터 추출
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		
		try {
			//2 입력값 검증
			if (id.isEmpty() || pw.isEmpty()) {
				System.out.println("[ERROR] Data Validation Check Error!");
				req.setAttribute("msg", "[ERROR] ID나 PW가 공백입니다.");
				req.getRequestDispatcher("/WEB-INF/view/loginpage.jsp").forward(req, resp);
				return ;
			}
			//3 서비스 실행
			boolean isLogin=false;
		
			try {
				isLogin = service.login(req);
				HttpSession session = req.getSession();
				session.getAttribute(id);
				session.getAttribute(pw);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			//4 View로 전달 
			if(isLogin)
			{
				//main.do 이동 - Redirect
				resp.sendRedirect(req.getContextPath()+"/indexlog.do");
			}
			else
			{
				//login.do 이동 - Forward
				req.getRequestDispatcher("/WEB-INF/view/loginpage.jsp").forward(req, resp);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}