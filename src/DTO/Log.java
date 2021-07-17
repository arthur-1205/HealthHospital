/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Y545
 */
public class Log {
    Pet pet;           
    Service service;
    long totalMoney;

    public Log() {
        pet = null;
        service = null;
        totalMoney = 0;
    }

    public Log(Pet pet, Service service) {
        this.pet = pet;
        this.service = service;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
    
    public void output() {
        if(pet != null && this.service != null) {
            System.out.printf("|PET ID: %4d|PET NAME: %10s|SERVICE ID: %4d|SERVICE NAME: %15s|PRICE: %13d|\n",
                                    pet.getId(), pet.getName(), service.getId(), service.getName(), service.getPrice());
            
        }
    }
    
  
    
    
}
