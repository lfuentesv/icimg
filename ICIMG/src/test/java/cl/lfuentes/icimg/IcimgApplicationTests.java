package cl.lfuentes.icimg;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.lfuentes.icimg.api.EjesApi;

@SpringBootTest
class IcimgApplicationTests {

	@Autowired
	EjesApi parametrosController;
	
	@Test
	void contextLoads() {
		assertThat(parametrosController).isNotNull();
	}

}
