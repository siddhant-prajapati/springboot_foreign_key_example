package com.composite.foreignkey.model_ids;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportId implements Serializable {
  private String countryCode;
  private String cityCode;
}
