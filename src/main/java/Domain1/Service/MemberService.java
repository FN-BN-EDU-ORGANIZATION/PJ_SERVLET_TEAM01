package Domain1.Service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain1.Dto.MemberDto;

public interface MemberService {

	//회원 가입하기
		boolean memberJoin(MemberDto dto) throws Exception;

		//회원 조회하기(전체조회) - 사서
		//List<MemberDto> memberSearch(String sid) throws Exception;
		List<MemberDto> memberSearch(HttpServletRequest req) throws Exception;

		//회원 조회하기(한명) - 멤버
		MemberDto memberSearchOne(HttpServletRequest req) throws Exception;
		
		//회원 조회하기(한 회원) - 로그인한 회원만
		MemberDto memberSearch(String id, String sid) throws Exception;

		//회원 수정하기 - 본인 확인
		boolean memberUpdate(MemberDto dto) throws Exception;
		

		//회원 삭제하기
		boolean memberDelete(HttpServletRequest req) throws Exception;		
		
		//로그인
		boolean login(HttpServletRequest req) throws Exception;


		//로그아웃
		boolean logout(String id, String sid);

		//중복확인
		boolean idcheck(String id) throws Exception;

		//역할반환함수
		String getRole(String sid);

		boolean pwCheck(HttpServletRequest req, HttpServletResponse resp) throws Exception;

		boolean isPhoneValid(HttpServletRequest req, HttpServletResponse resp) throws Exception;


		
}
