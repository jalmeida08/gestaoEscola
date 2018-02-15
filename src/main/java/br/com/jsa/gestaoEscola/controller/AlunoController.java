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

import br.com.jsa.gestaoEscola.model.Aluno;
import br.com.jsa.gestaoEscola.repository.AlunoRepository;

@RestController
@RequestMapping("aluno/")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;

	@PostMapping(value="/", consumes=MediaType.APPLICATION_JSON)
	public Response salvar(@RequestBody Aluno aluno) {
		repository.save(aluno);
		URI uri = URI.create("aluno/"+aluno.getId());
		return Response.created(uri).build();
	}
	
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON)
	public List<Aluno> listarAlunos() {
		List<Aluno> alunos = repository.findAll();
		return alunos;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Aluno buscar(@PathVariable("id") Integer id) {
		Aluno aluno = repository.findOne(id);
		return aluno;
	}
	
	@PutMapping(value="/",  consumes=MediaType.APPLICATION_JSON)
	public Response atualizar(@RequestBody Aluno aluno) {
		repository.save(aluno);
		return Response.ok().build();
	}
	
	@DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Response deletar(@PathVariable("id") Integer id) {
		repository.delete(id);
		return Response.ok().build();
	}
}
