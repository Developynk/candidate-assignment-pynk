package io.assignment.stockvaluebackend.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import io.assignment.stockvaluebackend.component.RestTemplateInterceptor;

@Configuration
public class RestTemplateClientConfig {
	
	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
		List<ClientHttpRequestInterceptor> interceptor = restTemplate.getInterceptors();
		if(CollectionUtils.isEmpty(interceptor)) {
			interceptor = new ArrayList<>();
		}
		interceptor.add(new RestTemplateInterceptor());
		restTemplate.setInterceptors(interceptor);
		
		return restTemplate;
	}

}
