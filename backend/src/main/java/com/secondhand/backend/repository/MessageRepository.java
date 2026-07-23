package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.Message;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface MessageRepository
        extends JpaRepository<Message, Long> {

    Page<Message> findByConversationOrderByCreatedAtAsc(
            Conversation conversation,
            Pageable pageable
    );

    Optional<Message> findTopByConversationOrderByCreatedAtDesc(
            Conversation conversation
    );

    boolean existsByConversationAndReceiverAndReadFalse(
            Conversation conversation,
            User receiver
    );

    long countByConversationAndReceiverAndReadFalse(
            Conversation conversation,
            User receiver
    );

    List<Message> findByConversationAndReceiverAndReadFalse(
            Conversation conversation,
            User receiver
    );

}//بعدا میتونیم این بخش رو بهینه سازی کنیم. یعنی برای نمایش اخرین پیام،تعداد پیامهای خوانده نشده
// در بخش لیست مکالمه ها یک dto طراحی کنیم. فعلا همین کافیه
