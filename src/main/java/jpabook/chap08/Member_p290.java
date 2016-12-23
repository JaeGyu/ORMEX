package jpabook.chap08;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Member_p290 {
	@Id
	@Column(name = "MEMBER_ID")
	private String memberId;

	private String username;

	public Member_p290(String memberId, String username) {
		this.memberId = memberId;
		this.username = username;
	}

}
