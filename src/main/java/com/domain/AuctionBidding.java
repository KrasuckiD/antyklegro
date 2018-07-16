package com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuctionBidding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int bidPrice;

    @OneToOne
    Auction auction;

    @ManyToOne
    UserAccount user;

    @OneToOne
    AuctionSell sell;

    @OneToOne
    AuctionObservation observation;
}
