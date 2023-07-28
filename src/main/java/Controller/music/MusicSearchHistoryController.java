package Controller.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Controller.SubController;
import Domain1.Dto.MusicSearchHistoryDto;
import Domain1.Service.MusicService;

public class MusicSearchHistoryController implements SubController {

	private MusicService service = MusicService.getInstance();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicSearchHistoryController execute");
		try {
		List<MusicSearchHistoryDto> list = service.getSearchHistoryList(req);
		
		ObjectMapper objectMapper = new ObjectMapper();	//날짜정보도 포함되어있음..
       
		String jsonConverted = objectMapper.writeValueAsString(list);
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(jsonConverted);
		
		}catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
