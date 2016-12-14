package sandbox.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "LIBRARY")
public class Library {

	@Id
	@GeneratedValue
	@Column(name="LIBRARY_ID")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "library")
	private List<Book> books = new ArrayList<Book>();

	public Library(String name) {
		this.name = name;
	}
	
	private void setId(Long id){}
	
}
