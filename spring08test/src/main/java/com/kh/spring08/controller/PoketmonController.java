package com.kh.spring08.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.dao.PoketmonDao;
import com.kh.spring08.dto.PoketmonDto;
import com.kh.spring08.service.AttachmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "포켓몬 테스트 API", description = "포켓몬 테스트를 진행하는 API")
@Controller
@RequestMapping("/poketmon")
public class PoketmonController {

	
	@Autowired
	private PoketmonDao poketmonDao;
	@Autowired
	private AttachmentService attachmentService;

//	@RequestMapping("/insert1")//입력
	@Operation(summary = "포켓몬 정보 Get", description = "GET 방식으로 JSP에 접근합니다")
	@GetMapping("/insert") // GET방식만 처리
	public String insert() {
		return "/WEB-INF/views/poketmon/insert1.jsp";
	}

//	@RequestMapping("/insert2")//처리
//	@PostMapping("/insert")//POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto dto) {
//		dao.insert(dto);
//		//return "포켓몬스터 등록 완료";//과거
//		return "redirect:insertComplete";//리다이렉트(상대경로)
//		//return "redirect:/poketmon/insertComplete";//리다이렉트(절대경로)
//	}

	// 이 메소드는 하나의 트랜잭션(세트메뉴)으로 취급됨
	// Database의 C.U.D 작업을 여러 번 하는 경우 전체를 하나로 생각하여 처리
	// 다 되거나, 다 안되거나 둘 중 하나밖에 없음
	@Operation(summary = "포켓몬 정보 POST", description = "JSP에서 POST전송으로 받은 값을 JDBC를 통해 INSERT")
//	@ApiResponses(value= {
//			@ApiResponse(responseCode = "200", description = "포켓몬 정보 Insert 성공", content = @Content(schema = @Schema(implementation = PoketmonDto.class))),
//			@ApiResponse(responseCode = "404", description = "포켓몬 정보 Insert 실패")
//	})
	@Transactional
	@PostMapping("/insert") // POST방식(첨부파일) 처리
	public String insert(@ModelAttribute PoketmonDto poketmonDto, @RequestParam MultipartFile attach)
			throws IllegalStateException, IOException {
		// 1. 포켓몬스터 번호 생성
		int poketmonNo = poketmonDao.sequence();
		poketmonDto.setPoketmonNo(poketmonNo);

		// 2. 포켓몬스터 등록(poketmon)
		poketmonDao.insertWithSequence(poketmonDto);

		// MultipartFile은 비어있을 수 있으므로 조건으로 검사를 해야한다
		if (attach.isEmpty() == false) {
			// 3-4. 첨부파일 등록 및 저장
			int attachmentNo = attachmentService.save(attach);
			// 5. 첨부파일이 있다면 포켓몬스터와 첨부파일을 연결(poketmon_image)
			poketmonDao.connect(poketmonNo, attachmentNo);
		}

		return "redirect:insertComplete";// 리다이렉트(상대경로)
	}

	@RequestMapping("/insertComplete") // 완료
	public String insertComplete() {
		return "/WEB-INF/views/poketmon/insert3.jsp";
	}

	// 목록(검색) 페이지
	// - DB를 조회한 결과를 화면에 전달한 뒤 출력 (Model 필요)
	@RequestMapping("/list")
	public String list(Model model, @RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;

		List<PoketmonDto> list = isSearch ? poketmonDao.selectList(column, keyword) : poketmonDao.selectList();

		model.addAttribute("column", column);// 검색분류
		model.addAttribute("keyword", keyword);// 검색어
		model.addAttribute("list", list);// 조회결과
		return "/WEB-INF/views/poketmon/list.jsp";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam int poketmonNo, Model model) {
		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/detail.jsp";
	}

	// 삭제 - 첨부파일을 지우고 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int poketmonNo) {
		try {// 일단 파일을 지워봐
			int attachmentNo = poketmonDao.findImage(poketmonNo);
			attachmentService.delete(attachmentNo);
		} catch (Exception e) {
		} // 문제가 생기면 넘어가
		finally {// 문제가 생기든 말든 포켓몬은 무조건 지워야돼
			poketmonDao.delete(poketmonNo);
		}
		return "redirect:list";// 목록으로 추방
	}

	// 수정(입력) - 화면에 띄울 정보를 구해서 전달해야 한다
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int poketmonNo) {
		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/edit.jsp";
	}

	// 수정(처리)
	@PostMapping("/edit")
	public String edit(@ModelAttribute PoketmonDto dto) {
		boolean result = poketmonDao.update(dto);
		// return "redirect:detail?poketmonNo=${dto.poketmonNo}";//잘못된표현
		return "redirect:detail?poketmonNo=" + dto.getPoketmonNo();
	}

	// 이미지 제공 페이지
	@RequestMapping("/image")
	public String image(@RequestParam int poketmonNo) {
		try {// 플랜A - 이미지가 있으면
			Integer attachmentNo = poketmonDao.findImage(poketmonNo);
			return "redirect:/attach/download?attachmentNo=" + attachmentNo;
		} catch (Exception e) {// 플랜B - 이미지가 없으면
			// return "redirect:/images/dummy.png";
			return "redirect:https://placehold.co/150";
		}
	}

}
