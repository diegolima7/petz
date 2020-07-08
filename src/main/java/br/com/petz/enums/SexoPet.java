package br.com.petz.enums;

public enum SexoPet {

	Macho("Mascho"), Femea("Femea");
	
	private String descricao;

	SexoPet(String sexo) {
		this.descricao = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

}
