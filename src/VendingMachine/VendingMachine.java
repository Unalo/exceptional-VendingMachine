package VendingMachine;

import exceptions.*;
import products.*;

public class VendingMachine {

     int stockChocolate = 0;
     int stockSoftDrink = 0;
     int stockSaltySnacks = 0;

    public  void addStock(Product product, int stock){
        if(product instanceof SoftSDrink){
            stockSoftDrink = stock;
        } else  if (product instanceof SaltySnack) {
            stockSaltySnacks = stock;
        } else if (product instanceof Chocolate) {
            stockChocolate = stock;
        }
    }
    
    public void getStock(Product product) {
        if (product instanceof SoftSDrink) {
            System.out.println("we have " + stockSoftDrink + " soft drinks available") ;
        } else if (product instanceof Chocolate) {
            System.out.println("we have " + stockChocolate + " chocolates available");
        } else if (product instanceof SaltySnack) {
            System.out.println("we have " + stockSaltySnacks + " salty snakes available");
        }
    }

    public  void buy(Product product) throws ProductNotFoundException {
        if (product instanceof SoftSDrink) {
            if (stockSoftDrink == 0) {
                throw new SoftDrinkException();
            } else {
                stockSoftDrink+=-1;
            }
        } else if (product instanceof SaltySnack) {
            if (stockSaltySnacks == 0 ) {
                throw new SaltySnacksException();
            } else {
                stockSaltySnacks +=-1;
            }
        } else if (product instanceof Chocolate) {
            if (stockChocolate == 0 ) {
                throw new ChocolateException();
            } else {
                stockChocolate +=-1;
            }
        }
    }

    public static void main(String[] args) throws ProductNotFoundException {

        VendingMachine vendingMachine = new VendingMachine();

        try {

            Chocolate Cadbury = new Chocolate("Cadbury");
            SaltySnack popcorn = new SaltySnack("popcorn");
            SoftSDrink coke = new SoftSDrink("coke");

            vendingMachine.addStock(Cadbury,5);
            vendingMachine.addStock(popcorn, 10);
            vendingMachine.addStock(coke, 8);

            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);

            vendingMachine.buy(Cadbury);
            vendingMachine.buy(Cadbury);

            vendingMachine.buy(popcorn);
            vendingMachine.buy(popcorn);
            vendingMachine.buy(popcorn);

            vendingMachine.getStock(Cadbury);
            vendingMachine.getStock(coke);
            vendingMachine.getStock(popcorn);

        } catch (ProductNotFoundException ex) {
          ex.printStackTrace();
        }
    }
}
