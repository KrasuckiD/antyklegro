package com.repository;

import com.domain.Auction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuctionRepository extends CrudRepository<Auction, Long> {
    Optional<Auction> findById(Long id);
    void delete(Auction auction);
}
