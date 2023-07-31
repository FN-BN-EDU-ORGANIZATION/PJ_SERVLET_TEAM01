package Controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dto.MemberDto;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberUpdateController implements SubController {

	private MemberService service = MemberServiceImpl.getInstance();

	   @Override
	    public void execute(HttpServletRequest req, HttpServletResponse resp) {
	        System.out.println("MemberUpdateController execute!");

	        if(req.getMethod().equals("GET")) {
	        	try {
					req.getRequestDispatcher("/WEB-INF/view/member/update.jsp").forward(req, resp);
					return;	
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        
	        
	        try {          
	        	MemberDto memberDto = new MemberDto();
	           
	            String id = req.getParameter("id");
	            String pw = req.getParameter("pw");
	            String name = req.getParameter("name");
	            String addr = req.getParameter("addr");
	            String phone = req.getParameter("phone");
	           
	            
	            memberDto.setId(id);
	            memberDto.setPw(pw);
	            memberDto.setName(name);
	            memberDto.setAddr(addr);
	            memberDto.setPhone(phone);
	            memberDto.setRole("ROLE_USER");
	            

	            boolean result = service.memberUpdate(memberDto);
	            System.out.println(memberDto);

	            if (result) {
	                HttpSession session = req.getSession();
	                session.setAttribute("updatedDto", memberDto);
	                System.out.println("수정 완료 ID: " + memberDto.getId());
	                resp.sendRedirect(req.getContextPath() + "/mypage.do");
	            } else {
	                System.out.println("회원 수정 실패.");
	                resp.sendRedirect(req.getContextPath() + "/member/update.do");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}

        
	
	