package br.com.jsa.gestaoEscola.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.gestaoEscola.model.Professor;
import br.com.jsa.gestaoEscola.repository.ProfessorRepository;

@RestController
@RequestMapping("professor/")
public class ProfessorController {

	@Autowired
	private ProfessorRepository repository;

	@PostMapping(value="/", consumes=MediaType.APPLICATION_JSON)
	public Response salvar(@RequestBody Professor professor) {
		repository.save(professor);
		URI uri = URI.create("professor/"+professor.getId());
		return Response.created(uri).build();
	}
	
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON)
	public List<Professor> listarProfessores() {
		List<Professor> professores = repository.findAll();
		return professores;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Professor buscar(@PathVariable("id") Integer id) {
		Professor professor = repository.findOne(id);
		return professor;
	}
	
	@PutMapping(value="/",  consumes=MediaType.APPLICATION_JSON)
	public Response atualizar(@RequestBody Professor professor) {
		repository.save(professor);
		return Response.ok().build();
	}
	
	@DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Response deletar(@PathVariable("id") Integer id) {
		repository.delete(id);
		return Response.ok().build();
	}
}
