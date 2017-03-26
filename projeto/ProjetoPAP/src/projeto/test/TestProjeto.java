package projeto.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import projeto.dao.FactoryDao;
import projeto.dao.InterfaceDao;
import projeto.entity.Competencia;
import projeto.entity.Projeto;

public class TestProjeto {
	
	@Test
	public void cadastrarProjeto(){
		Projeto p = new Projeto();
		
		p.setNome("Projeto X");
		
		Date data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.print(formatarDate.format(data));
		System.out.println(data.toString());
		p.setDataEntrega("2017/03/20");
		
	
	    
		
		
		System.out.println("TESTE!!!!!!!!!!!!!");
		
		
		InterfaceDao<Competencia> daoComp = FactoryDao.createCompetenciaDao();
		
		List<Competencia> competencias = new ArrayList<Competencia>();;
		
		Competencia c = new Competencia();
		
		c = daoComp.getObjById(1);
		
		competencias.add(c);
		
		c = daoComp.getObjById(2);		
		
		competencias.add(c);
		

		
		p.setCompetencias((List<Competencia>) competencias);
		
		InterfaceDao<Projeto> dao = FactoryDao.createProjetoDao();
		dao.salvar(p);
		
	}
	
	@Test
	public void listarProjeto() {		
		List<Projeto> projetos = FactoryDao.createProjetoDao().listar();
		if (projetos.size() > 0) {
			//funcionou
		}
	}
	
	@Test
	public void alterarProjeto(){
		InterfaceDao<Projeto> daoProj = FactoryDao.createProjetoDao();
		Projeto proj = daoProj.getObjById(1);	
		proj.setNome("Projeto Alterado");
		daoProj.alterar(proj);
	}
	
	@Test
	public void excluirProjeto(){
		InterfaceDao<Projeto> daoProj = FactoryDao.createProjetoDao();
		Projeto proj = daoProj.getObjById(3);	
		daoProj.excluir(proj);
	}

}
