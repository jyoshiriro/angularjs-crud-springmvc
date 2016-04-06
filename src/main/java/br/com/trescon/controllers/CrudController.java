package br.com.trescon.controllers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.trescon.domains.Bairro;
import br.com.trescon.domains.Cidade;
import br.com.trescon.domains.Estado;
import br.com.trescon.repository.BairroRepository;
import br.com.trescon.repository.CidadeRepository;
import br.com.trescon.repository.EstadoRepository;

@RestController
public class CrudController {

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	BairroRepository bairroRepository;
	
	@RequestMapping(value="/estados")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<Estado> estados() {
		return estadoRepository.findAll();
	}
	
	@RequestMapping(value="/filtrarCidades/{idestado}")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<Cidade> filtrarCidades(@PathVariable("idestado") Long idestado) {
		return cidadeRepository.findByEstado(idestado);
	}
	
	
	@RequestMapping(value="/filtrarBairros/{idcidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<Bairro> filtrarBairros(@PathVariable("idcidade") Long idcidade) {
		return bairroRepository.findByCidade(idcidade);
	}
	
}
