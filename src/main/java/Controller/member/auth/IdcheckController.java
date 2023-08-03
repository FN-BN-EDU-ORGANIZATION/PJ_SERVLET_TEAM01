package Controller.member.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class IdcheckController  implements SubController{

	private MemberService service= MemberServiceImpl.getInstance();

	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("IdcheckController execute");
		String id = req.getParameter("id");
	    

	    boolean duplicate_id = false;
		try {
			duplicate_id = service.idcheck(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
	        resp.getWriter().write(String.valueOf(duplicate_id));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	}
		
		
	}