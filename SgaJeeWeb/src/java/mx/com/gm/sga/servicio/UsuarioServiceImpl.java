package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.eis.UsuarioDao;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService {
	
	@EJB
	private UsuarioDao usuarioDao;

        @Override
	public List<Usuario> listarUsuarios() {
		return usuarioDao.findAllUsuarios();
	}

        @Override
	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		return usuarioDao.findUsuarioById(usuario);
	}

        @Override
	public void registrarUsuario(Usuario usuario) {
		usuarioDao.insertUsuario(usuario);
	}

        @Override
	public void modificarUsuario(Usuario usuario) {
		usuarioDao.updateUsuario(usuario);
	}

        @Override
	public void eliminarUsuario(Usuario usuario) {
		usuarioDao.deleteUsuario(usuario);
	}
}
