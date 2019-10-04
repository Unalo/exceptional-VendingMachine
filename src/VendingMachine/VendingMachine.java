package VendingMachine;

import Exceptions.ChocolateException;
import Exceptions.ProductNotFoundException;
import Exceptions.SaltySnacksException;
import Exceptions.SoftDrinkException;

public class VendingMachine {

     int stockChocolate = 5;
     int stockSoftDrink = 5;
     int stockSaltySnacks = 5;

    public  void addStock(Products products, int stock){
        if(products instanceof SoftSDrinks){
            stockSoftDrink = stock;
        } else  if (products instanceof SaltySnacks) {
            stockSaltySnacks = stock;
        } else if (products instanceof Chocolates) {
            stockChocolate = stock;
        }
    }

    public  void buy(Products products) throws ProductNotFoundException {
        if(products instanceof  SoftSDrinks){
            if (stockSoftDrink == 0) {
                throw new SoftDrinkException();
            } else {
                stockSoftDrink+=-1;
                System.out.println(stockSoftDrink);
            }
        } else if (products instanceof SaltySnacks) {
            if (stockSaltySnacks == 0 ) {
                throw new SaltySnacksException();
            } else {
                stockSaltySnacks +=-1;
            }
        } else if (products instanceof Chocolates) {
            if (stockChocolate == 0 ) {
                throw new ChocolateException();
            } else {
                stockChocolate +=-1;
            }
        }
    }

    public static void main(String[] args) throws ProductNotFoundException {
        try {
            Chocolates chocolates = new Chocolates();
            SaltySnacks saltySnacks = new SaltySnacks();
            SoftSDrinks softSDrinks = new SoftSDrinks();
            VendingMachine vendingMachine = new VendingMachine();

            vendingMachine.addStock(softSDrinks,2);
            vendingMachine.addStock(chocolates, 1);
            vendingMachine.addStock(saltySnacks, 2);

//            vendingMachine.buy(softSDrinks);
//            vendingMachine.buy(softSDrinks);
//            vendingMachine.buy(softSDrinks);

//            vendingMachine.buy(chocolates);
//            vendingMachine.buy(chocolates);

            vendingMachine.buy(saltySnacks);
            vendingMachine.buy(saltySnacks);
            vendingMachine.buy(saltySnacks);

        } catch (SoftDrinkException ex) {
          ex.printStackTrace();
        } catch (SaltySnacksException ex) {
            ex.printStackTrace();
        } catch (ChocolateException ex) {
            ex.printStackTrace();
        }
    }
}
