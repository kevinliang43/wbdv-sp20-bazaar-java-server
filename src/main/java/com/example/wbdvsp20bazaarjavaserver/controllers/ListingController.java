package com.example.wbdvsp20bazaarjavaserver.controllers;
import com.example.wbdvsp20bazaarjavaserver.models.User;
import com.example.wbdvsp20bazaarjavaserver.models.Listing;
import com.example.wbdvsp20bazaarjavaserver.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class ListingController {

    @Autowired
    ListingService listingService = new ListingService();

    @PostMapping("/api/users/{uid}/listings")
    public Listing createListing(HttpSession session,
        @RequestBody Listing newListing,
        @PathVariable int uid) {
            Listing listing = this.listingService.createListing(uid, newListing);
            return listing;
    } 

    @GetMapping("/api/listings")
    public List<Listing> findAllListings() {
            return this.listingService.findAllListing();
    }

    @GetMapping("/api/users/{uid}/listings")
    public List<Listing> findListingsForUserId(
        @PathVariable("uid") int uid) {
            return this.listingService.findListingforUserId(uid);
    }

    @GetMapping("/api/listings/{lid}")
    public Listing findListingById(
        @PathVariable int lid) {
            return this.listingService.findListingById(lid);
    }

    @PutMapping("/api/users/{uid}/listings/{lid}")
    public int updateListing(HttpSession session,
        @PathVariable("lid") int lid,
        @PathVariable("uid") int uid,
        @RequestBody Listing updatedListing) {

        // Allow updates only if the session User Id matches the Id of User being updated
        if (((User)session.getAttribute("profile")).getId() == uid) {
            int updateStatus = this.listingService.updateListing(uid, updatedListing);
            return updateStatus;
        }
        else { // Session User id does not match the id of the user being updated.
            return 0;
        }
    }

    @DeleteMapping("/api/users/{uid}/listings/{lid}")
    public int deleteUser(HttpSession session,
        @PathVariable("lid") int lid,
        @PathVariable("uid") int uid) {

        // Allow deletes only if the session User Id matches the Id of User being deleted.
        if (((User)session.getAttribute("profile")).getId() == uid) {
            int deleteStatus = listingService.deleteListing(lid);
            return deleteStatus;
        }
        else {
            // Session User Id does not match the id of the user being deleted.
            return 0;
        }
    }

}