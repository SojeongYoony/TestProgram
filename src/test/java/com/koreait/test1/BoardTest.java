package com.koreait.test1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfig;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BeanConfig.class})
public class BoardTest {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Test
	public void insertTest() {
		Board board = new Board();
		board.setWriter("테스터");
		board.setTitle("테스트제목");
		board.setContent("테스트내용");
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		assertEquals("테스트성공", 1, boardDAO.insertBoard(board));
	}
	
	@Test
	public void selectTest() {
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		Board board = new Board();
		board = boardDAO.selectByIdx(9999);
		System.out.println(board);
		assertNotNull("테스트 데이터 조회 실패 ", board);
	}

	
	@Test
	public void updateTest() {
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		Board board = new Board();
		board.setIdx(9999);
		board.setTitle("변경공지사항제목");
		board.setContent("변경공지사항내용");
		
		int result = boardDAO.updateBoard(board);
		System.out.println(result);
		assertEquals("수정성공", 1, result);
	}
	
	@Test
	public void deleteTest() {
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.deleteBoard(9999);
		System.out.println(result);
		assertEquals("삭제성공", 1, result);
		
	}
	
}
