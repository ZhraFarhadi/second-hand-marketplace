package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConversationRepository
        extends JpaRepository<Conversation, Long> {

    Optional<Conversation> findByBuyerAndSellerAndAdvertisement(
            User buyer,
            User seller,
            Advertisement advertisement
    );

    @Query("""

            SELECT c
            FROM Conversation c

            WHERE

            c.buyer = :user

            OR

            c.seller = :user

            ORDER BY c.lastMessageAt DESC NULLS LAST

            """)
    Page<Conversation> findMyConversations(

            @Param("user") User user,

            Pageable pageable

    );

}
