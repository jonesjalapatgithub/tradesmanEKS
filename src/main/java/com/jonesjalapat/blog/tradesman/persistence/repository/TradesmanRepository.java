package com.jonesjalapat.blog.tradesman.persistence.repository;

import com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse;
import com.jonesjalapat.blog.tradesman.persistence.entity.TradesmanEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesmanRepository extends JpaRepository<TradesmanEntity, Long> {
  @Query(
      "select new com.jonesjalapat.blog.tradesman.persistence.dto.TradeResponse(te.type, pe.name, pe.country, pe.state, pe.city, pe.contact, pe.active) "
          + " from TradeEntity te "
          + " left join TradesmanEntity tde on tde.tradeEntity.id = te.id "
          + " left join PersonEntity pe on tde.personEntity.id  = pe.id"
          + " where te.type = :trade")
  List<TradeResponse> findTradesmanByTrade(String trade);
}
