package br.com.jsf;

import java.util.List;

public interface LivroDao {
	public void save(Livro livro);
	public Livro getLivro(long id);
	public List<Livro> list();
	public void remove(Livro livro);
	public void update(Livro livro);
    public List<Livro> listaTitulos();
}
