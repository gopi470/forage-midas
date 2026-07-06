package com.jpmc.midascore.listener;

import com.jpmc.midascore.component.DatabaseConduit;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class TransactionListener {

    private final DatabaseConduit databaseConduit;

    @Autowired
    public TransactionListener(DatabaseConduit databaseConduit) {
        this.databaseConduit = databaseConduit;
    }

    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core")
    public void receive(Transaction transaction) {
        databaseConduit.processTransaction(transaction);
    }

}