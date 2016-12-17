package jpabook.chap06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Team_p206 {

	@Id
	@GeneratedValue
	@Column(name = "IEAM_ID")
	private Long id;

	private String name;

	public Team_p206(String name) {
		super();
		this.name = name;
	}

	private void setId(Long id) {
	}
}
