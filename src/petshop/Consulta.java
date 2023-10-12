package petshop;

public class Consulta{
	private String data;
	private String hora;
	private String servico;
	private String preco;
	private String cpfConsulta;
	private String nomeClienteConsulta;
	
	public Consulta(String data, String hora, String servico, String preco, String cpfConsulta, String nomeClienteConsulta) {
		this.data = data;
		this.hora = hora;
		this.servico = servico;
		this.preco = preco;
		this.cpfConsulta = cpfConsulta;
		this.nomeClienteConsulta = nomeClienteConsulta;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getCpfConsulta() {
		return cpfConsulta;
	}

	public void setCpfConsulta(String cpfConsulta) {
		this.cpfConsulta = cpfConsulta;
	}

	public String getNomeClienteConsulta() {
		return nomeClienteConsulta;
	}

	public void setNomeClienteConsulta(String nomeClienteConsulta) {
		this.nomeClienteConsulta = nomeClienteConsulta;
	}
}
