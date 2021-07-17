/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import util.MyToys;
import DTO.Pet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Y545
 */
public class PetList {
    ArrayList<Pet> list;

    public PetList() {
        list = new ArrayList<>();
    }

    public boolean addPet() {  
       Pet p;
       int id, pos;
       String name, birthday, gender;
       do{
           id = MyToys.getAnInteger("Input Pet id: ", "Pet id must be a postive integer!!", 0);
           pos = findPet(id);
           if(pos >= 0) {
               System.out.println("Pet id already exist!! Please input again!");
           }
       }
       
    }
    
    public int findPet(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
                return i;
        }
        return -1;
    }
    
    public Pet searchPet(int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }
    
    public boolean updatePet(int id) {
        Pet p = searchPet(id);
        if(p==null) return false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input new name: ");
        p.setName(MyToys.getAString("Invalid format!!"));
        System.out.println("Input new birthday: ");
        p.setBirthday(MyToys.getAString("Invalid format!!"));
        System.out.println("Input new gender: ");
        p.setGender(MyToys.getAString("Invalid format!!"));
        return true;
    }
    
    public boolean removePet(int id) {
        Pet p = searchPet(id);
        return list.remove(p);
    }
    
    public void checkPetWOwner(String ownerId) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getOwner().getId().equalsIgnoreCase(ownerId))
                list.get(i).setOwner(null);
        }
    }
  
    
    public void displayAll() {
        for (Pet p : list) {
            p.output();
        }
    }
    
    public void sortById() {
      Collections.sort(list);
    }
       
     
    public boolean isEmpty() {
        if(list.isEmpty())
            return true;
        return false;
    }
    
}
