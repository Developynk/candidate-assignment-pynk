package io.assignment.stockvaluebackend.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import io.assignment.stockvaluebackend.StockValueBackendApplication;
import io.assignment.stockvaluebackend.config.H2JpaConfig;
import io.assignment.stockvaluebackend.entities.TblStockValue;
import io.assignment.stockvaluebackend.repositories.StockValueRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
		StockValueBackendApplication.class,
		H2JpaConfig.class})
@ActiveProfiles("test")
public class StockValueServiceTest {
	
	@Autowired(required=true) 
	private StockValueRepository stockRepo;
	
	@Test
	public void callStockValueSuccess() {
		String url = "https://cloud.iexapis.com/v1/stock/market/batch?symbols=aapl,fb,googl,msft&types=chart&range=1m&last=10&token=pk_7f5d7da3072b45e78db36bfe2062962c";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		
		 //Verify request succeed
	    Assert.assertEquals(200, response.getStatusCodeValue());
	    Assert.assertEquals(true, response.getBody().contains("chart"));
	}
	
	@Test
	public void StockValueRepository_whenSaveAndRetreiveEntity_thenOK() {
		
		String json = "{\"close\":249.68,\"high\":252.08,\"low\":249.56,\"open\":250.995,\"symbol\":\"PYNK\",\"volume\":18274942,\"id\":\"HISTORICAL_PRICES\",\"key\":\"PYNK\",\"subkey\":\"\",\"date\":\"2021-05-28\",\"updated\":1622250979,\"changeOverTime\":0,\"marketChangeOverTime\":0,\"uOpen\":250.995,\"uClose\":249.68,\"uHigh\":252.08,\"uLow\":249.56,\"uVolume\":18274942,\"fOpen\":250.995,\"fClose\":249.68,\"fHigh\":252.08,\"fLow\":249.56,\"fVolume\":18274942,\"label\":\"May 28, 21\",\"change\":0,\"changePercent\":0}";
		Gson gson = new Gson();
		log.info("json: {}", json);
		TblStockValue stock = gson.fromJson(json, TblStockValue.class);
		log.info("stock: {}", gson.toJson(stock));
		stock = stockRepo.save(stock);
		
		List<TblStockValue> stockList = stockRepo.findDistinctBySymbol(stock.getSymbol());
		
		assertNotNull(stockList);
		
	}

}
