package projeto.business;

import projeto.dao.UsuarioDao;
import projeto.entity.Login;
import projeto.entity.Usuario;
import projeto.entity.UsuarioLogado;
import projeto.util.Criptografia;

public class UsuarioBusiness {
	
	public UsuarioLogado login (Login loginWeb){
	
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuarioBanco;
		
		// Puxa usuario do banco via username 
		try {
			usuarioBanco = uDao.getObjByUsername(loginWeb.getUsernameLogin());
		}
		catch (Exception ex) {
			usuarioBanco = null;
		}

		if(usuarioBanco != null){
			// criptografa senha informado pelo usu�rio no login
			String senhaCrip = Criptografia.criptografar(loginWeb.getSenhaUsername());
			if(senhaCrip.equals(usuarioBanco.getSenhaUsuario())){
				// retorna id do usuario encontrado
				System.out.println("Usuario logado: "+ usuarioBanco.getNomeUsuario());
				UsuarioLogadoBusiness LogBusiness = new UsuarioLogadoBusiness();
				UsuarioLogado LoggedUser = LogBusiness.create(usuarioBanco);
				return LoggedUser;
				}
		}
		return null;		
	}
	
	
}