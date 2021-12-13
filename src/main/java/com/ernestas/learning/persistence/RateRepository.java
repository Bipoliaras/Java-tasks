package com.ernestas.learning.persistence;

import com.ernestas.learning.domain.FxRate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<FxRate, Long> {
  Optional<FxRate> findFxRateByCurrency(String currency);
}
