package br.com.jsa.gestaoEscola.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Aluno extends Pessoa{
	
	@ManyToMany(mappedBy="aluno")
	private List<Turma> turma = new ArrayList<Turma>();

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	
}
