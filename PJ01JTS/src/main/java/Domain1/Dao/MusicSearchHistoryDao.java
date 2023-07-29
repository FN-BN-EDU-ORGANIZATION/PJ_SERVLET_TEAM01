package Domain1.Dao;

import java.util.List;

import Domain1.Dto.MemberDto;
import Domain1.Dto.MusicSearchHistoryDto;

public interface MusicSearchHistoryDao {

	int insert(MemberDto dto, String searchText) throws Exception;

	List<MusicSearchHistoryDto> select(String id) throws Exception;

}