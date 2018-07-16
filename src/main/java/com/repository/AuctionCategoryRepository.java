package com.repository;

import com.domain.AuctionCategory;
import org.springframework.data.repository.CrudRepository;

public interface AuctionCategoryRepository extends CrudRepository<AuctionCategory, Long> {
}
