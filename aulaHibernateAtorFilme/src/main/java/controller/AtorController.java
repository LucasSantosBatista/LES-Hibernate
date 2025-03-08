package controller;

import java.util.List;

import dao.AtorDao;
import model.Ator;

public class AtorController {

	private AtorDao atorDao = new AtorDao();
	
	public void inserir(Ator ator) {
		atorDao.inserir(ator);
	}
	
	public void atualizar(Ator ator) {
		atorDao.atualizar(ator);
	}
	
	public void remover(long id) {
		atorDao.remover(id);
	}
	
	public List<Ator> pesquisarPorNome (String nome){
		return atorDao.pesquisarPorNome(nome);
	}	
}
