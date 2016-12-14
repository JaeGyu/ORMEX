package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
//@ToString
public class MemberChap05 {

	@Id
	@Column(name = "MEMBER_ID")
	private String id;

	private String username;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private TeamChap05 team;

	public MemberChap05(String id, String username) {
		this.id = id;
		this.username = username;
	}

	@Override
	public String toString() {
		return "MemberChap05 [id=" + id + ", username=" + username + ", team name=" + team.getName() + "]";
	}

	
}
