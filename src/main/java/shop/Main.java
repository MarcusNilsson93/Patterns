package shop;

import shop.undo.HistoryStack;

public class Main {
    public static void main(String[] args) {

        // Creates a ShoppingCart and a undo/redo stack
        ShoppingCart cart = new ShoppingCart();
        HistoryStack stack = new HistoryStack();

        // Create new items
        Product item1 = new Product("Smör");
        Product item2 = new Product("Bröd");
        Product item3 = new Product("Kaffe");
        Product item4 = new Product("Chips");
        Product item5 = new Product("Mjölk");
        Product item6 = new Product("Fanta exotic");

        ShoppingCartItem shoppingCartItem1 = new ShoppingCartItem(item1, 12.50, 1);
        ShoppingCartItem shoppingCartItem2 = new ShoppingCartItem(item2, 21.90, 1);
        ShoppingCartItem shoppingCartItem3 = new ShoppingCartItem(item3, 35.00, 1);
        ShoppingCartItem shoppingCartItem4 = new ShoppingCartItem(item4, 25.00, 1);
        ShoppingCartItem shoppingCartItem5 = new ShoppingCartItem(item5, 12.50, 1);
        ShoppingCartItem shoppingCartItem6 = new ShoppingCartItem(item6, 15.99, 1);

        cart.addCartItem(shoppingCartItem1);
        cart.addCartItem(shoppingCartItem2);
        cart.addCartItem(shoppingCartItem3);
        cart.addCartItem(shoppingCartItem4);
        cart.addCartItem(shoppingCartItem5);
        cart.addCartItem(shoppingCartItem6);

        // Undo & Redo
        cart.undo(stack);
        cart.redo(stack);
        cart.undo(stack);
        cart.undo(stack);

        // Change quantity
        shoppingCartItem1.setQuantity(5);

        // Undo & Redo
        cart.undo(stack);
        cart.redo(stack);

        // Print receipt
        System.out.println(cart.receipt());

    }
}
