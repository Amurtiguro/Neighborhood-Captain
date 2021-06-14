package com.spw.comment.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spw.comment.dao.CommentDao;
import com.spw.comment.vo.CommentVO;

/**
 * 클래스
 * 설명
 * : 댓글 DB테이블 'COMMENT_LIST'의 서비스 클래스 (CommentService 인터페이스의 구현체)
 * 날짜 : 2020/08/10
 * 작성자 : 최정규
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	private static Logger log = Logger.getLogger(CommentServiceImpl.class);

	@Autowired
	private CommentDao commentDao; 

	/**
	 * 설명
	 * : 모든 댓글들을 반환
	 * 매개변수 : CommentVO cvo - 현재 페이지, 그룹 사이즈, 페이지 사이즈
	 * 반환값 : List<CommentVO> - 댓글목록
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentAllList(CommentVO cvo){
		log.info("[ commentAllList 시작 ] cvo => " + cvo);

		List<CommentVO> list = commentDao.commentAllList(cvo);

		log.info("[ commentAllList 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : (상품번호를 통해) 선택한 상품의 댓글들을 반환
	 * 매개변수 : CommentVO cvo - 상품번호
	 * 반환값 : List<CommentVO> - 댓글목록
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	@Override
	public List<CommentVO> commentList(CommentVO cvo) {
		log.info("[ commentList 시작 ] cvo => " + cvo);

		List<CommentVO> list = commentDao.commentList(cvo);

		log.info("[ commentList 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : (댓글번호로)선택한 댓글 반환
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : List<CommentVO> - 댓글
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentSelect(CommentVO cvo){
		log.info("[ commentSelect 시작 ] cvo => " + cvo);

		List<CommentVO> list = commentDao.commentSelect(cvo);

		log.info("[ commentSelect 종료 ] list => " + list);
		return list;
	}

	/**
	 * 설명
	 * : 최상위 댓글을 등록
	 * 매개변수 : CommentVO cvo - 댓글내용, 회원번호, 상품번호
	 * 반환값 : int
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	public int commentRootInsert(CommentVO cvo) {
		log.info("[ commentRootInsert 시작 ] cvo => " + cvo);

		int cnt = commentDao.commentRootInsert(cvo);

		log.info("[ commentRootInsert 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 대 댓글을 등록
	 * 매개변수 : CommentVO cvo - 댓글내용, 회원번호, 상품번호, 그룹번호, 타겟번호
	 * 반환값 : int
	 * 날짜 : 2020/08/10
	 * 작성자 : 최정규
	 */
	public int commentReInsert(CommentVO cvo) {
		log.info("[ commentReInsert 시작 ] cvo => " + cvo);

		int cnt = commentDao.commentReInsert(cvo);

		log.info("[ commentReInsert 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 댓글을 수정
	 * 매개변수 : CommentVO cvo - 댓글번호, 댓글내용, 회원번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentUpdate(CommentVO cvo) {
		log.info("[ commentUpdate 시작 ] cvo => " + cvo);

		int cnt = commentDao.commentUpdate(cvo);

		log.info("[ commentUpdate 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 댓글을 삭제
	 * 매개변수 : CommentVO cvo - 댓글번호, 회원번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentDelete(CommentVO cvo) {
		log.info("[ commentDelete 시작 ] cvo => " + cvo);

		int cnt = commentDao.commentDelete(cvo);

		log.info("[ commentDelete 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : 댓글을 삭제(관리자)
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : int
	 * 날짜 : 2020/08/11
	 * 작성자 : 최정규
	 */
	public int commentDeleteAdmin(CommentVO cvo) {
		log.info("[ commentDeleteAdmin 시작 ] cvo => " + cvo);

		int cnt = commentDao.commentDeleteAdmin(cvo);

		log.info("[ commentDeleteAdmin 종료 ] cnt => " + cnt);
		return cnt;
	}

	/**
	 * 설명
	 * : (댓글번호로)선택한 댓글의 알림을 받을 대상의 회원번호를 반환
	 * 매개변수 : CommentVO cvo - 댓글번호
	 * 반환값 : List<CommentVO>
	 * 날짜 : 2020/08/13
	 * 작성자 : 최정규
	 */
	public List<CommentVO> commentSelectNoti(CommentVO cvo){
		log.info("[ commentSelectNoti 시작 ] cvo => " + cvo);

		List<CommentVO> list = commentDao.commentSelectNoti(cvo);

		log.info("[ commentSelectNoti 종료 ] list => " + list);
		return list;
	}
}
