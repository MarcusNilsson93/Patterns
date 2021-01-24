package shop.discounts;

import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface Discounts {
   BigDecimal returnDiscount(ArrayList<ShoppingCartItem> items);
   String discountValue();
}
