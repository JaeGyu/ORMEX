package jpabook.chap09;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member_p322 {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@Embedded
	private Period_p322 workPeriod;

	@Embedded
	private Address_p322 homeAddress;

}
