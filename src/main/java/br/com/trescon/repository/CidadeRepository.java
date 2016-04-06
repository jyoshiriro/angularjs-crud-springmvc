package br.com.trescon.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.trescon.domains.Cidade;
import br.com.trescon.domains.Estado;

public interface CidadeRepository extends CrudRepository<Cidade, Long>{

	@Query("from Cidade where estado.id=?1")
	public Iterable<Cidade> findByEstado(Long idestado);

}
