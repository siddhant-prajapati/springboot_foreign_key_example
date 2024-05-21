package com.composite.foreignkey.model;

import com.composite.foreignkey.model_ids.OrderDetailID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetails {
  @EmbeddedId
  private OrderDetailID id;


  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private int quality;

  private float unitPrice;

  private float subTotal;
}
