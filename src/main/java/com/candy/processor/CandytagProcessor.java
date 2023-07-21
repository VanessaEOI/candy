package com.candy.processor;

import com.candy.entity.Candytag;
import com.candy.entity.CustomerOrder;

public interface CandytagProcessor {
    String getCandytagName();
    CustomerOrder processOrder(int quantity);

    Candytag getCandytag();
}
