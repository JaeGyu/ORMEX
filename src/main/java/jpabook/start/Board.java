package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
@Entity(name = "board")
// @SequenceGenerator(name = "BOARD_SEQ_GENERATOR", sequenceName = "BOARD_SEQ",
// initialValue = 1, allocationSize = 20)
//@TableGenerator(name = "BOARD_SEQ_GENERATOR", table = "MY_SEQUENCES", pkColumnValue = "BOARD_SEQ", allocationSize = 1)
// allocationSize <- 이 옵션이 적용이 안됨 H2 db라서 그런것인지...
public class Board {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "BOARD_SEQ_GENERATOR")
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "BOARD_SEQ_GENERATOR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "data", length = 255)
	private String data;
}
