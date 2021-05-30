package io.assignment.stockvaluebackend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.assignment.stockvaluebackend.config.H2JpaConfig;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(classes = {StockValueBackendApplication.class, H2JpaConfig.class})
public class StockValueBackendApplicationTests {

	@Test
	public void contextLoads() {
	}

}
