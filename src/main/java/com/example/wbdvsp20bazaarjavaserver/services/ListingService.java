package com.example.wbdvsp20bazaarjavaserver.services;
import com.example.wbdvsp20bazaarjavaserver.models.Listing;
import com.example.wbdvsp20bazaarjavaserver.models.User;

import com.example.wbdvsp20bazaarjavaserver.repositories.ListingRepository;
import com.example.wbdvsp20bazaarjavaserver.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    UserRepository userRepository;

    public Listing createListing(int uid, Listing newListing) {
        User user = userRepository.findUserById(uid);
        newListing.setUser(user);
        return listingRepository.save(newListing);
    }

    public List<Listing> findAllListing() {
        return listingRepository.findAllListings();
    }

    public List<Listing> findListingforUserId(int uid) {
        return listingRepository.findListingsForUser(uid);
    }

    public Listing findListingById(int listingId) {
        return listingRepository.findListingById(listingId);
    }

    public int deleteListing(int listingId) {
        try {
            listingRepository.deleteById(listingId);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int updateListing(int listingId, Listing newListing) {
        try {
            Listing oldListing = listingRepository.findListingById(listingId);
            User user = oldListing.getUser();
            newListing.setUser(user);
            listingRepository.save(newListing);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}