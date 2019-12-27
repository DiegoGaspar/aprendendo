package elementos;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Instrumento {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "instrumento")
	private List < Musico > musicos = new ArrayList<Musico>();
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<Musico> getMusicos() {
		return musicos;
	}
	public void setMusicos(List<Musico> musicos) {
		this.musicos = musicos;
	}

}
