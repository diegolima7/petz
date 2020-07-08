package br.com.petz.enums;

public enum SexoCliente {

	Masculino("Masculino"), Feminino("Feminino");

	private String descricao;

	SexoCliente(String sexo) {
		this.descricao = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

}
