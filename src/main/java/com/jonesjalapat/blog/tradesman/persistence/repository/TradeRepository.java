package com.jonesjalapat.blog.tradesman.persistence.repository;

import com.jonesjalapat.blog.tradesman.persistence.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {
  TradeEntity findByType(String type);
}
