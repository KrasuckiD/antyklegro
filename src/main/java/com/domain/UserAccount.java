package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    @JsonIgnore
    private String password;
    private String accountName;
    private String addressRegion;
    private String addressCity;
    private String addressStreet;


    private String accountCreateDate;
    private boolean accountActivation;
    private boolean accountTypePremium;


    @OneToMany
    private List <Auction> auctionOwner;

    @OneToMany
    private List<Auction> auctionUser;

    @OneToMany
    private List<AuctionBidding> biddingUser;

    @OneToMany
    private List <AuctionObservation> observations;

    @OneToOne
    AuctionRating rating;
}
