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

    public ServiceList() {
        list = new ArrayList<>();
    }
    
    public boolean addService(Service s) {
        return list.add(s);
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
           
    
    public boolean updateService(int id) {
        Service s = searchService(id);
        if(s == null) 
            return false;
        s.setId(MyToys.getAnInteger("Input new ID: ", "Invalid format!!"));
        s.setName(MyToys.getAString("Input new Name: ", "Invalid format!!"));
        s.setPrice(MyToys.getAnInteger("Input new Price: ", "Invalid format!!"));
        return true;
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
