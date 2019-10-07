package VendingMachine;

import Exceptions.*;
import Products.*;


public class VendingMachine {

     int stockChocolate = 5;
     int stockSoftDrink = 5;
     int stockSaltySnacks = 5;

    public  void addStock(Product product, int stock){
        if(product instanceof SoftSDrink){
            stockSoftDrink = stock;
        } else  if (product instanceof SaltySnack) {
            stockSaltySnacks = stock;
        } else if (product instanceof Chocolate) {
            stockChocolate = stock;
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

            vendingMachine.addStock(Cadbury,2);
            vendingMachine.addStock(popcorn, 1);
            vendingMachine.addStock(coke, 2);

            vendingMachine.buy(coke);
            vendingMachine.buy(coke);
            vendingMachine.buy(coke);

            vendingMachine.buy(Cadbury);
            vendingMachine.buy(Cadbury);
           // vendingMachine.buy();
            ;
            vendingMachine.buy(popcorn);
            vendingMachine.buy(popcorn);
            vendingMachine.buy(popcorn);

        } catch (ProductNotFoundException ex) {
          ex.printStackTrace();
        }
    }
}
