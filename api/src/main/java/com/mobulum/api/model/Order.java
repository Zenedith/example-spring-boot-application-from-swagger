package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = Order.OrderBuilder.class)
public class Order {
    private final Long id;
    private final Long petId;
    private final Integer quantity;
    private final String shipDate;
    private final OrderStatus status;
    private final Boolean complete;
    

    private Order(Long id, Long petId, Integer quantity, String shipDate, OrderStatus status, Boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
        
    }

    public Long getId() {
      return id;
    }
    public Long getPetId() {
      return petId;
    }
    public Integer getQuantity() {
      return quantity;
    }
    public String getShipDate() {
      return shipDate;
    }
    public OrderStatus getStatus() {
      return status;
    }
    public Boolean getComplete() {
      return complete;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(id, petId, quantity, shipDate, status, complete);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.petId, other.petId) && 
                Objects.equals(this.quantity, other.quantity) && 
                Objects.equals(this.shipDate, other.shipDate) && 
                Objects.equals(this.status, other.status) && 
                Objects.equals(this.complete, other.complete);
                
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + "', " +
                "petId='" + petId + "', " +
                "quantity='" + quantity + "', " +
                "shipDate='" + shipDate + "', " +
                "status='" + status + "', " +
                "complete='" + complete + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class OrderBuilder {
        private Long id;
        private Long petId;
        private Integer quantity;
        private String shipDate;
        private OrderStatus status;
        private Boolean complete;
        

        private OrderBuilder() {
        }

        public static OrderBuilder aOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder withId(Long id) {
          this.id = id;
          return this;
        }
        public OrderBuilder withPetId(Long petId) {
          this.petId = petId;
          return this;
        }
        public OrderBuilder withQuantity(Integer quantity) {
          this.quantity = quantity;
          return this;
        }
        public OrderBuilder withShipDate(String shipDate) {
          this.shipDate = shipDate;
          return this;
        }
        public OrderBuilder withStatus(OrderStatus status) {
          this.status = status;
          return this;
        }
        public OrderBuilder withComplete(Boolean complete) {
          this.complete = complete;
          return this;
        }
        

        public Order build() {
            return new Order(id, petId, quantity, shipDate, status, complete);
        }
    }
}
