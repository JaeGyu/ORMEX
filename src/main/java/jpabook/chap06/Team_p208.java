package jpabook.chap06;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Team_p208 {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team")
	private List<Member_p208> members = new ArrayList<>();

	public void addMember(Member_p208 member) {
		this.members.add(member);

		if (member.getTeam() != this) {
			member.setTeam(this);
		}
	}

}
