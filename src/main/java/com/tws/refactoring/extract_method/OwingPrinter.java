package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    public String printBanner(){
        String result = "";
        result = "*****************************\r\n"
                + "****** Customer totals ******\r\n"
                + "*****************************\r\n";
        return result;
    }
    public double getTotalAmount(List<Order> orders){
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return  outstanding;
    }
    public String printDetalis(String name,double outstanding){
        String result = "";
        result = "name: " + name + "\r\n" + "amount: " + outstanding ;
        return  result;

    }
    void printOwing(String name, List<Order> orders) {
        String result = "";
        double totalAmount = getTotalAmount(orders);
        result = printBanner();
        result += printDetalis(name,totalAmount);
        System.out.println(result);


    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
