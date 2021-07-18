/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Storage.PetList;
import util.MyToys;
import java.util.Scanner;

/**
 *
 * @author Y545
 */
public class Service implements Comparable<Service> {
    private int id;
    private String name;
    private int price;
    private Pet pet;

    public Service() {
        id = 0;
        name = "";
        price = 0;
    }

    public Service(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    
    
    
     public void output(){
         System.out.printf("|SERVICE |ID: %5s|NAME: %15s|PRICE: %8d|\n",
                             id, name.toUpperCase(), price);
    }
     

    @Override
    public int compareTo(Service s) {
        if(id > s.getId()) return 1;
        else if(id < s.getId()) return -1;
        else return 0;
    }
}
