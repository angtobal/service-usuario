package pe.org.alerta.usuario.bean;

import pe.org.alerta.usuario.util.Constante;

public class MessageError extends MessageBean{
	public MessageError(String text) {
		super();
		super.setText(text);
		super.setCodigo(Constante.MSG_ERROR);
	}
}
