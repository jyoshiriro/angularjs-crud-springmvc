package br.com.trescon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.trescon.domains.Bairro;
import br.com.trescon.domains.Cidade;

public interface BairroRepository extends CrudRepository<Bairro, Long>{

	@Query("from Bairro where cidade.id=?1")
	public Iterable<Bairro> findByCidade(Long idcidade);

}
