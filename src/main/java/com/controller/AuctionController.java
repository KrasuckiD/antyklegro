package com.controller;

import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;
import org.springframework.http.ResponseEntity;

public interface AuctionController {
    ResponseEntity<AuctionDto> addAuctionToDtb(AuctionDto auctionDto) throws EmailNotFoundException;
}
