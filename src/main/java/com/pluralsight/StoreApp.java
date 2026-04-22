package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        //This will sort the product by name before it is displayed.
        inventory.sort(Comparator.comparing(Product::getName));


        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = (inventory.get(i));
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }








        //--------------------------------------------------------


    }

    //This will display the inventory
    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory
        // and its details are not shown
        inventory.add(new Product(1223, "jack", 54345));
        inventory.add(new Product(3434, "bob", 564332));
        inventory.add(new Product(6543, "rob", 6787));
        inventory.add(new Product(8799, "George", 27781));
        inventory.add(new Product(2340, "Andy", 5322));



        try{
            FileReader fileReader = new FileReader("src/main/java/com/pluralsight/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder str = new StringBuilder();
            String singleLine;

            while((singleLine = bufferedReader.readLine()) != null){

                String[] parts = singleLine.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float hours_worked = Float.parseFloat(parts[2]);

                inventory.add(new Product(id, name, hours_worked));


            }

        }
        catch(IOException e){
            e.getMessage();
        }


        return inventory;
    }





}
