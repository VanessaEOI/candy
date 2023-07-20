package com.candy.processor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AsagaoProcessor {
    private static final int MAX_CANDY_PER_CANDYBOX = 50;
    // Méthode pour commander des bonbons uniquement le matin
    public static void asagaoOrder(int quantity) {
        // Pour avoir l'heure globale
        LocalTime orderTime = LocalTime.now();
        // Pour récupérer uniquement l'heure pour la vérification
        int hour = orderTime.getHour();

        // Vérifie l'heure
        if (hour >= 6 && hour < 16) {
            System.out.println("Vous pouvez commander des bonbons maintenant !");
            defineCandyColor(quantity);
        } else {
            System.out.println("Désolé, les commandes de bonbons sont uniquement disponibles le matin entre 6h et midi.");
        }
    }
    // Méthode pour générer couleurs aléatoires pour chaque bonbons
    public static void defineCandyColor(int quantity) {
        String[] colors = {"Blanc", "Bleu", "Cyan", "Jaune", "Mauve", "Rouge", "Vert"};

        /// Calcul du nombre de Candybox nécessaires pour la quantité de bonbons
        int numberCandybox = ( quantity + MAX_CANDY_PER_CANDYBOX - 1 )/ MAX_CANDY_PER_CANDYBOX;

        // Créer une liste pour stocker les candybox
        List<List<String>> candyboxLists = new ArrayList<>();

        // Générer les candybox et répartir les bonbons dedans
        int remainingCandy = quantity;
        for (int i = 0; i < numberCandybox; i++) {
            List<String> candybox = new ArrayList<>();
            for (int j = 0; j < MAX_CANDY_PER_CANDYBOX && remainingCandy > 0; j++) {
                int indexColor = new Random().nextInt(colors.length);
                candybox.add(colors[indexColor]);
                remainingCandy--;
            }
            candyboxLists.add(candybox);
        }

        // Afficher les candybox avec leurs bonbons
        System.out.println("Voici les couleurs des bonbons dans chaque Candybox :");
        for (int i = 0; i < candyboxLists.size(); i++) {
            List<String> candybox = candyboxLists.get(i);
            System.out.println("Candybox " + (i + 1) + " : " + candybox);
        }
    }

    // Méthode principale pour tester la commande de bonbons
    public static void main(String[] args) {
        asagaoOrder(255);
    }
}
