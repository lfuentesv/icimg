package cl.lfuentes.icimg;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.lfuentes.icimg.api.ParametrosApi;

@SpringBootTest
class IcimgApplicationTests {

	@Autowired
	ParametrosApi parametrosController;
	
	@Test
	void contextLoads() {
		assertThat(parametrosController).isNotNull();
	}

}
