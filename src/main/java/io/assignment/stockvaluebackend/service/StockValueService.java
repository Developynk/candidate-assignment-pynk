package io.assignment.stockvaluebackend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import io.assignment.stockvaluebackend.entities.TblStockValue;
import io.assignment.stockvaluebackend.repositories.StockValueRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StockValueService {
	
	@Autowired private RestTemplate rt;
	@Autowired private StockValueRepository stockRepo;
	
	private Gson gson = new Gson();
	private String symbolParam = "aapl,fb,googl,msft";
	
	public JsonObject callStockValue() {
		
		String url = "https://cloud.iexapis.com/v1/stock/market/batch?symbols="+symbolParam+"&types=chart&range=1m&last=10&token=pk_7f5d7da3072b45e78db36bfe2062962c";
		LocalDateTime respDt = null;
//		StockResp stock = null;
		JsonObject jsonObj = null;
		
		try {
			log.info("call...");
			ResponseEntity<String> response = rt.getForEntity(url, String.class);
			respDt = LocalDateTime.now();
			log.info("response time: {}", respDt);
			log.info("resp status: {}, {}", response.getStatusCodeValue(), response.getStatusCode());
			log.info("resp body: {}", response.getBody());
			jsonObj = gson.fromJson(response.getBody(), JsonObject.class);

		}catch(HttpClientErrorException ex) {
			log.error("[HttpClientErrorException]");
			respDt = LocalDateTime.now();
			log.error("response time: {}", respDt);
			log.error("resp status: {}, {}", ex.getRawStatusCode(), ex.getStatusCode() );
			log.error("resp body: {}", ex.getResponseBodyAsString());

		}catch(HttpServerErrorException ex) {
			log.error("[HttpClientErrorException]");
			respDt = LocalDateTime.now();
			log.error("response time: {}", respDt);
			log.error("resp status: {}, {}", ex.getRawStatusCode(), ex.getStatusCode() );
			log.error("resp body: {}", ex.getResponseBodyAsString());

		}
		
		return jsonObj;
	}
	
	public void collectData() {
		
		JsonObject jsonObj = callStockValue();
		JsonObject symbolObj = null;
		List<TblStockValue> stockList = new ArrayList<>();
		
		if( !ObjectUtils.isEmpty(jsonObj) ) {
			String[] symbols = symbolParam.toUpperCase().split(",");
			for(String sym : symbols) {
				symbolObj = gson.fromJson(jsonObj.get(sym), JsonObject.class);
				log.info("{}: {}", sym, gson.toJson(symbolObj.get("chart")));
				stockList.addAll(gson.fromJson(symbolObj.get("chart"), new TypeToken<ArrayList<TblStockValue>>() {}.getType()));
			}
		}
		
		log.info("stock list.size: {}", stockList.size());
		stockRepo.saveAll(stockList);
	}

}
