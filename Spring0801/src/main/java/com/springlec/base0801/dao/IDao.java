package com.springlec.base0801.dao;

import java.util.ArrayList;

import com.springlec.base0801.dto.ContentDto;

public interface IDao {

	// 전체 검색 
	public ArrayList<ContentDto> listDao();
	
	// 입력
	public void writeDao(String mWriter, String mContent);
	
	// 삭제 (type의 경우 Interface에서 정하는 것임!) -> 그렇기 때문에 int로 넘겨주면 xml에서 넘겨받는 값인 #{param1} 는 int로 받음!
	public void deleteDao(int mId);
//	public void deleteDao(String mId);
}
