package com.example.wbdvsp20bazaarjavaserver.repositories;
import java.util.List;
import com.example.wbdvsp20bazaarjavaserver.models.Listing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ListingRepository extends CrudRepository<Listing, Integer> {

    @Query("SELECT listing FROM Listing listing WHERE listing.id=:listingId")
    public Listing findListingById(@Param("listingId") int lid);

    @Query("SELECT listing FROM Listing listing WHERE listing.user.id=:uid")
    public List<Listing> findListingsForUser(@Param("uid") int userId);

    @Query("SELECT listing FROM Listing listing")
    public List<Listing> findAllListings();

}