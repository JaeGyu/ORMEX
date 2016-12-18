package jpabook.chap06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude="team")
public class Member_p208 {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	private String username;

	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team_p208 team;

	public void setTeam(Team_p208 team) {
		this.team = team;

		if (!team.getMembers().contains(this)) {
			team.getMembers().add(this);
		}
	}
}
