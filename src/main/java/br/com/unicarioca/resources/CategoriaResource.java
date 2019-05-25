package br.com.unicarioca.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicarioca.domain.Categoria;
import br.com.unicarioca.repositories.CategoriaRepository;
import br.com.unicarioca.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
@CrossOrigin
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@Autowired
	private CategoriaRepository categoriaRepository;


	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listarTodos() {
		return this.categoriaRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
