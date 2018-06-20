package model;

public class ZenhubInfo {
	private String zenhubToken;
	private String boardId = "83798140";

	public ZenhubInfo() {}
	
	public ZenhubInfo(String token, String board)
	{
		zenhubToken = token;
		boardId = board;
	}
	
	public String getZenhubToken() {
		return zenhubToken;
	}
	public void setZenhubToken(String zenhubToken) {
		this.zenhubToken = zenhubToken;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
}
