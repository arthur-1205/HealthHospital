package GUI;

import DTO.Log;
import util.MyToys;
import DTO.Owner;
import DTO.Pet;
import DTO.Service;
import Storage.LogList;
import Storage.OwnerList;
import Storage.PetList;
import Storage.ServiceList;

public class Health {

    public static void main(String[] args) {

        PetList petList = new PetList();
        OwnerList ownerList = new OwnerList();
        ServiceList serviceList = new ServiceList();
        LogList logList = new LogList();
        
        Pet p = new Pet();
        int choice = 0;

        System.out.println("==========Welcome to DoanAnh's Pet Service==========");
        do {
            System.out.println("1. Manage Pet list");
            System.out.println("2. Manage Owner list");
            System.out.println("3. Manage Service list");
            System.out.println("4. Establishing relations of Pet and Owner");
            System.out.println("5. Recorded use Services of Pet ");
            System.out.println("6. Quit!!");

            choice = MyToys.getAnInteger("=>>>> Input your Choice: ", "Please input an integer from 1 to 6!!",
                    0, 6);

            switch (choice) {
                case 1:
                    int choice1 = 0;
                    do {
                        System.out.println("1. Add pet");
                        System.out.println("2. Update pet");
                        System.out.println("3. Remove pet");
                        System.out.println("4. Display all pets");
                        System.out.println("5. Exit!!");
                        choice1 = MyToys.getAnInteger("=>>>> Input your choice1: ", "Please input an integer from 1 to 5",
                                0, 5);
                        switch (choice1) {
                            case 1:
                                
                               
                                break;
                            case 2:
                                if (petList.isEmpty()) {
                                    System.out.println(" =>>>> No Pet has been added yet!!"
                                            + " Please input Pet first! <<<<=");
                                    break;
                                }
                                else
                                System.out.println("Input Pet ID need to update: ");
                                int id = MyToys.getAnInteger("Invalid format!");
                                if (petList.updatePet(id)) {
                                    System.out.println("=>>>> Update success! <<<<=");
                                } else {
                                    System.out.println("=>>>> Update fail! Pet ID does not exist! <<<<=");
                                }
                                
                                break;
                            case 3:
                                if(petList.isEmpty()){
                                    System.out.println("=>>>> No Pet has been added yet!"
                                            + "  Please input Pet first!! <<<<=");
                                    break;
                                }
                                System.out.println("Input Pet ID need to remove: ");
                                id = MyToys.getAnInteger("Invalid format!!");
                                if (petList.removePet(id)) {

                                    System.out.println("=>>>> Remove success <<<<=");
                                } else {
                                    System.out.println("=>>>> Remove fail! Service ID does not exist! <<<<=");
                                }
                                break;
                            case 4:
                                if(petList.isEmpty()){
                                    System.out.println("=>>>> No Pet has been added yet!"
                                            + "  Please input Pet first!! <<<<=");
                                    break;
                                }
                                System.out.println("Pet List: ");
                                petList.sortById();
                                petList.displayAll();
                                break;
                        }
                    } while (choice1 <= 4);
                    break;

                case 2:
                    int choice2 = 0;
                    do {
                        System.out.println("1. Add owner");
                        System.out.println("2. Update owner");
                        System.out.println("3. Remove owner");
                        System.out.println("4. Display all owners");
                        System.out.println("5. Exit!!");
                        choice2 = MyToys.getAnInteger("=>>>> Input your choice2: ", "Please input an integer from 1 to 5",
                                0, 5);
                        switch (choice2) {
                            case 1:
                                Owner o = new Owner();
                                o.input();
                                if (ownerList.findOwner(o.getId()) >= 0) {
                                    System.out.println("=>>>> Owner already exists. Add fail!! <<<<=");
                                } else {
                                    ownerList.addOwner(o);
                                    System.out.println("=>>>> Add Owner successfully!! <<<<=");
                                }
                                break;
                            case 2:
                                if (ownerList.isEmpty()) {
                                    System.out.println(" =>>>> No Owner has been added yet!"
                                            + "  Please input Owner first!! <<<<=");
                                } else {
                                    System.out.println("Input Owner ID need to update: ");
                                    String id = MyToys.getAString("Invalid format!");
                                    if (ownerList.updateOwner(id)) {
                                        System.out.println("=>>>> Update Owner succesfully <<<<=");
                                    } else {
                                        System.out.println("=>>>> Update fail! Owner ID does not exist!! <<<<=");
                                    }
                                }
                                break;
                            case 3:
                                if (ownerList.isEmpty()) {
                                    System.out.println(" =>>>> No Owner has been added yet!"
                                            + "  Please input Owner first!! <<<<<=");
                                }
                                System.out.println("Input ID of Owner to remove: ");
                                String id = MyToys.getAString("Invalid format!");
                                if (ownerList.removeOwner(id)) {
                                    petList.checkPetWOwner(id);
                                    System.out.println("=>>>> Remove Owner successfully <<<<=");
                                } else {
                                    System.out.println("=>>>> Remove fail! Owner ID does not exist! <<<<<=");
                                }
                                break;
                            case 4:
                                if (ownerList.isEmpty()) {
                                    System.out.println(" =>>>> No Owner has been added yet!"
                                            + "  Please input Owner first!! <<<<=");
                                    break;
                                }
                                System.out.println("Owner List: ");
                                ownerList.sortById();
                                ownerList.displayAll();
                                break;
                        }

                    } while (choice2 <= 4);
                    break;

                case 3:
                    int choice3 = 0;
                    do {
                        System.out.println("1. Add Service");
                        System.out.println("2. Update Service");
                        System.out.println("3. Remove Service");
                        System.out.println("4. Display all Services");
                        System.out.println("5. Exit!!");
                        choice3 = MyToys.getAnInteger("=>>>> Input your choice3: ",
                                "Please input an integer from 1 to 5",
                                0, 5);
                        switch (choice3) {
                            case 1:
                                Service s = new Service();
                                s.input();
                                if (serviceList.findService(s.getId()) >= 0) {
                                    System.out.println("=>>>> Add fail!! Service is already exist!! <<<<=");
                                } else {
                                    serviceList.addService(s);
                                    System.out.println("=>>>> Add success! <<<<=");
                                }
                                break;
                            case 2:
                                if (serviceList.isEmpty()) {
                                    System.out.println(" =>>>> No service has been added yet!!"
                                            + "  Please input Service firsr!! <<<<=");
                                    break;
                                }
                                System.out.println("Input Service ID need update: ");
                                int nId = MyToys.getAnInteger("Invalid format!");
                                if (serviceList.updateService(nId)) {
                                    System.out.println("=>>>> Update success <<<<=");
                                } else {
                                    System.out.println("=>>>> Update fail! Service id not exist! <<<<=");
                                }
                                break;
                            case 3:
                                if (serviceList.isEmpty()) {
                                    System.out.println(" =>>>> No service has been added yet!!"
                                            + "  Please input Service firsr!! <<<<=");
                                    break;
                                }
                                int id = MyToys.getAnInteger("Input Service ID need to remove: ", "Invalid format!!"); 
                                if (serviceList.removeService(id)) {
                                    logList.checkPetUseService(id);
                                    System.out.println("=>>>> Remove successfully! <<<<=");
                                } else {
                                    System.out.println("=>>>> Remove fail!! Service ID is not exist!! <<<<=");
                                }
                                break;
                            case 4:
                                if (serviceList.isEmpty()) {
                                    System.out.println(" =>>>> No Service has been added yet!!"
                                            + "  Please input Service firsr!! <<<<=");
                                   break;
                                }
                                System.out.println("Service List: ");
                                serviceList.sortByID();
                                serviceList.displayAll();
                                break;
                        }
                    } while (choice3 != 5);

                    break;

                case 4:
                    int choice4 = 0;
                    do {
                        System.out.println("1. Set Ralationship");
                        System.out.println("2. Update Relationship");
                        System.out.println("3. Remove Relationship");
                        System.out.println("4. Display all Relationship");
                        System.out.println("5. Exit!!");
                        choice4 = MyToys.getAnInteger("=>>>> Input your choice4: ",
                                "Please input an integer from 1 to 5",
                                0, 5);

                        switch (choice4) {
                            case 1:
                                    int petid = MyToys.getAnInteger("Input Pet id to set relationship: ","Invalid format!");
                                    String ownerid = MyToys.getAString("Input Owner id to set relationship: ", "Invalid format!!");
                                    p = petList.searchPet(petid);
                                    Owner o = ownerList.searchOwner(ownerid);
                                    if (p.getOwner() != null) {
                                        System.out.println("=>>> Pet already has Owner!! <<<=");
                                    } else if (p != null && o != null) {
                                        p.setOwner(o);
                                        System.out.println("=>>>> Set relationship successfully <<<<=");
                                    } else {
                                        System.out.println("=>>>> Pet or Owner id is invalid <<<<=");
                                    }
                                break;
                            case 2:
                                if(petList.isEmpty()){
                                    System.out.println(" =>>>>> No relationship has been added yet!!"
                                    + " Please set relationship first!! <<<<=");
                                    break;
                                }
                                petid = MyToys.getAnInteger("Input Pet id need to update Owner: ", "Invalid format!!");
                                p = petList.searchPet(petid);
                                if (p != null) {
                                    String oId = MyToys.getAString("Input Owner Id that you want to change: ","Invalid format!");
                                    o = ownerList.searchOwner(oId);
                                    if (o != null) {
                                        p.setOwner(o);
                                        System.out.println("=>>>> Update realationship successfully <<<<=");
                                    } else {
                                        System.out.println("=>>>> Owner is not exist!! Update fail!! <<<<=");
                                    }

                                } else {
                                    System.out.println("=>>>> Pet is not exist!! Update fail!! <<<<=");
                                }
                                break;

                            case 3:
                                if(petList.isEmpty()){
                                    System.out.println(" =>>>>> No relationship has been added yet!!"
                                    + " Please set relationship first!! <<<<=");
                                    break;
                                }
                                petid = MyToys.getAnInteger("Input Pet Id to remove relationship: ","Invalid format!!");
                                p = petList.searchPet(petid);
                                if (p != null && p.getOwner() != null) {
                                    p.setOwner(null);
                                    System.out.println("=>>>> Remove relationship successfully <<<<=");
                                } else {
                                    System.out.println("=>>>> Pet id does not exist!! Remove fail! <<<<=");
                                }
                                break;
                            case 4:
                                if(petList.isEmpty()){
                                    System.out.println(" =>>>>> No relationship has been added yet!!"
                                    + " Please set relationship first!! <<<<=");
                                    break;
                                }
                                petList.displayAll();
                                break;

                        }
                    } while (choice4 != 5);
                    break;
                    
                    
                    
                case 5:
                    int choice5 = 0;
                    do {
                        System.out.println("1. Add log");
                        System.out.println("2. Update log");
                        System.out.println("3. Remove log");
                        System.out.println("4. Display all logs");
                        System.out.println("5. Display Total Money of all Pets");
                        System.out.println("6. Exit");
                        choice5 = MyToys.getAnInteger("=>>>> Input choice5: ",
                                "Please input an integer from 1 to 5!!",
                                0, 6);
                        switch (choice5) {
                            case 1:
                                int petId = MyToys.getAnInteger("Input Pet ID to use Service: ", "Invalid format!!");
                                p = petList.searchPet(petId);
                                if (p == null) {
                                    System.out.println("=>>>> Not found PetID! <<<<=");
                                    break;
                                }
                                int serviceId = MyToys.getAnInteger("Input Service ID: ", "Invalid format!!");
                                Service s = serviceList.searchService(serviceId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                logList.addLog(new Log(p, s));
                                System.out.println("Record succesfully!");

                                break;
                            case 2:
                                if (logList.isEmpty()) {
                                    System.out.println(" =>>>>> No Log has been added yet!!"
                                            + "  Please input Log firsr!! <<<<<=");
                                    break;
                                }
                                petId = MyToys.getAnInteger("Input Pet ID need to update Log: ", "Invalid format!!");
                                p = petList.searchPet(petId);
                                if (p == null) {
                                    System.out.println("=>>>> Not found PetID! <<<<=");
                                    break;
                                }
                                serviceId = MyToys.getAnInteger("Input Service ID need to update Log: ", "Invalid format!!");
                                s = serviceList.searchService(serviceId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                int newServiceId = MyToys.getAnInteger("Input new Service ID: ", "Invalid format!!");
                                Service ns = serviceList.searchService(newServiceId);
                                if (ns == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                s = ns;
                                System.out.println("=>>>> Update Log successfully! <<<<=");

                                break;

                            case 3:
                                if (logList.isEmpty()) {
                                    System.out.println(" =>>>>> No Log has been added yet!!"
                                            + "  Please input Log firsr!! <<<<<=");
                                    break;
                                }
                                petId = MyToys.getAnInteger("Input Pet ID to remove Log: ", "Invalid format!!");
                                p = petList.searchPet(petId);
                                if (p == null) {
                                    System.out.println("=>>>> Not found PetID! <<<<=");
                                    break;
                                }
                                serviceId = MyToys.getAnInteger("Input Service ID to remove Log: ", "Invalid format!!");
                                s = serviceList.searchService(serviceId);
                                if (s == null) {
                                    System.out.println("=>>>> Not found SeviceID!! <<<<=");
                                    break;
                                }
                                logList.removeLog(new Log(p,s));
                                System.out.println("=>>>> Remove successfully!! <<<<=");
                                break;
                            case 4:
                                if(logList.isEmpty()) {
                                     System.out.println(" =>>>> No Log has been added yet!!"
                                            + "  Please input Log firsr!! <<<<=");
                                     break;
                                }
                                System.out.println("Pet's service usage information : ");
                                logList.displayAll();
                                break;
                                
                            case 5:
                                if(logList.isEmpty()) {
                                     System.out.println(" =>>>> No Log has been added yet!!"
                                            + "  Please input Log firsr!! <<<<=");
                                     break;
                                }
                                System.out.println("Total Money of Pet: ");
                                logList.displayAllTotalMoneyOfAllPet();
                                break;
                        }
                    } while (choice5 != 6);
                    break;

                case 6:
                    System.out.println("========= Thanks for using!! ===========");
                    break;
            }
        } while (choice != 6);
    }
}
