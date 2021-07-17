/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Storage;

import DTO.Log;
import DTO.Owner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Y545
 */
public class LogList {
    ArrayList<Log> list;

    public LogList() {
        list = new ArrayList<>();
    }
    
    public boolean addLog(Log l) {
        return list.add(l);
    }
    
    public boolean removeLog(Log l) {
        return list.remove(l);
    }

    public void checkPetUseService(int idService) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getService().getId() == idService) {
                list.get(i).getService().setId(0);
                list.get(i).getService().setName(null);
                list.get(i).getService().setPrice(0);
            }
        }
    }

    public void displayAll() {
        
        for (Log log : list) {
            log.output();
        }
    }
    
      public long getTotalMoneyOfPet(int petId) {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPet().getId() == petId)
                sum += list.get(i).getService().getPrice();
        }
        return sum;
    }
      
      public void displayAllTotalMoneyOfAllPet() {
          List<Integer> tmpList = new ArrayList();
          for (int i = 0; i < list.size(); i++) {
              int count = 0;
              for (int j = 0; j < tmpList.size(); j++) {
                  if(tmpList.get(j) == list.get(i).getPet().getId())
                      count++;
              }
              if(count > 0)
                  continue;
              else{
                  System.out.printf("|PET ID: %6d|PET NAME: %15s|TOTAL MONEY: %10d|\n",
                                        list.get(i).getPet().getId(), list.get(i).getPet().getName(),
                                        getTotalMoneyOfPet(list.get(i).getPet().getId()));
                  tmpList.add(list.get(i).getPet().getId());
              }
              
              
          }
      }
    
    public boolean isEmpty() {
        if(list.isEmpty())
            return true;
        return false;
    }
}
