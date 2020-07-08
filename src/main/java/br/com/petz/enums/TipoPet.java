package br.com.petz.enums;

public enum TipoPet {

	Cachorro("Cachorro"), Gato("Gato");

	private String descricao;

	TipoPet(String tipo) {
		this.descricao = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

}
