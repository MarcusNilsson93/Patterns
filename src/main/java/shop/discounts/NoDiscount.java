package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class NoDiscount implements Discounts{

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }

        return sum;
    }

    @Override
    public String discountValue() {
        return "";
    }

    @Override
    public String name() {
        return "";
    }
}
