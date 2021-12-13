package com.ernestas.learning.api;

import com.ernestas.learning.domain.FxRate;
import com.ernestas.learning.domain.RequestRate;
import com.ernestas.learning.fx.FxRatesService;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FxRateServiceRoute extends RouteBuilder {

  public FxRateServiceRoute(FxRatesService fxRatesService) {
    this.fxRatesService = fxRatesService;
  }

  private final FxRatesService fxRatesService;

  @Override
  public void configure() {

    from("direct:fxService")
        .routeId("direct-route")
        .tracing()
        .process(
            exchange -> {
              RequestRate requestRate = exchange.getIn().getBody(RequestRate.class);
              FxRate rate = fxRatesService.getRateByName(requestRate.getRateName());
              exchange.getIn().setBody(rate);
            }
        )
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
