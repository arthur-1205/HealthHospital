/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import util.MyToys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Pet implements Comparable<Pet>{

    private int id;
    private String name;
    private String birthday;
    private String gender;
    private Owner owner;
    private Service service;
    private String idOwner;
    private String nameOwner;
  

    public Pet() {
        id = 0;
        name = "";
        birthday = "";
        gender = "";
    }

    public Pet(int id, String name, String birthday, String gender, Owner owner, Service service) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
        this.service = service;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getIdOwner() {
        if(this.owner == null)
            idOwner = null;   
        else
           idOwner = String.valueOf(this.owner.getId());
        return idOwner;                  
    }
    
    public String getNameOwner() {
        if(this.owner == null)
            nameOwner = null;   
        else
           nameOwner = String.valueOf(this.owner.getName());
        return nameOwner;                  
    }
    

    public void input() {
        id = MyToys.getAnInteger("Input Pet's ID: ", "Invalid format!!"); 
        name = MyToys.getAString("Input Pet's name: ", "Invalid format!!");  
        birthday = MyToys.getDate("Input Pet's birthday: ", "Invalid format! Just accept format dd/MM/yyyy",
                                    "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
        gender = MyToys.getMaleOrFemale("Input Pet's gender(Male/Female): ", "Invalid format!! Please input male or female!!");
    }
    
    public void output() {
        System.out.printf("PET     |ID: %4d|NAME: %10s|BIRTHDAY: %10s|GENDER: %10s|OWNER ID: %10s|OWNER NAME: %10s|\n",
                            id, name.toUpperCase(), birthday, gender.toUpperCase(), getIdOwner(), getNameOwner());
    }

    public void outputV2() {
        System.out.printf("PET     |ID: %4d|NAME: %10s|BIRTHDAY: %10s|GENDER: %10s| =>>> ",
                            id, name.toUpperCase(), birthday, gender.toUpperCase());
    }
    

    @Override
    public int compareTo(Pet o) {
        if(id > o.getId()) return 1;
        else if(id < o.getId()) return -1;
        return 0; 
    }

}
