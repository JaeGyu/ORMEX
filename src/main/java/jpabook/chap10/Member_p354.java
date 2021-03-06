package jpabook.chap10;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member_p354 {

	@Id
	@GeneratedValue
	private Long id;

	private String username;

	private Integer age;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team_p354 team;

}
