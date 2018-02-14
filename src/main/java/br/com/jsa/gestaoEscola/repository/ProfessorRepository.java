package br.com.jsa.gestaoEscola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.gestaoEscola.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
