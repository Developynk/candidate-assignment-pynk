package io.assignment.stockvaluebackend.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class StockValueServiceTest {
	
	@Test
	public void callStockValueSuccess() {
		String url = "https://cloud.iexapis.com/v1/stock/market/batch?symbols=aapl,fb,googl,msft&types=chart&range=1m&last=10&token=pk_7f5d7da3072b45e78db36bfe2062962c";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		
		 //Verify request succeed
	    Assert.assertEquals(200, response.getStatusCodeValue());
	    Assert.assertEquals(true, response.getBody().contains("chart"));
	}

}
