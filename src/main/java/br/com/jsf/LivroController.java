package br.com.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

@ManagedBean
@SessionScoped
public class LivroController {

	private Livro livro;
	private DataModel listarLivros;
	private DataModel<Livro> listaTitulosLivros;

	public DataModel<Livro> listarLivros(){
		List<Livro> lista = new LivroDaoImp().list();
		listarLivros = new ListDataModel(lista);
		return listarLivros;
		
					
	}
	public DataModel listarTitulos() {
		List<Livro> listaTitulo = new LivroDaoImp().listaTitulos();
		listaTitulosLivros = new ListDataModel(listaTitulo);
		return listaTitulosLivros;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;   
	}
	public String prepararAdicionarLivro(){
		livro = new Livro();
		return "gerenciarLivro";
	}
	public String prepararAlterarLivro(){
		livro = (Livro)(listarLivros.getRowData());
		return "gerenciarLivro";
	}
	public String excluirLivro(){
		Livro livroTemp = (Livro)(listarLivros.getRowData());
		LivroDao dao = new LivroDaoImp();
		dao.remove(livroTemp);
		return "index";
	}
	public String adicionarLivro(){
		LivroDao dao = new LivroDaoImp();
		dao.save(livro);
		return "index";
	}
	public String alterarLivro(){
		LivroDao dao = new LivroDaoImp();
		dao.update(livro);
		return "index";
	}

	public DataModel<Livro> getListaTitulosLivros() {
		return listaTitulosLivros;
	}
	
	public void setListaTitulosLivros(DataModel<Livro> listaTitulosLivros) {
		this.listaTitulosLivros = listaTitulosLivros;
	}
	
	
}          