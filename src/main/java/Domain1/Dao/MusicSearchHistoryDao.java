package Domain1.Dao;

import Domain1.Dto.MusicSearchHistoryDto;

public interface MusicSearchHistoryDao {

	int insert(MusicSearchHistoryDto dto, String searchText) throws Exception;

}