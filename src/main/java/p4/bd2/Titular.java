package p4.bd2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Titular {
	@Id
	private String cpf;
	@Column(name = "nomeTitular")
	private String nome;
	@Column(name = "emailTitular")
	private String email;
	@Column(name = "enderecoTitular")
	private String endereco;
	@Column(name = "telefoneTitular")
	private String telefone;

	public Titular() {

	}
	
	public Titular(String cpf, String nome, String email, String endereco, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Titular: \n \t cpf: " + cpf + "\n \t nome: " + nome + "\n \t email: " + email + "\n \t endereco: " + endereco + "\n \t telefone: "
				+ telefone;
	}
	
}
