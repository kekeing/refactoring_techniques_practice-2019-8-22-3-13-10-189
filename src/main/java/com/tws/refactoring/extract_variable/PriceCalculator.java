package com.tws.refactoring.extract_variable;

public class PriceCalculator {
   public double getPrice(int quantity, int itemPrice) {
       int smallAmountNotDiscount = 500;
       double discountQuantityOverThanSmallAmount = 0.05;
       double maxPostMoney = 100.0;
       double interestOfPost = 0.1;
       double result = quantity * itemPrice -
               Math.max(0, quantity - smallAmountNotDiscount) * itemPrice * discountQuantityOverThanSmallAmount +
               Math.min(quantity * itemPrice * interestOfPost, maxPostMoney);
        // Price consists of: base price - discount + shipping cost
        return result;
    }
}
