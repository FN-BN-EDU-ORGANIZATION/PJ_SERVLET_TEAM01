package Domain1.Dao;

import java.util.ArrayList;
import java.util.List;

import Domain1.Dto.MemberDto;
import Domain1.Dto.MusicSearchHistoryDto;

public class MusicSearchHistoryDaoImpl extends ConnectionPool implements MusicSearchHistoryDao {
	 
	private static MusicSearchHistoryDao instance;
	public static MusicSearchHistoryDao getInstance() {
		if(instance == null)
			instance = new MusicSearchHistoryDaoImpl();
		return instance;
	}
	public MusicSearchHistoryDaoImpl(){
	}		
	

	@Override
	public int insert(MemberDto dto, String searchText) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_searchhistory values(null,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, searchText);
		int result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	@Override
	public List<MusicSearchHistoryDto> select(String id) throws Exception{
		List<MusicSearchHistoryDto> list = new ArrayList();
		MusicSearchHistoryDto dto = null;
		MemberDto mdto = null;
		pstmt = conn.prepareStatement("select * from tbl_searchhistory where id=?");
		pstmt.setString(1, id);
		rs=pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto = new MusicSearchHistoryDto();
				dto.setHistoryNo(rs.getInt("historyNo"));
				dto.setID(rs.getString("Id"));
				dto.setSearchHistory(rs.getString("searchHistory"));
				list.add(dto);
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}
	
}
