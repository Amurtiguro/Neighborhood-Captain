package com.ijw.member.dao;

import java.util.List;

import com.ijw.member.vo.MemberVO;

public interface MemberDAO {
	public MemberVO memLogin(MemberVO memberVO);

	public List<MemberVO> memSelectAll(MemberVO memberVO);

	public int memInsert(MemberVO memberVO);

	public MemberVO memIdfind(MemberVO memberVO);

	public MemberVO memPwfind(MemberVO memberVO);
	
	public int idchk(MemberVO memberVO);

	public int adminDel(MemberVO memberVO);
	
	public int naverInsert(MemberVO memberVO);
	
	public MemberVO naverLogin(MemberVO memberVO);
	
	public MemberVO naverSelect(MemberVO memberVO);
}
