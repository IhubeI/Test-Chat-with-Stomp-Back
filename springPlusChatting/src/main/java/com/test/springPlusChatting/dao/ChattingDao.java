package com.test.springPlusChatting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.springPlusChatting.dto.ChattingRoom;

@Repository
public class ChattingDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ChattingRoom> selectRoomList(String memberId){
		
		return null;
	}

}
