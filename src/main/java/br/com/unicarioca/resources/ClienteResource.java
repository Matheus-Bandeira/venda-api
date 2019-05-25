package br.com.unicarioca.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicarioca.domain.Cliente;
import br.com.unicarioca.repositories.ClienteRepository;
import br.com.unicarioca.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@Autowired
	ClienteRepository clienteRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listarTodos() {
		return this.clienteRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
