package pe.org.alerta.usuario.bean;

public class MessageBean {
	private int tipo;
	private String text;
	private int codigo;

	public MessageBean() {
		// TODO Auto-generated constructor stub
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
