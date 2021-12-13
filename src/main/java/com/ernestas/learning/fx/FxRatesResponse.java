package com.ernestas.learning.fx;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

public class FxRatesResponse {

  private boolean success;

  @JsonProperty("base")
  private String baseCurrency;

  private Date date;

  @JsonProperty("rates")
  private Map<String, BigDecimal> fxRates;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getBaseCurrency() {
    return baseCurrency;
  }

  public void setBaseCurrency(String baseCurrency) {
    this.baseCurrency = baseCurrency;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Map<String, BigDecimal> getFxRates() {
    return fxRates;
  }

  public void setFxRates(Map<String, BigDecimal> fxRates) {
    this.fxRates = fxRates;
  }
}
