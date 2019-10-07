package exceptions;

public class ChocolateException  extends ProductNotFoundException {
   public ChocolateException() {
        System.out.println("ChocolateAllGone");
    }
}
