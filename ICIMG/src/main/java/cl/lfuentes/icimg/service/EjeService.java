package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.EjeRepository;
import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.validacion.ejeNoEncontradoException;

@Service
public class EjeService {

	@Autowired
	private EjeRepository ejeRepo;
	

	public Eje crear(Eje eje) {

		Eje ejeCreado = ejeRepo.saveAndFlush(eje);
		return ejeCreado;
	}

	public List<Eje> listar() {

		List<Eje> ejes = ejeRepo.findAll();
		return ejes;
	}

	public Optional<Eje> buscar(String codigo) {
		
		return Optional.ofNullable(ejeRepo.findByCodigo(codigo).orElseThrow(() -> new ejeNoEncontradoException(codigo)));
	}

}
