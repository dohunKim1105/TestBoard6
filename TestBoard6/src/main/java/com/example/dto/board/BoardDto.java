package com.example.dto.board;

import java.time.*;

public class BoardDto {
	private int num;
	private int cnt;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime regdate;
	
	public BoardDto() {
		
	}
	
	public BoardDto(String title, String content, String writer, int cnt) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.cnt = cnt;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	
	
}
