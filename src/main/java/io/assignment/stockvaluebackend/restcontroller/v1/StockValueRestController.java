package io.assignment.stockvaluebackend.restcontroller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.assignment.stockvaluebackend.service.StockValueService;

@RestController
public class StockValueRestController {
	
	@Autowired
	private StockValueService service;
	
	@GetMapping(path = "/")
	public String welcome() {
		
		return "Hello, I'm Stock API, welcome.";
	}
	
	@GetMapping(value = "/v1/start")
	public String start() {
//		service.start();
		service.run();
		return "Collector started";
	}
	
	@GetMapping(value = "/v1/stop")
	public String stop() {
		service.stop();
		return "Collector stoped";
	}
	
	@GetMapping(value = "/v1/state")
	public String state() {
		return service.state();
	}
	
	@GetMapping(path = {"/v1/list", "/v1/list/{symbol}"})
	public String list(@PathVariable(required = false) String symbol) {
		if(null != symbol) {
			return service.list(symbol);
		}else {
			return "list";
		}
	}

}
