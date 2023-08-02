package Domain1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Dto.MemberDto;
import Domain1.Service.Auth.Session;

public class MemberServiceImpl implements MemberService {
	// 세션정보저장
	public Map<String, Session> sessionMap;

	private MemberDao dao;

	private Map<String, List<String>> memberSearchHistoryMap;

	// 싱글톤
	private static MemberService instance;

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}

	// 회원 가입하기
	@Override
	public boolean memberJoin(MemberDto dto) throws Exception {
		int result = dao.insert(dto);
		if (result > 0)
			return true;
		return false;
	}

	// 회원 조회하기(전체조회) - 멤버

	public List<MemberDto> memberSearch(HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		List<MemberDto> list = dao.select();
		
		List<MemberDto> roleUserMembers = new ArrayList<>();
		for (MemberDto memberdto : list) {
		    if ("ROLE_USER".equals(memberdto.getRole())) {
		    	roleUserMembers.add(memberdto);
		    }
		}
		return roleUserMembers;
	}
	
	// 회원 조회하기(한명) - 멤버
	@Override
	public MemberDto memberSearchOne(String role, String id) throws Exception {
		if (role.equals("ROLE_MEMBER"))
			return dao.select(id);
		return null;
	}

	@Override
	// 회원 조회하기(한 회원) - 로그인한 회원만
	public MemberDto memberSearch(String id, String sid) throws Exception {
		Session session = sessionMap.get(sid);
		if (session != null && session.getId().equals(id))
			return dao.select(id);
		return null;
	}

	// 회원 수정하기 - 본인 확인

	@Override
	public boolean memberUpdate(MemberDto dto) throws Exception {
			int result = dao.update(dto);
			if (result > 0)
				return true;
		return false;
	}

	// 회원 삭제하기
	@Override
	public boolean memberDelete(String id, String sid) throws Exception {

		Session session = sessionMap.get(sid);
		if (session != null && session.getId().equals(id)) {
			int result = dao.delete(id);
			if (result > 0)
				return true;
		}
		return false;
	}

	// 로그인
	@Override
	public boolean login(HttpServletRequest req) throws Exception {

		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("pw");
		// 1 ID/PW 체크 -> Dao 전달받은 id와 일치하는 정보를 가져와서 pw일치 확인
		MemberDto dbDto = dao.select(id);
		if (dbDto == null) {
			System.out.println("[ERROR] Login Fail.. 아이디가 일치하지 않습니다.");
			req.setAttribute("msg", "[ERROR] Login Fail.. 아이디가 일치하지 않습니다.");
			return false;
		}
		if (!pw.equals(dbDto.getPw())) {
			System.out.println("[ERROR] Login Fail.. 패스워드가 일치하지 않습니다");
			req.setAttribute("msg", "[ERROR] Login Fail.. 패스워드가 일치하지 않습니다.");
			return false;
		}
		System.out.println("login func's dbDto" + dbDto);
		HttpSession session = req.getSession(false);
		System.out.println("login func's session" + session);
		session.setAttribute("id", id);
		session.setAttribute("role", dbDto.getRole());
		session.setAttribute("userDto", dbDto);
		return true;

	}

	// 검색 기록 추가
	@Override
	public List<String> addSearchHistory(String memberId, String searchText) {
		List<String> searchHistory = memberSearchHistoryMap.get(memberId);
		if (searchHistory == null) {
			searchHistory = new ArrayList<>();
			memberSearchHistoryMap.put(memberId, searchHistory);
		}
		searchHistory.add(searchText);
		System.out.println("MemberServiceImpl's addSearchHistory : " + searchHistory);

		return memberSearchHistoryMap.get(memberId);
	}

	// 검색 기록 조회
	@Override
	public List<String> getSearchHistory(String memberId) {
		return memberSearchHistoryMap.get(memberId);
	}

	// 중복확인
	@Override
	public boolean idcheck(String id) throws Exception {
		MemberDto dbDto = dao.select(id);
		if (dbDto == null) {
			System.out.println("[INFO] 사용가능한 아이디입니다.");
			return true;
		}
		System.out.println("[ERROR] 이미 사용중인 아이디입니다.");
		return false;
	}

	// 역할반환함수
	@Override
	public String getRole(String sid) {
		Session session = sessionMap.get(sid);
		System.out.println("getRole's Session : " + session);
		if (session != null)
			return session.getRole();

		return null;
	}

	@Override
	public boolean logout(String id, String sid) {
		// TODO Auto-generated method stub
		return false;
	}



}