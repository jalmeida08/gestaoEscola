package br.com.jsa.gestaoEscola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jsa.gestaoEscola.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
