package pe.org.alerta.usuario.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.org.alerta.usuario.persist.Usuario;
import pe.org.alerta.usuario.service.RegistroService;

@RestController
public class RegistroController {
	private static Logger log = LoggerFactory.getLogger(RegistroController.class);
	
	@Autowired
	private RegistroService registroService;
	
	@RequestMapping(value = "/registro")
	@ResponseBody
	public Map<String, Object> registro(Usuario usuario) throws Exception {
		return registroService.registraUsuario(usuario);
	}
	
	@RequestMapping(value = "/lista")
	@ResponseBody
	public Iterable<Usuario> lista(Usuario usuario) throws Exception {
		return registroService.listaUsuario(usuario);
	}
}
