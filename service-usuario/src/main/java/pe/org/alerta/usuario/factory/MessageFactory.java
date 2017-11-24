package pe.org.alerta.usuario.factory;

import pe.org.alerta.usuario.bean.MessageBean;

public interface MessageFactory {
	public MessageBean buildMessage(int type, String text);
}
