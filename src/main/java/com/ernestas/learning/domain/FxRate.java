package com.ernestas.learning.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class FxRate {

  public FxRate() {}

  public FxRate(String currency, BigDecimal rate) {
    this.currency = currency;
    this.rate = rate;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  @NotNull
  private String currency;

  @Column
  @NotNull
  private BigDecimal rate;

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  @Override
  public String toString() {
    return "[ " + "Currency " + currency + ", rate " + rate + " ]";
  }
}
