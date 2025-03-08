package dao;

import java.util.List;

import model.Ator;

public interface IAtorDao {
	
	public void inserir(Ator ator);
	
	public void atualizar(Ator ator);
	
	public void remover(long id);
	
	public List<Ator> pesquisarPorNome(String ator);

}
