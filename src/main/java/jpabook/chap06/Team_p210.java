package jpabook.chap06;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Team_p210 {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	
	private String name;

	@OneToMany
	@JoinColumn(name = "TEAM_ID")
	private List<Member_p210> members = new ArrayList<>();

}
