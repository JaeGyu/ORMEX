package jpabook.chap10;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Team_p354 {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	public Team_p354(String name) {
		this.name = name;
	}

}
