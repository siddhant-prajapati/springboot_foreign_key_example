package com.composite.foreignkey.model;

import com.composite.foreignkey.model_ids.AirportId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airport")
@IdClass(AirportId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
  @Id
  @Column(length = 3)
  private String countryCode;

  @Id
  @Column(length = 4)
  private String cityCode;

  private String name;
}
