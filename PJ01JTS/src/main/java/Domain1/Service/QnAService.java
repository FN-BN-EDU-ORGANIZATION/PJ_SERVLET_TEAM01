package Domain1.Service;

import ETC.BulletinBoard;

public interface QnAService {

	void setMemberService(MemberService memService);

	

	boolean memService(String sid, String id) throws Exception;

}