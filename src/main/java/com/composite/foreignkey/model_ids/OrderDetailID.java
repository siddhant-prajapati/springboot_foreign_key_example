package com.composite.foreignkey.model_ids;

import com.composite.foreignkey.model.Order;
import com.composite.foreignkey.model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class  OrderDetailID implements Serializable {

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

}
