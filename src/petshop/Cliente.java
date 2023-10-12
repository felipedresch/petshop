package petshop;

import java.util.ArrayList;

public class Cliente {
//fazer arraylist de pets
	private String nomeDono;
	private String telefone;
	private String cpf;
	private String endereco;
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public Cliente(String nomeDono, String telefone, String cpf, String endereco) {
		super();
		this.nomeDono = nomeDono;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
		
}