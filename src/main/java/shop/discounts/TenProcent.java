package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TenProcent implements Discounts{

    private String discount;

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;
        var allItems = BigDecimal.ZERO;

        for (var item: items) {
            allItems = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(allItems);
        }

        if(allItems.doubleValue() >= 500) {
            sum = allItems.multiply(BigDecimal.valueOf(0.90));
            BigDecimal x = allItems.multiply(BigDecimal.valueOf(0.10));
            discount = x.toString();
        } else {
            sum = allItems;
        }

        return sum;
    }

    @Override
    public String discountValue() {
        return "minus"+discount;
    }
}
