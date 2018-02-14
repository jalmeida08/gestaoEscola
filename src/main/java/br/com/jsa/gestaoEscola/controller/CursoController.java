package br.com.jsa.gestaoEscola.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jsa.gestaoEscola.model.Curso;
import br.com.jsa.gestaoEscola.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public Response salvar(@RequestBody Curso curso) {
		repository.save(curso);
		URI uri = URI.create("curso/"+curso.getId());
		return Response.created(uri).build();
	}
	
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON)
	public List<Curso> listarTodos() {
		List<Curso> cursos = repository.findAll();
		return cursos;
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON)
	public Curso buscar(@PathVariable("id") Integer id) {
		Curso curso = repository.findOne(id);
		return curso;
	}
	
	@PutMapping(value="/", consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public Response atualizar(@RequestBody Curso curso) {
		repository.save(curso);
		return Response.ok().build();
	}
	
	@DeleteMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
	public Response deletar(@PathVariable("id") Integer id) {
		this.repository.delete(id);
		return Response.ok().build();
		
	}
}
