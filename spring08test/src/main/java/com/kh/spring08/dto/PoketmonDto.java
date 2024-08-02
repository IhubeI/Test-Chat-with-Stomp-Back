package com.kh.spring08.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//스프링에서 유일하게 등록하지 않는 클래스 (몇 개가 사용될 지 예상할 수 없음)
//@Setter @Getter
//@NoArgsConstructor @ToString
@Schema(description = "포켓몬 DTO")
@Data
public class PoketmonDto {
	@Schema(description = "포켓몬 번호", nullable = false)
	private int poketmonNo;
	@Schema(description = "포켓몬 이름", nullable = false)
	private String poketmonName;
	@Schema(description = "포켓몬 타입", nullable = false)
	private String poketmonType;
}