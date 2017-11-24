package pe.org.alerta.usuario.factory;

import org.springframework.stereotype.Service;

import pe.org.alerta.usuario.bean.MessageBean;
import pe.org.alerta.usuario.bean.MessageError;
import pe.org.alerta.usuario.bean.MessageSuccess;
import pe.org.alerta.usuario.util.Constante;



@Service
public class MessageFactoryImpl implements MessageFactory{

	@Override
	public MessageBean buildMessage(int type, String text) {
		MessageBean message = new MessageBean();
		if(type == Constante.MSG_SUCCESS){
			message = new MessageSuccess(text);
		}
		if(type == Constante.MSG_ERROR){
			message = new MessageError(text);
		}
		return message;
	}





}
