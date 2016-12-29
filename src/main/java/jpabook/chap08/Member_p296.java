package jpabook.chap08;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Member_p296 {

	@Id
	@Column(name = "MEMBER_ID")
	private String id;

	private String username;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team_p296 team;

	public Member_p296(String id, String username) {
		this.id = id;
		this.username = username;
	}

	private void setId(String id) {
	}

}
