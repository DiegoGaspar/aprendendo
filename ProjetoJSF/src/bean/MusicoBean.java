package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import dao.MusicoDAO;
import elementos.Musico;




@SessionScoped
@ManagedBean
public class MusicoBean {
	private Musico musico = new Musico();
	private List<Musico> lista = new ArrayList<Musico>();
	
	public String salvar() {
		MusicoDAO.salvar(musico);
		musico = new Musico();
		return "Index.xhtml";
	}
	
	public String remover() {
		MusicoDAO.remover(musico);
		musico = new Musico();
		return listar();
	}
	
	public String listar() {
		lista = MusicoDAO.listar();
		return "listarmusico.xhtml";
	}
	

	public String listar2() {
		lista = MusicoDAO.listar();
		return null;
	}
	public String editar() {
		MusicoDAO.editar(musico);
		musico = new Musico();
		return "listarmusico.xhtml";
	}

   public String efetuarLogin() {
	    if(musico.getNome().equals("admin") &&
	       musico.getSenha().equals(1234)) {
	    	listar2();
	      return "home.xhtml";
	    }
	    return null;
	  }

	public String cadastroMusico() {
	
		return "cadastromusico.xhtml";
	}
	
	public Musico getMusico() {
		return musico;
	}

	public void setMusico(Musico musico) {
		this.musico = musico;
	}

	public List<Musico> getLista() {
		return lista;
	}

	public void setLista(List<Musico> lista) {
		this.lista = lista;
	}


}
