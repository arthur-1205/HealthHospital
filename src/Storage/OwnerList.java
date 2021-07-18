/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import util.MyToys;
import DTO.Owner;
import DTO.Pet;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Y545
 */
public class OwnerList {

    ArrayList<Owner> list;
    
    Owner o;
    public OwnerList() {
        list = new ArrayList<>();
    }

    public void addOwner() {
        
       int pos;
       String name, address, id;
       do{
           id = MyToys.getAString("Input Owner id: ", "Owner id is required!!");
           pos = findOwner(id);
           o = searchOwner(id);
           if(pos >= 0) 
               System.out.println("Owner id already exist!! Please input again!");
           }while(pos != -1);
           name = MyToys.getAString("Input Owner name: ", "Owner name is required!!");
           address = MyToys.getAString("Input Owner address: ", "Owner id is required!!");
           
           list.add(new Owner(id, name, address));
           System.out.println("=>>> Add Owner successfully!! <<<=");
    }

    public int findOwner(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Owner searchOwner(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return list.get(i);
            }
        }
        return null;
    }

    public void updateOwner() {
          int pos;
          String id;
        if (list.isEmpty()) {
            System.out.println("Owner List is empty!!");
            return;
        }
        do {
            id = MyToys.getAString("Input Owner ID to update: ", "Input a possitive integer!");
            pos = findOwner(id);
            o = searchOwner(id);
            if (pos == -1) {
                System.out.println("Owner id not exist!! Please input again!");
            }
        } while (pos == -1);
        
        o.setName(MyToys.getAString("Input new Owner name: ", "Owner name is required!!"));
        o.setAddress(MyToys.getAString("Input new Owner address: ", "Owner id is required!!"));
        System.out.println("=>>> Update Owner successfully <<<=");
        o.output();
    }

    public boolean removeOwner(String id) {
            Owner o = searchOwner(id);
            return list.remove(o);
    }

    public void displayAll() {       
        for (Owner o : list) {
            o.output();
        }
    }

    public void sortById() {
        Collections.sort(list);
    }

    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

}
