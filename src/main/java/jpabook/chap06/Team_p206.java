package jpabook.chap06;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Team_p206 {

	@Id
	@GeneratedValue
	@Column(name = "IEAM_ID")
	private Long id;

	private String name;
}
