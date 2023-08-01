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

public class MemberAllSearchController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberAllSearchController execute!");
		
		try {
			List<MemberDto> list = service.memberSearch(req);
			System.out.println(list);
			
			// JAVA -> JSON 변환
			ObjectMapper objectMapper = new ObjectMapper();	//날짜정보도 포함되어있음..
			
			String jsonConverted = objectMapper.writeValueAsString(list);
			System.out.println(jsonConverted);
			
			// 4 View로 전달			
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(jsonConverted);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}