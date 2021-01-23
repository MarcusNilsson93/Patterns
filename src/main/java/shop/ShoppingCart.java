package shop;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart implements Discounts {

    private final Set<ShoppingCartItem> items = new HashSet<>();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
    }

    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }

    public BigDecimal calculatePrice(){
        var sum = BigDecimal.ZERO;
        BigDecimal TenProcent = new BigDecimal("500.00");

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        //if sum bigdecimal bigger then 500
        System.out.println(sum.compareTo(TenProcent));
        if(sum.compareTo(TenProcent) > 0){
            OverFiveHundred(sum);
        }
        return sum;
    }

    public void undo(){
        //Undo the latest change to the ShoppingCart
    }


    public void redo(){
        //Redo the latest change to the ShoppingCart
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
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice()));
        return sb.toString();
    }

    @Override
    public void BuyThreePayForTwo() {

    }

    @Override
    public void OverFiveHundred(BigDecimal D) {
        // 0.10 * D = så mycket som skall dras bort på summan

    }

    @Override
    public void BuyFiveGetOneForFree() {

    }
}
