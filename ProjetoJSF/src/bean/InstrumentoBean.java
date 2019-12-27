package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.InstrumentoDAO;
import elementos.Instrumento;

@SessionScoped
@ManagedBean
public class InstrumentoBean {
	private Instrumento instrumento = new Instrumento();
	private List<Instrumento> lista = new ArrayList<Instrumento>();
	
	public String salvar() {
		InstrumentoDAO.salvar(instrumento);
		instrumento = new Instrumento();
		return null;
	}
	public String paginaCadastro(){
		instrumento = new Instrumento();
		return "cadastroinstrumento.xhtml";
	}
	
	public String remover() {
		InstrumentoDAO.remover(instrumento);
		return listar();
	}
	
	public String listaSemRetorno() {
		lista = InstrumentoDAO.listar();
		return "cadastromusico.xhtml";
	}
	
	public String listar() {
		lista = InstrumentoDAO.listar();
		return "listarinstrumento.xhtml";
	}
	
	public String editar() {
		InstrumentoDAO.editar(instrumento);
		instrumento = new Instrumento();
		return "listarinstrumento.xhtml";
	}

	
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	public List<Instrumento> getLista() {
		return lista;
	}
	public void setLista(List<Instrumento> lista) {
		this.lista = lista;
	}

}
