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

import br.com.jsa.gestaoEscola.model.Turma;
import br.com.jsa.gestaoEscola.repository.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository repository;

	@PostMapping(value="/",  consumes=MediaType.APPLICATION_JSON)
	public Response salvar(@RequestBody Turma turma) {
		repository.save(turma);
		URI uri = URI.create("turma/"+turma.getId());
		return Response.created(uri).build();
	}
	
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON)
	public List<Turma> listarTurmas() {
		List<Turma> turmas = repository.findAll();
		return turmas;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Turma buscar(@PathVariable("id") Integer id) {
		Turma turma = repository.findOne(id);
		return turma;
	}
	
	@PutMapping(value="/",  consumes=MediaType.APPLICATION_JSON)
	public Response atualizar(@RequestBody Turma turma) {
		repository.save(turma);
		return Response.ok().build();
	}
	
	@DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Response deletar(@PathVariable("id") Integer id) {
		repository.delete(id);
		return Response.ok().build();
	}
}
