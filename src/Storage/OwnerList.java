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
    Pet p = new Pet();

    public OwnerList() {
        list = new ArrayList<>();
    }

    public void addOwner(Owner o) {
        list.add(o);
    }

    public int findOwner(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Owner searchOwner(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().compareToIgnoreCase(id) == 0) {
                return list.get(i);
            }
        }
        return null;
    }

    public boolean updateOwner(String id) {
        Owner o = searchOwner(id);
        if (o == null) {
            return false;
        }
        o.setId(MyToys.getAString("Input new ID: ", "Invalid format!!"));
        o.setName(MyToys.getAString("Input new Name: ", "Invalid format!!"));
        o.setAddress(MyToys.getAString("Input new Address: ", "Invalid format!!"));
        return true;
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
