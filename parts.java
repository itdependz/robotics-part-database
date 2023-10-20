import java.util.*;
import java.io.*;
public class parts {
    private String name;
    private double price;
    private int quantity;
    private String link;
    private boolean status;
    public void part(){
        this.name = name;
        this.price =price;
        this.quantity = quantity;
        this.link = link;
    }

    public void createProduct(String name, double price, int quantity, String link, boolean status){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.link = link;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updatePrice(double price){
        this.price = price;
    }

    public void updateQuantity(int quantity){
        this.quantity = quantity;
    }

    public void updateLink(String link){
        this.link = link;
    }

    public void updateStatus(boolean status){
        this.status = status;
    }

}
