package Controller.music;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain1.Dto.MemberDto;
import Domain1.Dto.MusicDto;
import Domain1.Service.MusicService;

public class MusicSearchController implements SubController {

	private MusicService service = MusicService.getInstance();
	private MemberDto memDto = new MemberDto();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicSearchController execute!");
		
		try {
			
			if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("/WEB-INF/view/musicsearchpage.jsp").forward(req, resp);
			
			}
		
			resp.setContentType("application/json;charset=UTF-8");
		
		// 파라미터 추출
		String searchText = req.getParameter("searchText");
		String memberId =(String) req.getSession().getAttribute("ID");
		System.out.println("searchText : " + searchText);
		System.out.println("MusicSearchController MEMBER ID : " + memberId);
		
		// 입력값 검증

		// 서비스 실행

		List<MusicDto> list = service.searchTracks(searchText, memberId);
		
		
		PrintWriter out = resp.getWriter();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonConverted = objectMapper.writeValueAsString(list);
		
		// 뷰로 전달
//		resp.setContentType("application/json");
		out.print(jsonConverted);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
