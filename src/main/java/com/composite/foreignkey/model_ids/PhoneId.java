package com.composite.foreignkey.model_ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode
public class PhoneId implements Serializable {
  @Column(name = "area_code")
  private int areaCode;

  @Column(name = "number")
  private String number;
}
