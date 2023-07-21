package com.candy.processor;
import com.candy.entity.CandyBox;
import com.candy.entity.CandytagEnum;
import com.candy.entity.CustomerOrder;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public abstract class AsagaoProcessor implements CandytagProcessor {

    private static final int MAX_CANDY_PER_CANDYBOX = 50;

    @Override
    public String getCandytagName() {

        return CandytagEnum.ASAGAO.name();
    }

    @Override
    public CustomerOrder processOrder(int quantity) {
        // Vérifie l'heure pour les commandes Asagao
        LocalTime orderTime = LocalTime.now();
        int hour = orderTime.getHour();

        if (hour >= 6 && hour < 12) {
            System.out.println("Vous pouvez commander des bonbons Asagao maintenant !");
            return createAsagaoOrder(quantity);
        } else {
            System.out.println("Désolé, les commandes de bonbons Asagao ne sont disponibles que le matin entre 6h et midi.");
            return null;
        }
    }

    private CustomerOrder createAsagaoOrder(int quantity) {
        // Créer la commande CustomerOrder pour les bonbons Asagao
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderCandyQty(quantity);

        // Générer les couleurs de bonbons et les stocker dans des CandyBox
        List<String> candyColors = generateCandyColors(quantity);
        List<CandyBox> candyBoxes = generateCandyBoxes(candyColors);

        customerOrder.setCandyBoxes(candyBoxes);

        return customerOrder;
    }

    private List<String> generateCandyColors(int quantity) {
        String[] colors = {"Blanc", "Bleu", "Cyan", "Jaune", "Mauve", "Rouge", "Vert"};
        List<String> candyColors = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            int indexColor = new Random().nextInt(colors.length);
            candyColors.add(colors[indexColor]);
        }

        return candyColors;
    }

    private List<CandyBox> generateCandyBoxes(List<String> candyColors) {
        List<CandyBox> candyBoxes = new ArrayList<>();

        // Répartir les bonbons dans des CandyBox
        int remainingCandy = candyColors.size();
        while (remainingCandy > 0) {
            int candyCountInBox = Math.min(remainingCandy, MAX_CANDY_PER_CANDYBOX);
            List<String> candiesInBox = candyColors.subList(candyColors.size() - remainingCandy, candyColors.size() - remainingCandy + candyCountInBox);

            CandyBox candyBox = new CandyBox();
            candyBox.setCandyColors(candiesInBox);
            candyBoxes.add(candyBox);

            remainingCandy -= candyCountInBox;
        }

        return candyBoxes;
    }
}