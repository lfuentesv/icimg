package cl.lfuentes.icimg;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.lfuentes.icimg.dao.EjeRepository;
import cl.lfuentes.icimg.entityTo.Eje;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParametrosApiTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private EjeRepository ejeRepo;
	
	@Test
	void crearEje ()throws Exception{
		Eje eje = new Eje();
		eje.setCodigo("E");
		eje.setNombre("Eje E");
		
		mockMvc.perform(post("/parametros/eje")
				   .contentType("application/json")
				   .content(objectMapper.writeValueAsString(eje)))
				   .andExpect(status().isCreated());
	}
}
