package com.kh.spring08.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.kh.spring08.dto.PoketmonDto;

@Service
public class PoketmonMapper implements RowMapper<PoketmonDto> {

	@Override
	public PoketmonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		PoketmonDto dto = new PoketmonDto();
		dto.setPoketmonNo(rs.getInt("poketmon_no"));
		dto.setPoketmonName(rs.getString("poketmon_name"));
		dto.setPoketmonType(rs.getString("poketmon_type"));
		return dto;
	}

}
