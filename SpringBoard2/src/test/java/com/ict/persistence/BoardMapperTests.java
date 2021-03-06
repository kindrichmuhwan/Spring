package com.ict.persistence;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ict.domain.BoardVO;
import com.ict.domain.SearchCriteria;
import com.ict.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j 
public class BoardMapperTests {
 
	@Autowired
	private BoardMapper boardMapper;
	
	// 테스트용 메서드의 이름은 testGetList입니다.
	// 테스트 코드가 실행될 수 있도록 작성해주세요.
	
//	@Test
	public void testGetList() {
	List<BoardVO> result = boardMapper.getList(null);
		  log.info("저장된 게시물 정보 :"  + result);
	     //  log.info(boardMapper.getList());
}
//	@Test
	public void testInsert() {
		//vo를 입력받는 insert 메서드 특성상
		// title, content, writer가 채워진 vo를 먼저 생성해야 합니다.
		BoardVO vo = new BoardVO();
		   log.info("입력전 것" + vo);
		vo.setTitle("메롱");
		vo.setContent("화유기펀치몽");
		vo.setWriter("펀치몽");
		
		log.info("채워넣기 후 :"+ vo);
		// vo내부에 데이터가 바인딩된걸 확인했으니 메서드 호출
		boardMapper.insert(vo);
	}
	
	
	
	// select 메서드에 대한 테스트 코드 작성
	//@Test
	public void getSelect() {
		
		// 가져오기(글번호는 두 번째로 큰 번호로 해주세요.)
		BoardVO vo= boardMapper.select(5);
		
		// 로그찍기
		log.info(vo);
	}
		
	
	// delete 메서드에 대한 테스트 코드 작성 후 
	// 삭제 여부를 sqldeveloper나 상단의 getAllList()로 확인해보세요.
	//@Test
	public void getDelete() {
		boardMapper.delete(22);
	}	
	
	//update 메서드에 대한 테스트 코드를 작성해주신 다음
	// 수정여부를 getAllList()로 확인해보세요
//	@Test
	public void getUpdate() {

		BoardVO board = new BoardVO();
		  log.info("전달 데이터 아직 입력안된 vo : "+ board);
		
		board.setTitle("삼장법사");
		board.setContent("화유기꼬붕");
		board.setBno(3);
		
		log.info("전달 데이터가 입력된 vo :" + board);
		
		// 실행해보세요.
		boardMapper.update(board);
	}
	
	
	// vo안쓰고 데이터 전달하기
	// 2개 이상의 파라미터를 따로따로 전달할때는 각 파라미터 왼쪽에 @Param을 붙여줍니다.
//	@Test
	public void getUpdate2() {

		boardMapper.update2("up2로 바꾼제목", "up2로 바꾼본문", 2);
	}
	
	
	@Test
	//구문 생성이 어떻게 되는지 관측하기 위한 테스트 코드
	public void testSearchGetList() {
		SearchCriteria cri = new SearchCriteria();
		cri.setKeyword("이순신");
		cri.setSearchType("t");
		
		boardMapper.getList(cri);
				
		
	}
}
