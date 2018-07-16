package com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String accountName;
    private String addressRegion;
    private String addressCity;
    private String addressStreet;


    private String accountCreateDate;
    private String accountStatus;
    private boolean accountTypePremium;


    @OneToMany
    private List <Auction> auctionOwner;

    @OneToMany
    private List<Auction> auctionUser;

    @OneToMany
    private List<AuctionBidding> biddingUser;

    @OneToMany
    private List <AuctionObservation> obserwation;

    @OneToOne
    AuctionRating rating;
}
