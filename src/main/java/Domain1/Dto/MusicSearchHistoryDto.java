package Domain1.Dto;

public class MusicSearchHistoryDto {
	private int historyNo;
	private String ID;
	private String searchHistory;
	
	public MusicSearchHistoryDto(){}

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSearchHistory() {
		return searchHistory;
	}

	public void setSearchHistory(String searchHistory) {
		this.searchHistory = searchHistory;
	}

	@Override
	public String toString() {
		return "MusicSearchHistoryDto [historyNo=" + historyNo + ", ID=" + ID + ", searchHistory=" + searchHistory
				+ "]";
	}

	public MusicSearchHistoryDto(int historyNo, String iD, String searchHistory) {
		super();
		this.historyNo = historyNo;
		ID = iD;
		this.searchHistory = searchHistory;
	}
	
}
