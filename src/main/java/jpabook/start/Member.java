package jpabook.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name = "NAME")
	private String username;

	// @Column(name = "AGE")
	private Integer age;

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", age=" + age + "]";
	}

}
