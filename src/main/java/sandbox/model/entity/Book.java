package sandbox.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "BOOK")
public class Book {

	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Integer price;

	@ManyToOne
	@JoinColumn(name = "LIBRARY_ID")
	private Library library;

	public Book(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

	private void setId(Long id) {
	}

}
