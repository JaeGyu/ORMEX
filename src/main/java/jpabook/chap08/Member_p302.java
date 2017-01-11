package jpabook.chap08;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor
public class Member_p302 {

	@Id
	private String id;
	private String username;
	private Integer age;

	@ManyToOne(fetch = FetchType.EAGER)
	private Team_p302 team;

	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
	private List<Order_p302> orders;

	public Member_p302(String id, String username, Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}

}
