package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.member.MemberAddController;
import Controller.member.MemberDeleteController;
import Controller.member.MemberSearchController;
import Controller.member.MemberUpdateController;
import Controller.music.MusicOpenurlController;
import Controller.music.MusicSearchController;

public class FrontController extends HttpServlet{
	
	private Map<String,SubController> map = new HashMap();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String projectPath = config.getServletContext().getContextPath();	// /JAVA_TO_SERVLET/
		
		//member
		map.put(projectPath + "/member/search.do", new MemberSearchController());
		map.put(projectPath + "/member/add.do", new MemberAddController());
		map.put(projectPath + "/member/update.do", new MemberUpdateController());
		map.put(projectPath + "/member/delete.do", new MemberDeleteController());
		
		//music
		map.put(projectPath + "/music/search.do", new MusicSearchController());
		map.put(projectPath + "/music/openurl.do", new MusicOpenurlController());
		
		
		map.put("/qna", new QnAController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SubController controller = map.get(req.getRequestURI());
		controller.execute(req, resp);
		
		
	}


	

}