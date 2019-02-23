package br.com.unicarioca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unicarioca.domain.Categoria;
import br.com.unicarioca.repositories.CategoriaRepository;
import br.com.unicarioca.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto Não encontrado! Id: " + id + ", Tipo " + Categoria.class.getName());
		}
		return obj;
	}
}
