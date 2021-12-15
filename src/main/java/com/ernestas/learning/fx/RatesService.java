package com.ernestas.learning.fx;

import com.ernestas.learning.domain.FxRate;

public interface RatesService {
  FxRate getRateByName(String currencyName);
}
