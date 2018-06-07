package pl.javastart.buisnesslogic;

import pl.javastart.model.Product;

import java.util.List;

public class PriceCalculator {

    public static double countTotalPrice(List<Product> products){
        double totalPrice=0;
        for (Product pr : products){
            totalPrice+=pr.getPrice();
        }
        return totalPrice;
    }

    public static double medianPrice(List<Product> products){
        return countTotalPrice(products)/products.size();
    }
}
