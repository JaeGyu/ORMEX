package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TeamChap05 {

	@Id
	@Column(name = "TEAM_ID")
	private String id;

	private String name;

}
