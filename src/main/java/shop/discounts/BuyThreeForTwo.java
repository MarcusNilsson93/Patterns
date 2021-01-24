package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BuyThreeForTwo implements Discounts {

    private String discount;

    @Override
    public BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items) {
        var sum = BigDecimal.ZERO;

        for (var item: items){
            if (item.quantity() == 3){
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum).subtract(item.itemCost());
                discount = item.itemCost().toString();
            }
            else {
                sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
            }
        }
        return sum;
    }

    @Override
    public String discountValue() {
        return "minus"+ discount;
    }
}
