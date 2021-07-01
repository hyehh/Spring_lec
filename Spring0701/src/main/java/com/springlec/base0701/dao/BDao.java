package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {

//	DataSource dataSource;
	JdbcTemplate template;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		this.template = Constant.template;
		
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}
	
	// 첫 화면 (select)
	// private 으로 사용하기!
	public ArrayList<BDto> list(){
		
		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
		return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
//		ArrayList<BDto> dtos = null;
//		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//		// 밑에 했던 것들을 한 줄로 한 것임! (BeanPropertyRowMapper-이거 때문에 가능)
//		dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		return dtos;
		
	}
	
	// insert (글작성)
	public void write(final String bName, final String bTitle, final String bContent) {
		// final 쓰는 이유? command 에서 넘긴 데이터를 dao에서 바꿀 수 없도록 하기 위함! (보안상의 이유)
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board (bName, bTitle, bContent, bDate) values (?,?,?,now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, bName);
				preparedStatement.setString(2, bTitle);
				preparedStatement.setString(3, bContent);
				
				// execute 적지 않음!! 이미 createPreparedStatement 이 안에 들어가 있기 때문!
				return preparedStatement;
			}
		});
		
	}
	
	// 상세보기
	public BDto select(int intbId) {
		
		// * 사용하기 위해서 bean에서 mysql 순서 맞춰주기! 
		String query = "select * from mvc_board where bId = " + intbId;
		// 하나만 불러올 경우 queryForObject
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));

	}
	
	// delete (삭제)
	public void delete(final int bId) {
		
		String query = "delete from mvc_board where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bId);
				
			}
		});

	}
	
	// update (수정)
	public void update(final String bName, final String bTitle, final String bContent, final int bId) {
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, bId);
			}
		});

	}
} // -------------BDao
