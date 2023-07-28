package Domain1.Dao;

import Domain1.Dto.MemberDto;
import Domain1.Dto.MusicSearchHistoryDto;

public class MusicSearchHistoryDaoImpl extends ConnectionPool implements MusicSearchHistoryDao {
	 
	
	

	@Override
	public int insert(MusicSearchHistoryDto dto, String searchText) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_searchhistory values(null,?,?)");
		pstmt.setString(1, dto.getID());
		pstmt.setString(2, searchText);
		int result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
}
