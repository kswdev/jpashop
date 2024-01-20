package jpabook.jpashop.domain;

import jpabook.jpashop.domain.common.Adress;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;
    @Embedded
    private Adress adress;
    private DeliveryStatus status;
}
