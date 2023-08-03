package Domain1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Dto.MemberDto;
import Domain1.Service.Auth.Session;



public class MemberServiceImpl implements MemberService {
		//세션정보저장
		public Map<String,Session> sessionMap;
		
		private MemberDao dao;
		
		private Map<String, List<String>> memberSearchHistoryMap;
	
		//싱글톤
		private static MemberService instance;
		public static MemberService getInstance() {
			if(instance == null)
				instance = new MemberServiceImpl();
			return instance;
		}
		public MemberServiceImpl() {
			dao = MemberDaoImpl.getInstance();
		}
		//회원 가입하기
		@Override
		public boolean memberJoin(MemberDto dto) throws Exception {
			int result = dao.insert(dto);
			if (result > 0)
				return true;
			return false;
		}

		//회원 조회하기(전체조회) - 사서
		@Override
		public List<MemberDto> memberSearch(HttpServletRequest req) throws Exception{
//		HttpSession session = req.getSession();
		List<MemberDto> list = dao.select();
		
		List<MemberDto> roleUserMembers = new ArrayList<>();
		for (MemberDto memberdto : list) {
		    if ("ROLE_USER".equals(memberdto.getRole())) {
		    	roleUserMembers.add(memberdto);
		    }
		}
		return roleUserMembers;
	}
		//회원 조회하기(한명) - 멤버
		@Override
		public MemberDto memberSearchOne(HttpServletRequest req) throws Exception {
			String id = (String) req.getParameter("id");
			MemberDto userInfo = dao.select(id);
			return userInfo;
		}
		
		//회원 조회하기(한 회원) - 로그인한 회원만
		@Override
		public MemberDto memberSearch(String id, String sid) throws Exception {
			Session session = sessionMap.get(sid);
			if (session != null && session.getId().equals(id))
				return dao.select(id);
			return null;
		}
		//회원 수정하기 - 본인 확인
		@Override
		public boolean memberUpdate(MemberDto dto) throws Exception {
				int result = dao.update(dto);
				if (result > 0)
				return true;
			return false;
		}
		//회원 삭제하기
		@Override
		
		
		public boolean memberDelete(HttpServletRequest req) throws Exception{
			
			String id = req.getParameter("id");
			if(req!=null && req.getParameter("id").equals(id))
			{
				int result = dao.delete(id);
				if(result>0)
					return true;			
			}
			return false;
		}
		
		
		//로그인
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
	    
		//로그아웃
		@Override
		public boolean logout(String id,String sid) {
			Session session = sessionMap.get(sid);
			if(! session.getId().equals(id)) {
				System.out.println("[ERROR] ID가 일치하지 않습니다.");
				return false;
			}
			sessionMap.remove(sid);
			return true;
		}
		
		//중복확인
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
		
		//역할반환함수
		@Override
		public String getRole(String sid) {
			Session session = sessionMap.get(sid);
			System.out.println("getRole's Session : " + session);
			if (session != null)
				return session.getRole();

			return null;
		}
		
		 // pw와 pwCheck가 일치하는지 검사 (클라이언트 측에서도 검사 가능하지만, 서버에서도 추가 검사를 수행하는 것이 좋음)
		@Override
		public boolean pwCheck(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String pwCheck = req.getParameter("pwc");
		    String pw = req.getParameter("pw");
		    if (!pw.equals(pwCheck)) {
		        System.out.println("비밀번호 확인이 일치하지 않습니다.");
		        resp.sendRedirect(req.getContextPath() + "/join.do");		        
		    }
		    return false;
		}
		
		@Override
		public boolean isPhoneValid(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			String phone = req.getParameter("phone");
			String phoneRegex = "^\\d{3}-\\d{3,4}-\\d{4}$";
			boolean isPhoneValid = Pattern.matches(phoneRegex, phone);
			if (!isPhoneValid) {
			
			    System.out.println("전화번호 형식이 올바르지 않습니다. (000-0000-0000 형식으로 입력하세요.)");
			    resp.sendRedirect(req.getContextPath() + "/join.do");
			    return false;
			  }
			return isPhoneValid;
		}
	
}