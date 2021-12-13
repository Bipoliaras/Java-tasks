package com.ernestas.learning.fx;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FxRatesGateway {

  public FxRatesGateway(RestTemplate restTemplate, @Value("${fx.rates.url}") String fxRatesUrl) {
    this.restTemplate = restTemplate;
    this.fxRatesUrl = fxRatesUrl;
  }

  private static final Logger logger = LoggerFactory.getLogger(FxRatesGateway.class);

  private final RestTemplate restTemplate;

  private final String fxRatesUrl;

  public Map<String, BigDecimal> getFxRates() {
    var response = restTemplate.getForObject(fxRatesUrl, FxRatesResponse.class);
    logger.info("Received response {}", response);
    return Optional.ofNullable(response)
        .orElseThrow(() -> new RuntimeException("Response is null"))
        .getFxRates();
  }

}
