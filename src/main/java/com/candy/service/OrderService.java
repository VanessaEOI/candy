package com.candy.service;

import com.candy.dto.OrderRequest;
import com.candy.entity.CandyBox;
import com.candy.entity.Candytag;
import com.candy.entity.CustomerOrder;
import com.candy.entity.ItemCandyBox;
import com.candy.processor.CandytagProcessorFactory;
import com.candy.repository.CandyBoxRepository;
import com.candy.repository.CustomerOrderRepository;
import com.candy.repository.ItemCandyBoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    // ...

    private final CustomerOrderRepository customerOrderRepository;
    private final CandyBoxRepository candyBoxRepository;
    private final ItemCandyBoxRepository itemCandyBoxRepository;
    private final CandytagProcessorFactory candytagProcessorFactory;

    public OrderService(
            CandytagProcessorFactory candytagProcessorFactory,
            CustomerOrderRepository customerOrderRepository,
            CandyBoxRepository candyBoxRepository,
            ItemCandyBoxRepository itemCandyBoxRepository
    ) {
        this.candytagProcessorFactory = candytagProcessorFactory;
        this.customerOrderRepository = customerOrderRepository;
        this.candyBoxRepository = candyBoxRepository;
        this.itemCandyBoxRepository = itemCandyBoxRepository;
    }

    public CustomerOrder processOrder(OrderRequest orderRequest) {
        String candytagName = orderRequest.getCandytagName();
        int quantity = orderRequest.getQuantity();

        // Utiliser CandyTagProcessorFactory pour récupérer le bon CandyTagProcessor en fonction du nom du CandyTag.
        Candytag candyTag = candytagProcessorFactory.getCandytagProcessor(candytagName).getCandytag();

        // Appliquer les règles spécifiques au CandyTag pour créer la commande.
        CustomerOrder customerOrder = candytagProcessorFactory
                .getCandytagProcessor(candytagName)
                .processOrder(quantity);

        // Enregistrer la commande en base de données en utilisant les repositories appropriés.
        // Sauvegarder la commande client
        CustomerOrder savedCustomerOrder = customerOrderRepository.save(customerOrder);

        // Sauvegarder les CandyBox associées à la commande
        List<CandyBox> candyBoxes = customerOrder.getCandyBoxes();
        candyBoxes.forEach(candyBoxRepository::save);

        // Sauvegarder les ItemCandyBox associés à chaque CandyBox
        List<ItemCandyBox> itemCandyBoxes = candyBoxes.stream()
                .flatMap(candyBox -> candyBox.getItemCandyBoxes().stream())
                .collect(Collectors.toList());
        itemCandyBoxes.forEach(itemCandyBoxRepository::save);

        return savedCustomerOrder;
    }
}
