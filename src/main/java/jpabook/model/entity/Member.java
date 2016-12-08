package jpabook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Member {
	
	@Id
	@GeneratedValue//전략을 생략하면 기본적으로는 auto이다. 즉 방언에따라 자동으로 선택되어진다.
	@Column(name="MEMBER_ID")
	private Long id;
	
	private String name;
	
	private String city;
	private String street;
	private String zipcode;
	
}
