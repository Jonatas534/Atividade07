package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	private String sigla;
	private String cargaHoraria;

	public Disciplina() {
	}

	public Disciplina(Integer codDisciplina, String nome, String sigla, String cargaHoraria) {
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codDisciplina) {
		this.codigo = codDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
