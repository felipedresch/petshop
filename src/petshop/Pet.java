package petshop;

import java.util.ArrayList;

public class Pet{
	private String nomePet;
	private String especie;
	private String raca;
	private String idade;
	private String cpfDono;
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	
	public Pet(String nomePet, String especie, String raca, String idade, String cpfDono) {
		this.nomePet = nomePet;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.cpfDono = cpfDono;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCPFDono() {
		return cpfDono;
	}

	public void setCPFDono(String cPFDono) {
		cpfDono = cPFDono;
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}
		
}