package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.KalyanBazaar;
import org.jaanDeveloper.loading.model.MainBazaar;
import org.jaanDeveloper.loading.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService {
    @Autowired
    private MainRepository mainRepository;

    public List<MainBazaar> mainGetAllAmount()
    {
        List<MainBazaar> amounts;
        amounts = mainRepository.findAll();
        return amounts;
    }

    public void mainGetByAddData(MainBazaar number) {
        mainRepository.save(number);
    }

    public void mainDeleteById(int id) {
        mainRepository.deleteById(id);
    }

    public MainBazaar mainUpdateData(int id) {

        MainBazaar num=null;
        List<MainBazaar> playNumberList=mainRepository.findAll();

        for (MainBazaar n:playNumberList)
        {
            if (n.getLoadingId()==id)
            {
                num=n;
            }
        }
        return num;
    }

    public void mainUpdateNewPlayNumber(MainBazaar playNumber)
    {
        mainRepository.save(playNumber);
    }

    public void mainClearAllDataOfDatabase()
    {
        mainRepository.deleteAll();
    }

    public List<Integer> mainCheckLoad()
    {
        List<Integer> list=mainRepository.getAllNumbers();
        return list;
    }

    public Map<Integer,Long> mainGetTotalAmount(List<Integer> playList) {
        Map<Integer,Long>amount=new HashMap<>();
        for (int i=0;i<playList.size();i++)
        {
            int num=playList.get(i);
            Long amt=mainRepository.calculateAmount(Collections.singletonList(playList.get(i)));
            amount.put(num,amt);
        }
        return amount;
    }

    // Get main Ascending //

    public List<Integer> mainGetAllAscendingNumber()
    {
        return mainRepository.mainGetAscendingAllNumbers();
    }

    public Map<Integer,Long> mainGetSum0(ArrayList list0) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list0.iterator();
        while (itr.hasNext()) {
            int num0 = (int) itr.next();
            Long amt0 =mainRepository.mainGetSum0(num0);
            amount.put(num0,amt0);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum1(ArrayList list1) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list1.iterator();
        while (itr.hasNext()) {
            int num1 = (int) itr.next();
            Long amt1 =mainRepository.mainGetSum1(num1);
            amount.put(num1,amt1);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum2(ArrayList list2) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list2.iterator();
        while (itr.hasNext()) {
            int num2 = (int) itr.next();
            Long amt2 =mainRepository.mainGetSum2(num2);
            amount.put(num2,amt2);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum3(ArrayList list3) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list3.iterator();
        while (itr.hasNext()) {
            int num3 = (int) itr.next();
            Long amt3 =mainRepository.mainGetSum3(num3);
            amount.put(num3,amt3);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum4(ArrayList list4) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list4.iterator();
        while (itr.hasNext()) {
            int num4 = (int) itr.next();
            Long amt4 =mainRepository.mainGetSum4(num4);
            amount.put(num4,amt4);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum5(ArrayList list5) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list5.iterator();
        while (itr.hasNext()) {
            int num5 = (int) itr.next();
            Long amt5 =mainRepository.mainGetSum5(num5);
            amount.put(num5,amt5);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum6(ArrayList list6) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list6.iterator();
        while (itr.hasNext()) {
            int num6 = (int) itr.next();
            Long amt6 =mainRepository.mainGetSum6(num6);
            amount.put(num6,amt6);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum7(ArrayList list7) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list7.iterator();
        while (itr.hasNext()) {
            int num7 = (int) itr.next();
            Long amt7 =mainRepository.mainGetSum7(num7);
            amount.put(num7,amt7);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum8(ArrayList list8) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list8.iterator();
        while (itr.hasNext()) {
            int num8 = (int) itr.next();
            Long amt8 =mainRepository.mainGetSum8(num8);
            amount.put(num8,amt8);
        }
        return amount;
    }

    public Map<Integer,Long> mainGetSum9(ArrayList list9) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list9.iterator();
        while (itr.hasNext()) {
            int num9 = (int) itr.next();
            Long amt9 =mainRepository.mainGetSum9(num9);
            amount.put(num9,amt9);
        }
        return amount;
    }

}
