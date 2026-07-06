package com.jpmc.midascore.listener;

import com.jpmc.midascore.foundation.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class TransactionListener {

    @KafkaListener(
            topics = "${general.kafka-topic}",
            groupId = "midas-core"
    )
    public void receive(Transaction transaction) {

    }

}