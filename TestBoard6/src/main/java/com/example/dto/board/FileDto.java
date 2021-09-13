package com.example.dto.board;

public class FileDto {
	public FileDto() {}
	
	public FileDto(String fileName, int boardNum) {
		this.fileName = fileName;
		this.boardNum = boardNum;
	}

	public FileDto(String filePath, String fileName, int boardNum) {
		this.filePath = filePath;
		this.fileName = fileName;
		this.boardNum = boardNum;
	}
	
	String filePath;
	String fileName;
	int boardNum;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
}
