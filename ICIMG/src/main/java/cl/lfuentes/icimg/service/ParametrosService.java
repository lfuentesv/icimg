package cl.lfuentes.icimg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.lfuentes.icimg.dao.EjeRepository;
import cl.lfuentes.icimg.entityTo.Eje;

@Service
public class ParametrosService {
	
	@Autowired
	private EjeRepository ejeRepo;
	
	public Eje crear (Eje eje) {
		
		Eje ejeCreado = ejeRepo.saveAndFlush(eje);
		
		return ejeCreado; 
	}
	
	
}
