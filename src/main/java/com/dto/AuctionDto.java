package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuctionDto {

    private String userEmail;
    private String name;
    private String summary;
    private int lowPrice;
    private int buyNowPrice;

    private String endDate;
}
