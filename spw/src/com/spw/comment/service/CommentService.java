package com.spw.comment.service;

import java.util.List;

import com.spw.comment.vo.CommentVO;

/**
 * 클래스
 * 설명
 * : 댓글 DB테이블 'COMMENT_LIST'의 서비스 인터페이스
 * 날짜 : 2020/08/10
 * 작성자 : 최정규
 */
public interface CommentService {

	/**
	 * 설명
	 * : 모든 댓글들을 반환
	 * 매개변수 : CommentVO cvo - 현재 페이지, 그룹 사이즈, 페이지 사이즈
	 * 반환값 : List<CommentVO> - 댓글목록
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentAllList(CommentVO cvo);

	/**
	 * 설명
	 * : (상품번호를 통해) 선택한 상품의 댓글들을 반환
	 * 매개변수 : CommentVO cvo - 상품번호
	 * 반환값 : List<CommentVO> - 댓글목록
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentList(CommentVO cvo);

	/**
	 * 설명
	 * : (댓글번호로)선택한 댓글 반환
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : List<CommentVO> - 댓글
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentSelect(CommentVO cvo);

	/**
	 * 설명
	 * : 최상위 댓글을 등록
	 * 매개변수 : CommentVO cvo - 댓글내용, 회원번호, 상품번호
	 * 반환값 : int
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	public int commentRootInsert(CommentVO cvo);

	/**
	 * 설명
	 * : 대 댓글을 등록
	 * 매개변수 : CommentVO cvo - 댓글내용, 회원번호, 상품번호, 그룹번호, 타겟번호
	 * 반환값 : int
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	public int commentReInsert(CommentVO cvo);

	/**
	 * 설명
	 * : 댓글을 수정
	 * 매개변수 : CommentVO cvo - 댓글번호, 댓글내용, 회원번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentUpdate(CommentVO cvo);

	/**
	 * 설명
	 * : 댓글을 삭제
	 * 매개변수 : CommentVO cvo - 댓글번호, 회원번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentDelete(CommentVO cvo);

	/**
	 * 설명
	 * : 댓글을 삭제(관리자)
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentDeleteAdmin(CommentVO cvo);

	/**
	 * 설명
	 * : (댓글번호로)선택한 댓글의 알림을 받을 대상의 회원번호를 반환
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : List<CommentVO>
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentSelectNoti(CommentVO cvo);
}
