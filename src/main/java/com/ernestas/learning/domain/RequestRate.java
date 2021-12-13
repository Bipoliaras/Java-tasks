package com.ernestas.learning.domain;

public class RequestRate {

  public RequestRate() {
  }

  public RequestRate(String rateName) {
    this.rateName = rateName;
  }

  private String rateName;

  public String getRateName() {
    return rateName;
  }

  public void setRateName(String rateName) {
    this.rateName = rateName;
  }

}
