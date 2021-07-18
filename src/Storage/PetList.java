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

    public void addPet() {  
       Pet p;
       int id, pos;
       String name, birthday, gender;
       do{
           id = MyToys.getAnInteger("Input Pet id: ", "Pet id must be a postive integer!!", 0);
           pos = findPet(id);
           p = searchPet(id);
           if(pos >= 0) 
               System.out.println("Pet id already exist!! Please input again!");
           }while(pos != -1);
           name = MyToys.getAString("Input Pet name: ", "Pet name is required!!");
           birthday = MyToys.getDate("Input Pet birthday(dd/MM/yyyy): ", "Please follow format dd/MM/yyy!!",
                   "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
           gender = MyToys.getMaleOrFemale("Input Pet gender(male or female):", "Please input male or female!");
           
           list.add(new Pet(id, name, birthday, gender, null, null));
           System.out.println("=>>> Add Pet successfully!! <<<=");
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
    
    public void updatePet() {
        Pet p;
        int pos, id;
        if (list.isEmpty()) {
            System.out.println("Pet List is empty!!");
            return;
        }
        do {
            id = MyToys.getAnInteger("Input Pet ID to update: ", "Input a possitive integer!", 0);
            pos = findPet(id);
            p = searchPet(id);
            if (pos == -1) {
                System.out.println("Pet id not exist!! Please input again!");
            }
        } while (pos == -1);
        
        p.setName(MyToys.getAString("Input new Pet name: ", "Pet name is required!!"));
        p.setBirthday(MyToys.getDate("Input new Pet birthday(dd/MM/yyyy): ", "Please follow format dd/MM/yyy!!",
                   "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)"));
        p.setGender(MyToys.getMaleOrFemale("Input new Pet gender(male or female): ", "Please input male or female!"));
        System.out.println("=>>> Update Pet successfully <<<=");
        p.output();
    }
    
    public void removePet() {
        if (list.isEmpty()) {
            System.out.println("=>>>> No Pet has been added yet!"
                    + "  Please input Pet first!! <<<<=");
            return;
        }
        int id = MyToys.getAnInteger("Input Pet ID need to remove: ", "Invalid format!!", 0);
        Pet p = searchPet(id);
        if(p != null){
            list.remove(p);
            System.out.println("=>>>> Remove success <<<<=");          
        }else {
            System.out.println("=>>>> Remove fail! Pet ID is not exist! <<<<=");
        }
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
