package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
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

    Page<Conversation> findByBuyerOrderByLastMessageAtDesc(
            User buyer,
            Pageable pageable
    );

    Page<Conversation> findBySellerOrderByLastMessageAtDesc(
            User seller,
            Pageable pageable
    );

}
