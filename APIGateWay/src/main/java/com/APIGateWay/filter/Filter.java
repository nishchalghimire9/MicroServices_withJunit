package com.APIGateWay.filter;

import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



import reactor.core.publisher.Mono;
@Component
public class Filter implements  GlobalFilter{
// this global method and it is implementing,
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("filter is execute");
	
		ServerHttpRequest request = exchange.getRequest();  // it is used to capture complete request.
		HttpHeaders headers = request.getHeaders();
		Set<String> headersName =headers.keySet();
		for(String headerName : headersName) {
			System.out.println("header name= " + headerName );
			System.out.println(headers.getValuesAsList(headerName));
		}
		
		
		request.getBody();
		return chain.filter(exchange);
	}

}

// through the filter we can access complete request coming from the browser.
