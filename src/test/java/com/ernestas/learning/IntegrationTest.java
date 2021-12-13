package com.ernestas.learning;

import static org.assertj.core.api.Assertions.assertThat;

import com.ernestas.learning.domain.FxRate;
import com.ernestas.learning.domain.RequestRate;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;

class IntegrationTest extends IntegrationTestBase {

  @Test
  void givenRequestRate_whenGetUSDRate_getsCorrectRate() {
    RequestRate rate = new RequestRate("USD");
    HttpEntity<RequestRate> request = new HttpEntity<>(rate, getHeaders());
    FxRate fxRate = testRestTemplate.postForObject(apiUrl + "/rates", request, FxRate.class);
    assertThat(fxRate.getCurrency()).isEqualTo("USD");
  }

}
