package shop.discounts;

import shop.ShoppingCart;
import shop.ShoppingCartItem;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DiscountImpl {
    private Discounts discounts;

    public ArrayList <ShoppingCartItem> items = new ArrayList<>();

    public DiscountImpl (ArrayList<ShoppingCartItem> shopingcart) {
        this.items = shopingcart;
    }

    public BigDecimal checkDiscount(Discounts discountInterface) {
        this.discounts = discountInterface;
        BigDecimal sum = this.discounts.returnDiscount(items);

        return sum;
    }

    public Discounts bestDiscount() {
        Discounts currentDiscount = new NoDiscount();

        ArrayList<Discounts> arr = new ArrayList<Discounts>();
        arr.add(new BuyThreeForTwo());
        arr.add(new CheapestItemForFree());
        arr.add(new TenProcent());
        arr.add(new NoDiscount());

        for(Discounts discount: arr) {
            double checkedDiscount = discount.returnDiscount(items).doubleValue();

            if(currentDiscount.returnDiscount(items).doubleValue() > checkedDiscount) {
                currentDiscount = discount;
            }
        }

        return currentDiscount;
    }
    public String getName(){
        return discounts.name();
    }
    public String getDiscountValue(){
        return discounts.discountValue();
    }
}
