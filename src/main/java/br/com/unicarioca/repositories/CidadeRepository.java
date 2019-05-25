package br.com.unicarioca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicarioca.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
