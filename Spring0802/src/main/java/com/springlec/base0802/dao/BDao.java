package com.springlec.base0802.dao;

import java.util.ArrayList;

import com.springlec.base0802.dto.BDto;

public interface BDao {

	// 전체 결과
	public ArrayList<BDto> listDao();
	
	// 상세 보기
	public BDto viewDao(int seqno);
	
	// 등록
	public void writeDao(String name, String telno, String address, String email, String relation);
	
	// 수정
	public void modifyDao(String name, String telno, String address, String email, String relation, int seqno);
	
	// 삭제
	public void deleteDao(int seqno);
	
	// 검색 결과 값
	public ArrayList<BDto> listQuery(String query, String content);
	
}
