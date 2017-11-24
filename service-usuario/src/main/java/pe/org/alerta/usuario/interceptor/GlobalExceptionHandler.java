package pe.org.alerta.usuario.interceptor;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Throwables;
import com.mongodb.MongoSocketOpenException;
import com.mongodb.MongoTimeoutException;

import pe.org.alerta.usuario.factory.MessageFactory;
import pe.org.alerta.usuario.util.Constante;

@ControllerAdvice
public class GlobalExceptionHandler
{
  protected final Log log = LogFactory.getLog(getClass());
  
  @Autowired
	MessageFactory messageFactory;
  
  
  @ExceptionHandler({SQLException.class})
  @ResponseBody
  public Map<String, Object> sqlExceptionHandler(Exception ex) {
	   ex.printStackTrace();
	   Map<String, Object> result = new HashMap<String, Object>();
	   if (Constante.CLOSE_CONNECTION_MESSAGE.equals(Throwables.getRootCause(ex).getMessage()))
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Constante.CLOSE_CONNECTION_MESSAGE_NEW));
	   else
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Throwables.getRootCause(ex).getMessage()));
	   
	   return result;
  }
  
  @ExceptionHandler({NumberFormatException.class})
  @ResponseBody
  public Map<String, Object> numberFormatExceptionHandler(Exception ex) {
	   ex.printStackTrace();
	   Map<String, Object> result = new HashMap<String, Object>();
	   if (Throwables.getRootCause(ex).getMessage().indexOf(Constante.FORMAT_EXCEPTION_MESSAGE) >= 0)
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Constante.FORMAT_EXCEPTION_MESSAGE_NEW));

	   else
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Throwables.getRootCause(ex).getMessage()));
	   
	   return result;
  }
  @ExceptionHandler({MongoSocketOpenException.class})
  @ResponseBody
  public Map<String, Object> mongoSocketExceptionHandler(Exception ex) {
	   ex.printStackTrace();
	   Map<String, Object> result = new HashMap<String, Object>();
	   if (Throwables.getRootCause(ex).getMessage().indexOf(Constante.MONGO_SOCKET_EXCEPTION_MESSAGE) >= 0)
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Constante.MONGO_SOCKET_EXCEPTION_MESSAGE_NEW));
	   else
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Throwables.getRootCause(ex).getMessage()));
	   
	   return result;
  }
  @ExceptionHandler({MongoTimeoutException.class})
  @ResponseBody
  public Map<String, Object> mongoTimeoutExceptionHandler(Exception ex) {
	   ex.printStackTrace();
	   Map<String, Object> result = new HashMap<String, Object>();
	   if (Throwables.getRootCause(ex).getMessage().indexOf(Constante.MONGO_TIMEOUT_EXCEPTION_MESSAGE) >= 0)
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Constante.MONGO_TIMEOUT_EXCEPTION_MESSAGE_NEW));
	   else
		   result.put("msg", messageFactory.buildMessage(Constante.MSG_ERROR, Throwables.getRootCause(ex).getMessage()));
	   
	   return result;
  }
}
