package com.candy.service;

import com.candy.dto.OrderRequest;
import com.candy.entity.Candytag;
import com.candy.entity.CustomerOrder;
import com.candy.processor.CandytagProcessor;
import com.candy.processor.CandytagProcessorFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CandytagProcessorFactory candytagProcessorFactory;

    public OrderService(CandytagProcessorFactory candytagProcessorFactory) {
        this.candytagProcessorFactory = candytagProcessorFactory;
    }

    public CustomerOrder processOrder(OrderRequest orderRequest) {
        String candytagName = orderRequest.getCandytagName();
        int quantity = orderRequest.getQuantity();

        // Utiliser CandyTagProcessorFactory pour récupérer le bon CandyTagProcessor en fonction du nom du CandyTag.
        CandytagProcessor candytagProcessor = candytagProcessorFactory.getCandytagProcessor(candytagName);

        if (candytagProcessor == null) {
            throw new IllegalArgumentException("CandyTag not found: " + candytagName);
        }

        // Appliquer les règles spécifiques au CandyTag pour créer la commande.
        CustomerOrder customerOrder = candytagProcessor.processOrder(quantity);

        // Enregistrer la commande en base de données en utilisant les repositories appropriés.
        // ...

        return customerOrder;
    }

}
