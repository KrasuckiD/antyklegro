package com.controller;

import com.domain.Auction;
import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;
import com.exeption.ResourceNotFoundException;
import com.repository.AuctionRepository;
import com.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class AuctionControllerImpl implements AuctionController {
    @Autowired
    public AuctionControllerImpl(AuctionService auctionService, AuctionRepository auctionRepository) {
        this.auctionService = auctionService;
        this.auctionRepository = auctionRepository;
    }

    private AuctionService auctionService;
    private AuctionRepository auctionRepository;

    @Override
    @RequestMapping(path = "/addAuction", method = RequestMethod.POST)
    public ResponseEntity<Auction> addAuctionToDtb(@RequestBody AuctionDto auctionDto) throws EmailNotFoundException {
        return Optional.ofNullable(auctionService.addAuctionToDtb(auctionDto))
                .map(ResponseEntity::ok).orElseThrow(EmailNotFoundException::new);
    }


    @Override
    @DeleteMapping("/deleteAuction/{id}")
    public ResponseEntity<Auction> removeFromDtb(@PathVariable(value = "id")Long id) throws ResourceNotFoundException {
        Optional<Auction> auction = Optional.of(auctionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Auction", "id", id)));
        auctionRepository.delete(auction.get());
        return ResponseEntity.ok().build();
    }
}
