import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat usnf = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat innf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat chinf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat frnf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    
        String us = usnf.format(payment);
        String india = innf.format(payment);
        String china = chinf.format(payment);
        String france = frnf.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
