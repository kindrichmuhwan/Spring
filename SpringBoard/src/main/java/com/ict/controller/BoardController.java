package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ict.domain.BoardVO;
import com.ict.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;




// 컨트롤러가 컨트롤러 기능을 할 수 있도록 처리해주세요.
@Controller
@Log4j 
public class BoardController {
	
	// 전체 회원을 보려면, 회원목록을 들고오는 메서드를 실행해햐 하고
	// 그러면, 그 메서드를 보유하고 있는 클래스를 선언하고 주입해주줘야합니다.
	// DB 접근시 사용하는 BoardMapper를 선언하고 주입해주세요.
	// 참고) BoardMapperTests.java
    @Autowired
	private BoardMapper boardMapper;
	
	// 전체 글 목록을 볼 수 있는 페이지인 boardList.jsp로 연결되는
	// /boardList 주소를 get방식으로 선언해주세요.
	// 메서드 내부에서는 boardMapper의 .getAllList를 호출해 그 결과를 바인딩합니다.
	@GetMapping(value="/boardList")
	public String getBoardList(long pageNum, Model model) {
		
		// model.addAttribute("바인딩이름",바인딩자료);
		List<BoardVO> boardList= boardMapper.getList(pageNum);
		log.info("넘어온 글 관련 정보 목록 : " + boardList);
		model.addAttribute("boardList",boardList);
		return "boardList";
		
	}
	
	// 글 하나만 조회할 수 있는 데테일 페이지인 boardDetail.jsp로 연결되는
	// /boardDetail 주소를 get방식으로 선언해주세요.
	// 주소 뒤에 ?bno=번호 형식으로 적힌 번호 글만 조회합니다.
	//
	@GetMapping(value="/boardDetail/{bno}")
	public String getBoardDetail(@PathVariable long bno, Model model) {
		BoardVO board = boardMapper.select(bno);
		model.addAttribute("board",board);
		return "boardDetail";
	}
	
	
	// insert 페이지를 위한 form으로 연결되는 컨트롤러를 먼저 만들겠습니다.
	// get방식으로 / boardInsert 주소를 접속시 form페이지로 연결됩니다.
	// 폼 페이지의 이름은 boardForm.jsp입니다.
	
	
	 @GetMapping("boardInsert")
	 public String boardForm() {
		 return "boardForm";
	 }
	
	 
	// /boardInsert인데 post방식을 처리하는 메서드를 새로 만들어주세요.
	 // BoardVO를 입력받도록 해 주시면 실제로는 BoardVO의 멤버변수명으로 들어오는 자료를 입력받습니다.
	 // 입력받은 boardVO를 토대로 mapper쪽의 insert 메서드를 실행해 주시고
	 // 리다이렉트는 return "redirect:/목적지 주소"형식으로 리턴구문을 작성하면 됩니다.
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO board) {
		
		log.info("폼에서 날아온 데이터:" + board);
		boardMapper.insert(board);
		return "redirect:/boardList";
		
	}
	
	// 글삭제 로직은 post방식으로 진행합니다.
	// /boardDelete 주소로 처리하고
	// bno를 받아서 해당 글을 삭제합니다.
	// 글 삭제 버튼은 detail페이지 하단에 form으로 만들어서 bno를 hidden으로 전달하는
	// submit 버튼을 생성해서 처리하게 해주세요.
	@PostMapping(value="boardDelete")
	    public String boardDelete(long bno) {
		boardMapper.delete(bno);
		return "redirect:/boardList";
	}
	
	
	// boardUpdate를 Post방식으로 접속하는 form연결 메서드를 만들겠습니다.
	// update로직은 이미 데이터가 입력이 되어 있어야 합니다.
	// 따라서 내가 수정하고자 하는 글의 정보를 VO로 받아온다음
	// 폼 페이지에 포워딩해서 기입해놔야합니다.
	// 폼페이지 이름은 boardUpdateForm.jsp 입니다.
	@PostMapping("boardUpdateForm")
	public String boardUpdateForm(long bno,Model model) {
		BoardVO board = boardMapper.select(bno);
		boardMapper.update(board);
		log.info("수정폼으로 넘어옴");
		model.addAttribute("board",board);
		
		return "boardUpdateForm";
	}

	// /boardUpdate 를 post방식으로 접속하는 메서드를 만들겠습니다.
	// update(BoardVO)를 실행해서, 폼에서 날려준 데이터를 토대로
	// 해당 글의 내용이 수정되도록 만들어 주시면 됩니다.
	// 수정 후에는 수정 요청이 들어온 글 번호의 디테일페이지로 리다이렉트 시켜주세요.
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(BoardVO board) {
		// update 호출
		boardMapper.update(board);
		//redirect: 주소&글번=getter
		log.info("수정완료폼");
		return "redirect:/boardDetail/"+ board.getBno();
		
	}
	
	
	
	
	
	
	
	
	
	
}












