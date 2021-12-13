package com.ernestas.learning.api;

import com.ernestas.learning.domain.RequestRate;
import javax.ws.rs.core.MediaType;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

  @Override
  public void configure() {
    rest("/api/")
        .id("rest-api-route")
        .post("/rates")
        .produces(MediaType.APPLICATION_JSON)
        .consumes(MediaType.APPLICATION_JSON)
        .bindingMode(RestBindingMode.auto)
        .type(RequestRate.class)
        .enableCORS(true)
        .to("direct:fxService");
  }
}
