package com.atividadedw.dw.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Fechadura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
	private Integer senhaAutenticacao;
   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSenhaAutenticacao() {
		return senhaAutenticacao;
	}

	public void setSenhaAutenticacao(Integer senhaAutenticacao) {
		this.senhaAutenticacao = senhaAutenticacao;
	}
}
