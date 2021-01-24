package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CheapestItemForFree implements Discounts{

    String discount;
    double chepest = 0;

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;
        for(var item: items) {
            if(items.size() > 3 && chepest == 0 || item.itemCost().doubleValue() < chepest) {
                chepest = item.itemCost().doubleValue();
                discount = item.product().name();
            }
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        return sum;
    }

    @Override
    public String discountValue() {
        String str = String.valueOf(chepest);
        return str;
    }
}
