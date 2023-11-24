package com.jonesjalapat.blog.tradesman.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity extends BaseDataEntityWithAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
  @SequenceGenerator(
      name = "person_sequence",
      sequenceName = "person_sequence",
      allocationSize = 1,
      initialValue = 1)
  private Long id;

  @Column(nullable = false)
  @NotBlank(message = "Name is required")
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "Country is required")
  private String country;

  @Column(nullable = false)
  @NotBlank(message = "state is required")
  private String state;

  @Column(nullable = false)
  @NotBlank(message = "city is required")
  private String city;

  @Column(nullable = false)
  @NotBlank(message = "city is required")
  private String area;

  @Column(nullable = false)
  @NotBlank(message = "contact is required")
  private String contact;

  @JsonBackReference
  @OneToMany(mappedBy = "personEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<TradesmanEntity> tradesmanEntities = new ArrayList<>();

  @Column(nullable = false)
  @NotBlank(message = "Name is required")
  private boolean active;

  @Column(nullable = false)
  @NotBlank(message = "avatar is required")
  private String avatar;

  @Type(JsonType.class)
  @Column(columnDefinition = "jsonb")
  private String resume;
}
