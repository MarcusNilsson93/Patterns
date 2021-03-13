package shop;
import java.math.BigDecimal;

public class Receipt {
    BigDecimal sum = BigDecimal.ZERO;
    String name;
    String discount;

    public Receipt(BigDecimal sum, String name, String discount){
        this.sum = sum;
        this.name = name;
        this.discount = discount;
    }
}




