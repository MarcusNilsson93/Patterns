package shop;

import shop.discounts.DiscountImpl;
import shop.discounts.Discounts;
import shop.undo.HistoryStack;
import shop.undo.State;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart {

    private final ArrayList<ShoppingCartItem> items = new ArrayList<>();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
        addToStack(item);

    }

    public void addToStack(ShoppingCartItem item){
        HistoryStack.addState(new State(() -> {
        }, () -> {
            items.add(item);
        }));
    }

    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }

    public Receipt calculatePrice(){
        DiscountImpl discount = new DiscountImpl(items);
        Discounts bestDiscount = discount.bestDiscount();
        BigDecimal addDiscount = discount.checkDiscount(bestDiscount);

        BigDecimal bigDecimal = discount.checkDiscount(bestDiscount);
        Receipt receipt = new Receipt(addDiscount, discount.getName(), discount.getDiscountValue());

        return receipt;
    }

    public void undo(HistoryStack stack){
        //Undo the latest change to the ShoppingCart
        stack.undo();
    }


    public void redo(HistoryStack stack){
        //Redo the latest change to the ShoppingCart
        stack.redo();
    }

    public String receipt() {
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-24s % 7.2f\n", each.product().name(), each.itemCost()));
        }
        sb.append(line);

        if(calculatePrice().name != "") {
            sb.append(String.format("%-24s %7s \n", calculatePrice().name, calculatePrice().discount));
        }
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice().sum));
        return sb.toString();
    }
}
