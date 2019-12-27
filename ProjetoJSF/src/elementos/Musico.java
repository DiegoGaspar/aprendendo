package elementos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Musico {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String email;
	private Integer senha;
	
	@ManyToOne
	private Instrumento instrumento = new Instrumento();
	

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getSenha() {
		return senha;
	}
	public void setSenha(Integer senha) {
		this.senha = senha;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	
	
}
