package jpabook.chap09;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address_p322 {

	@Column(name = "city")
	private String city;
	private String street;
	private String zipcode;

}
