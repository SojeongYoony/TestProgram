package com.koreait.test1.dao;

import java.util.ArrayList;

import com.koreait.test1.dto.Board;

public interface BoardDAO {

	public ArrayList<Board> selectBoardList();
	public int selectBoardCount();
	public int insertBoard(Board board);
	public Board selectByIdx(int idx);
	public int updateBoard(Board board);
	public int deleteBoard(int idx);
	
}
