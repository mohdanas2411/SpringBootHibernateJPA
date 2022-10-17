package com.example.SpringBootFirst.employeeJPA;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateModificationInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

      //  request.getHeaders().add("helllo","hello");
        ClientHttpResponse response = execution.execute(request,body);
        response.getHeaders().add("hello","bye");
        response.getHeaders().setDate(567890);
        return response;
    }
}
