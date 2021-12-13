package com.ernestas.learning.config;


import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public ServletRegistrationBean<CamelHttpTransportServlet> servletRegistrationBean() {
    ServletRegistrationBean<CamelHttpTransportServlet> servlet = new ServletRegistrationBean<>(
        new CamelHttpTransportServlet(),
        "/*");
    servlet.setName("CamelServlet");
    return servlet;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


}
