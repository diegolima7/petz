package br.com.petz.dto;

import javax.validation.constraints.NotEmpty;
import br.com.petz.enums.SexoPet;
import br.com.petz.enums.TipoPet;
import io.swagger.annotations.ApiModelProperty;

public class PetDTO {

	private String nome;
	private TipoPet tipo;
	private SexoPet sexo;
	@ApiModelProperty(hidden = true)
	private int clienteId;

	public PetDTO() {
	}

	public PetDTO(String nome, TipoPet tipo, SexoPet sexo, int clienteId) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.sexo = sexo;
		this.clienteId = clienteId;
	}


	@NotEmpty(message = "Nome é Obrigatório")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPet getTipo() {
		return tipo;
	}

	public void setTipo(TipoPet tipo) {
		this.tipo = tipo;
	}

	public SexoPet getSexo() {
		return sexo;
	}

	public void setSexo(SexoPet sexo) {
		this.sexo = sexo;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

}
