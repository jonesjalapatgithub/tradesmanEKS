package com.jonesjalapat.blog.tradesman.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tradesman")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TradesmanEntity extends BaseDataEntityWithAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tradesman_sequence")
  @SequenceGenerator(
      name = "tradesman_sequence",
      sequenceName = "tradesman_sequence",
      allocationSize = 1,
      initialValue = 1)
  private Long id;

  @JsonManagedReference
  @ManyToOne(targetEntity = TradeEntity.class)
  @JoinColumn(name = "trade_id", nullable = false)
  @NotNull(message = "Trade Id is required")
  private TradeEntity tradeEntity;

  @JsonManagedReference
  @ManyToOne(targetEntity = PersonEntity.class)
  @JoinColumn(name = "person_id", nullable = false)
  @NotNull(message = "Person Id is required")
  private PersonEntity personEntity;
}
