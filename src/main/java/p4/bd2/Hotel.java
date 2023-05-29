package p4.bd2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hotel {
	@Id
	private String cnpj;
	@Column(name = "prediosHotel")
	private int predios;
	@Column(name = "telefoneHotel")
	private String telefone;

	public Hotel() {

	}

	public Hotel(String cnpj, int predios, String telefone) {
		super();
		this.cnpj = cnpj;
		this.predios = predios;
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getPredios() {
		return predios;
	}

	public void setPredios(int predios) {
		this.predios = predios;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Hotel: \n \t cnpj: " + cnpj + "\n \t predios: " + predios + "\n \t telefone: " + telefone;
	}

	
	
}
