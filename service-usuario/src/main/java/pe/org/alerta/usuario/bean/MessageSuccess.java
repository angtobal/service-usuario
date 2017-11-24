package pe.org.alerta.usuario.bean;

import pe.org.alerta.usuario.util.Constante;

public class MessageSuccess extends MessageBean{
	public MessageSuccess(String text) {
		super.setText(text);
		super.setTipo(Constante.MSG_SUCCESS);
	}
}
