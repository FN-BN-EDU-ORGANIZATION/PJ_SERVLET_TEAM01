package Controller.music;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;
import Domain1.Service.MusicService;

public class MusicSearchController implements SubController{
	
	private MusicService service = MusicService.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicSearchController execute!");
		
	}
}
