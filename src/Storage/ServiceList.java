/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import util.MyToys;
import DTO.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


/**
 *
 * @author Y545
 */
public class ServiceList {
    ArrayList<Service> list;
    Service s;
    public ServiceList() {
        list = new ArrayList<>();
    }
    
    public void addService() {
       int pos, id, price;
       String name, address;
       do{
           id = MyToys.getAnInteger("Input Service id: ", "Service id is required!!", 0);
           pos = findService(id);
           s = searchService(id);
           if(pos >= 0) 
               System.out.println("Service id already exist!! Please input again!");
           }while(pos != -1);
           name = MyToys.getAString("Input Service name: ", "Service name is required!!");
           price = MyToys.getAnInteger("Input Service price: ", "Input a positive integer!!", 0);
           
           list.add(new Service(id, name, price));
           System.out.println("=>>> Add Service successfully!! <<<=");
    }
    
    public int findService(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
                return i;
        }
        return -1;
    }
    
    public Service searchService(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) 
                return list.get(i);
        }
        return null;
    }
           
    
    public void updateService() {
        int pos, id;
        if (list.isEmpty()) {
            System.out.println("Service List is empty!!");
            return;
        }
        do {
            id = MyToys.getAnInteger("Input Service ID to update: ", "Input a possitive integer!", 0);
            pos = findService(id);
            s = searchService(id);
            if (pos == -1) {
                System.out.println("Service id not exist!! Please input again!");
            }
        } while (pos == -1);
        
        s.setName(MyToys.getAString("Input new Service name: ", "Service name is required!!"));
        s.setPrice(MyToys.getAnInteger("Input new Service price: ", "Input a positive integer!!", 0));
        System.out.println("=>>> Update Service successfully <<<=");
        s.output();
    }
    
    public boolean removeService(int id) {
        Service s = searchService(id);
        return list.remove(s);
    } 
    
    public void displayAll() {
        for (Service s : list) {
            s.output();
        }
    }
    
    public void searchById(){
        Collections.sort(list);
    }
    
    public void sortByID() {
        Collections.sort(list);
    }
    
    public boolean isEmpty() {
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    
}
