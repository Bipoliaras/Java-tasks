package com.ernestas.learning.fx;

import com.ernestas.learning.persistence.RateRepository;
import com.ernestas.learning.domain.FxRate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FxRatesService {

  public FxRatesService(RateRepository rateRepository,
      FxRatesGateway fxRatesGateway) {
    this.rateRepository = rateRepository;
    this.fxRatesGateway = fxRatesGateway;
  }

  private final RateRepository rateRepository;

  private final FxRatesGateway fxRatesGateway;

  public FxRate getRateByName(String currencyName) {
    var fxRate = rateRepository.findFxRateByCurrency(currencyName);
    if(fxRate.isPresent()) {
      return fxRate.get();
    } else {
      var rate = getAllRates().stream()
          .filter(exchangeRate -> exchangeRate.getCurrency().equals(currencyName))
          .findFirst()
          .orElseThrow(() -> new RuntimeException("No rate found"));
      return rateRepository.saveAndFlush(rate);
    }
  }

  public List<FxRate> getAllRates() {
    var rates = fxRatesGateway.getFxRates();
    return rates.entrySet()
        .stream()
        .map(entry -> new FxRate(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
  }


}
