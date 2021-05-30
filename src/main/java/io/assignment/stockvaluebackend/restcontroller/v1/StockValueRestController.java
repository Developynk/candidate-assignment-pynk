package io.assignment.stockvaluebackend.restcontroller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockValueRestController {
	
	@GetMapping(path = "/")
	public String welcome() {
		
		return "Hello, I'm Stock API, welcome.";
	}
	
	@GetMapping(value = "/v1/start")
	public String start() {
		
		return "Collecting";
	}
	
	@GetMapping(value = "/v1/stop")
	public String stop() {
		
		return "stoped";
	}
	
	@GetMapping(value = "/v1/state")
	public String state() {
		return "state";
	}
	
	@GetMapping(path = "/v1/list")
	public String list() {
		return "list";
	}

}
