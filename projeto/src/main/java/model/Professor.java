package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Professor implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;

	public Professor() {
	}

	public Professor(Integer codProfessor, String nome) {
		this.codigo = codProfessor;
		this.nome = nome;
	
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codProfessor) {
		this.codigo = codProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}



