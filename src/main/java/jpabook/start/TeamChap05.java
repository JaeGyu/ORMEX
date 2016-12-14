package jpabook.start;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class TeamChap05 {

	@Id
	@Column(name = "TEAM_ID")
	private String id;
	private String name;

	@OneToMany(mappedBy = "team")
	private List<MemberChap05> members = new ArrayList<MemberChap05>();

	public TeamChap05(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeamChap05 [id=" + id + ", name=" + name + ", members size=" + members.size() + "]";
	}
	
	

}
