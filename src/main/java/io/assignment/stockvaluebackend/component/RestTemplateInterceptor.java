package io.assignment.stockvaluebackend.component;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		
		logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        
        return response;
	} 

	private void logRequest(HttpRequest request, byte[] body) throws IOException {
		log.info("== Request =============================================================================");
		log.info("URI         : {}", request.getURI());
		log.info("Method      : {}", request.getMethod());
		log.info("Headers     : {}", request.getHeaders());
		log.info("Request body: {}", new String(body, "UTF-8"));
	}

	private void logResponse(ClientHttpResponse response) throws IOException {
		log.info("== Response ============================================================================");
		log.info("Status code  : {}", response.getRawStatusCode());
		log.info("Status text  : {}", response.getStatusCode());
		log.info("Headers      : {}", response.getHeaders());
		log.info("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		log.info("== End =================================================================================");
	}

}
