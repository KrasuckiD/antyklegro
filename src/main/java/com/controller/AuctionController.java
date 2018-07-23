package com.controller;

import com.domain.Auction;
import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;
import com.exeption.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AuctionController {
    @RequestMapping(path = "/addAuction", method = RequestMethod.POST)
    ResponseEntity<Auction> addAuctionToDtb(@RequestBody AuctionDto auctionDto) throws EmailNotFoundException;

    @DeleteMapping("/deleteAuction/{id}")
    ResponseEntity<Auction> removeFromDtb(@PathVariable(value = "id") Long id) throws ResourceNotFoundException;

}