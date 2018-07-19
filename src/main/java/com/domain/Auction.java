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
public class Auction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String summary;
    private int lowPrice;
    private int buyNowPrice;

    private String startDate;
    private String endDate;
    private int views;
    private boolean promoted;

    @ManyToOne
    UserAccount users;

    @OneToOne
    UserAccount owner;

    @ManyToOne
    AuctionCategory category;

    @OneToOne
    AuctionBidding bidding;

    @OneToOne
    AuctionSell sell;

    @OneToOne
    AuctionObservation observation;
}
