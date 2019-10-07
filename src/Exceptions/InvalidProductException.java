package Exceptions;

public class InvalidProductException extends ProductNotFoundException {
    public InvalidProductException() {
        System.out.println("InvalidProductException");
    }
}
