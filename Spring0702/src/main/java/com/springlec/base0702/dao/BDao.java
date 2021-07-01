package com.springlec.base0702.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0702.dto.BDto;
import com.springlec.base0702.util.Constant;

public class BDao {

	public JdbcTemplate template;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		this.template = Constant.template;
	}
	
	public ArrayList<BDto> list(){
		String A = "select * from board";
		return (ArrayList<BDto>) template.query(A, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String bName, final String bTitle) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String A = "insert into board(bName, bTitle, bDate) values (?,?,now())";
				PreparedStatement ps = con.prepareStatement(A);
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				
				return ps;
			}
		});
		
	}
	
	public void delete(final String strbId) {
		String A = "delete from board where bId = ?"; 
		
		this.template.update(A, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, strbId);
			}
		});
	}
}
