package sandbox.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "std_id")
	private Long id;

	@Column(name = "std_name")
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	private void setId(Long id) {
	}
}
