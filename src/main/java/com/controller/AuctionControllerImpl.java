package com.controller;

import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;
import com.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuctionControllerImpl implements AuctionController {
    @Autowired
    public AuctionControllerImpl(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    private AuctionService auctionService;

    @Override
    @PostMapping("/addAuction")
    public ResponseEntity<AuctionDto> addAuctionToDtb(AuctionDto auctionDto) throws EmailNotFoundException {
        auctionService.addAuctionToDtb(auctionDto);
        return new ResponseEntity<>(OK);
    }
}
