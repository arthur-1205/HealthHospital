
package DTO;

import util.MyToys;

public class Owner implements Comparable<Owner>{
    private String id;
    private String name;
    private String address;

    public Owner() {
        id = "";
        name = "";
        address = "";
    }

    public Owner(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void input() {
       id = MyToys.getAString("Input owner id: ", "Invalid format!");
       name = MyToys.getAString("Input owner name: ", "Invalid format!");
       address = MyToys.getAString("Input owner address: ", "Invalid format!");
    }
    
    public void output() {
        System.out.printf(" |OWNER   |ID: %10s|NAME: %10s|ADDRESS: %10s|\n",
                            id, name.toUpperCase(), address.toUpperCase());
    }   

    @Override
    public int compareTo(Owner o) {
        if(id.compareToIgnoreCase(o.getId()) == 1) return 1;
        else if(id.compareToIgnoreCase(o.getId()) == -1) return -1;
        return 0;
    }
}
