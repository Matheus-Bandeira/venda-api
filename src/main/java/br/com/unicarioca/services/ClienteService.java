package br.com.unicarioca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicarioca.domain.Cliente;
import br.com.unicarioca.repositories.ClienteRepository;
import br.com.unicarioca.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + ", Tipo " + Cliente.class.getName());
		}
		return obj;
	}
}
