package com.composite.foreignkey.model;

import com.composite.foreignkey.model_ids.PhoneId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phone_contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
  @EmbeddedId
  private PhoneId id;

  @Column(nullable = false)
  private String firstName;


  @Column(nullable = false)
  private String lastName;
}
