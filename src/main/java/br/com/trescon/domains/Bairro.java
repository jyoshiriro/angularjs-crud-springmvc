package br.com.trescon.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Entity
public class Bairro {

	private final transient Log log = LogFactory.getLog(this.getClass());
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	@OneToOne
	private Cidade cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade estado) {
		this.cidade = estado;
	}
}
