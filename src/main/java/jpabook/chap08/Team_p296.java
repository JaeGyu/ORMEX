package jpabook.chap08;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Team_p296 {

	@Id
	@Column(name = "TEAM_ID")
	private String id;

	private String name;

	private void setId(String id) {
	}

	public Team_p296(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
