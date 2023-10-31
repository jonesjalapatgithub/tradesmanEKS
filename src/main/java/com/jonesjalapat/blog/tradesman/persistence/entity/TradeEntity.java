package com.jonesjalapat.blog.tradesman.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "trade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TradeEntity extends BaseDataEntityWithAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_sequence")
  @SequenceGenerator(
      name = "trade_sequence",
      sequenceName = "trade_sequence",
      allocationSize = 1,
      initialValue = 1)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "type is required")
  private String type;

  @JsonBackReference
  @OneToMany(mappedBy = "tradeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<TradesmanEntity> tradesmanEntities = new ArrayList<>();

  @Column(nullable = false)
  @NotBlank(message = "Description is required")
  private String description;
}
