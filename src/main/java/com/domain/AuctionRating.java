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
public class AuctionRating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private int sellRate;
    private String sellComment;
    private int byyRate;
    private String buyRate;

    @OneToOne
    AuctionSell sell;

    @OneToOne
    UserAccount userAccount;
}