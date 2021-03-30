package cl.lfuentes.icimg.service;

import java.util.List;
import java.util.Optional;

import cl.lfuentes.icimg.validacion.DeleteException;
import cl.lfuentes.icimg.validacion.RecursoExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.EjeRepository;
import cl.lfuentes.icimg.entityTo.Eje;
import cl.lfuentes.icimg.validacion.ejeNoEncontradoException;

import javax.transaction.Transactional;

@Service
public class EjeService {

	@Autowired
	private EjeRepository ejeRepo;
	

	public Eje crear(Eje eje) {

		/**Validamos que el eje no exista*/
		Optional<Eje> ejeExistente = ejeRepo.findByCodigo(eje.getCodigo());
		if (ejeExistente.isPresent()) throw new RecursoExistenteException("Eje",eje.getCodigo());

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

    public Eje actualizar(String codigo, Eje eje) {
		/**Validamos que el eje exista*/
		Optional<Eje> ejeExistente = ejeRepo.findByCodigo(eje.getCodigo());
		if (!ejeExistente.isPresent()) throw new ejeNoEncontradoException(codigo);

		Eje  ejePO = new Eje ( codigo, eje.getNombre());

		return ejeRepo.saveAndFlush(ejePO);
    }

    @Transactional
	public void eliminar(String codigo) {
		Optional<Eje> ejeExistente = ejeRepo.findByCodigo(codigo);
		if (!ejeExistente.isPresent()) throw new ejeNoEncontradoException(codigo);
		try {
			ejeRepo.deleteByCodigo(codigo);
			ejeRepo.flush();
		}catch (DataIntegrityViolationException e){
			throw new DeleteException("Error eliminando eje, revise que no este asociado con otro recurso");
		}
	}
}
