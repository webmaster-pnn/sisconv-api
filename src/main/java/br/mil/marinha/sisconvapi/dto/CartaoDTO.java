package br.mil.marinha.sisconvapi.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.mil.marinha.sisconvapi.domain.Cartao;

public class CartaoDTO {

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String numero;

	@NotEmpty(message = "Preenchimento obrigatorio")
	private Date validade;

	private String status_cartao;

	public CartaoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartaoDTO(Cartao c) {
		super();
		this.id = c.getId();
		this.numero = c.getNumero();
		this.validade = c.getValidade();
		this.status_cartao = c.getStatusCartao().getDesc_status_cartao();
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getStatus_cartao() {
		return status_cartao;
	}

	public void setStatus_cartao(String status_cartao) {
		this.status_cartao = status_cartao;
	}

}
