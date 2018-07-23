package com.service;

import com.domain.Auction;
import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;

public interface AuctionService {
    Auction addAuctionToDtb(AuctionDto auctionDto) throws EmailNotFoundException;

    void removeAuction(Long id);
}
