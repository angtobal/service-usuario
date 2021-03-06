package pe.org.alerta.usuario.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import pe.org.alerta.usuario.factory.MessageFactory;
import pe.org.alerta.usuario.persist.Usuario;
import pe.org.alerta.usuario.persist.UsuarioRepository;
import pe.org.alerta.usuario.util.Constante;

@Service
public class RegistroService {

	@Autowired
	UsuarioRepository repository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MessageFactory messageFactory;

	public Map<String, Object> registraUsuario(Usuario usuario) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		mongoTemplate.save(usuario);

		result.put("msg", messageFactory.buildMessage(Constante.MSG_SUCCESS, "Se registro corretamente."));

		return result;
	}

	public Iterable<Usuario> listaUsuario(Usuario usuarioBean) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		Iterable<Usuario> lista = repository.findAll();
		result.put("data", lista);

		return lista;
	}
}
