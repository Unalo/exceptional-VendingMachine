package exceptions;

public class SoftDrinkException extends ProductNotFoundException {
   public SoftDrinkException() {
       System.out.println("SoftDrinkOutOfStockException");
   }
}
