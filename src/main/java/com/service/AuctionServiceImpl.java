package com.service;

import com.domain.Auction;
import com.domain.UserAccount;
import com.dto.AuctionDto;
import com.exeption.EmailNotFoundException;
import com.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository,
                              UserAccountServiceImpl userAccountService) {

        this.auctionRepository = auctionRepository;
        this.userAccountService = userAccountService;
    }

    private AuctionRepository auctionRepository;
    private UserAccountServiceImpl userAccountService;

    @Override
    public Auction addAuctionToDtb(AuctionDto auctionDto) throws EmailNotFoundException {
        UserAccount userAccount = userAccountService.getUserByEmail(auctionDto.getUserEmail());
        Auction auction = Auction.builder()
                .owner(userAccount)
                .name(auctionDto.getName())
                .summary(auctionDto.getSummary())
                .lowPrice(auctionDto.getLowPrice())
                .buyNowPrice(auctionDto.getBuyNowPrice())
                .startDate(LocalDate.now().toString())
                .endDate(auctionDto.getEndDate())
                .views(0)
                .promoted(false)
                .build();

        auctionRepository.save(auction);

        return auction;
    }

    @Override
    public void removeAuction(Long id) {
        auctionRepository.deleteById(id);
    }

    private AuctionDto getAuctionDto(Auction auction) {
        return AuctionDto.builder()
                .userEmail(auction.getOwner().getEmail())
                .name(auction.getName())
                .summary(auction.getSummary())
                .category(auction.getCategory().toString())
                .lowPrice(auction.getLowPrice())
                .buyNowPrice(auction.getBuyNowPrice())
                .endDate(auction.getEndDate())
                .build();
    }
}
