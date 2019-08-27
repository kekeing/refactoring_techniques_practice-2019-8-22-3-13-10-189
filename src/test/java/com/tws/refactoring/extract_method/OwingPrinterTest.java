package com.tws.refactoring.extract_method;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.tws.refactoring.extract_variable.BannerRender;
import com.tws.refactoring.extract_variable.PriceCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
//        System.out.print("hello");
//        assertEquals("hello", outContent.toString());
    }
    @Test
    public  void should_get_price_when_getPrice_given_quantity_itemPrice(){
        //given
        int quantity = 50;
        int price = 1;
        double result = 0;
        PriceCalculator priceCalculator = new PriceCalculator();

        //when
        result = priceCalculator.getPrice(quantity,price);


        //then
        assertEquals(result,55,0.01);

    }
    @Test
    public void should_print_orders_when_print_owing_given_name_as_lk_and_total_amount(){
        String name = "lk";
        List<Order> orders = new ArrayList<Order>();
        orders.add(new Order(3));
        orders.add(new Order(4));
        OwingPrinter owingPrinter = new OwingPrinter();


        owingPrinter.printOwing(name,orders);

        String result = "*****************************\r\n"
                + "****** Customer totals ******\r\n"
                + "*****************************\r\n"
                + "name: lk\r\n"
                + "amount: 7.0\r\n";
        assertEquals(result,outContent.toString());
    }

    @Test
    public  void  should_return_IE_on_MAC_when_render_banner_given_platform_browser_exits_IE_or_MAC(){
        String platform = "MAC";
        String browser = "IE";
        String result = "";
        BannerRender bannerRender = new BannerRender();

        result = bannerRender.renderBanner(platform,browser);

        assertEquals(result,"IE on Mac?");

    }

}