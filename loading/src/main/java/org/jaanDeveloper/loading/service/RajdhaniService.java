package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.MilanDayBazaar;
import org.jaanDeveloper.loading.model.RajdhaniBazaar;
import org.jaanDeveloper.loading.repository.MilanRepository;
import org.jaanDeveloper.loading.repository.RajdhaniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RajdhaniService {
    @Autowired
    private RajdhaniRepository rajdhaniRepository;

    public List<RajdhaniBazaar> rajdhaniGetAllAmount()
    {
        List<RajdhaniBazaar> amounts;
        amounts = rajdhaniRepository.findAll();
        return amounts;
    }

    public void rajdhaniGetByAddData(RajdhaniBazaar number) {
        rajdhaniRepository.save(number);
    }

    public void rajdhaniDeleteById(int id) {
        rajdhaniRepository.deleteById(id);
    }

    public RajdhaniBazaar rajdhaniUpdateData(int id) {

        RajdhaniBazaar num=null;
        List<RajdhaniBazaar> playNumberList=rajdhaniRepository.findAll();

        for (RajdhaniBazaar n:playNumberList)
        {
            if (n.getLoadingId()==id)
            {
                num=n;
            }
        }
        return num;
    }

    public void rajdhaniUpdateNewPlayNumber(RajdhaniBazaar playNumber)
    {
        rajdhaniRepository.save(playNumber);
    }

    public void rajdhaniClearAllDataOfDatabase()
    {
        rajdhaniRepository.deleteAll();
    }

    public List<Integer> rajdhaniCheckLoad()
    {
        List<Integer> list=rajdhaniRepository.getAllNumbers();
        return list;
    }

    public Map<Integer,Long> rajdhaniGetTotalAmount(List<Integer> playList) {
        Map<Integer,Long>amount=new HashMap<>();
        for (int i=0;i<playList.size();i++)
        {
            int num=playList.get(i);
            Long amt=rajdhaniRepository.calculateAmount(Collections.singletonList(playList.get(i)));
            amount.put(num,amt);
        }
        return amount;
    }



    // Get Milan Ascending //

    public List<Integer> rajdhaniGetAllAscendingNumber()
    {
        return rajdhaniRepository.rajdhaniGetAscendingAllNumbers();
    }

    public Map<Integer,Long> rajdhaniGetSum0(ArrayList list0) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list0.iterator();
        while (itr.hasNext()) {
            int num0 = (int) itr.next();
            Long amt0 =rajdhaniRepository.rajdhaniGetSum0(num0);
            amount.put(num0,amt0);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum1(ArrayList list1) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list1.iterator();
        while (itr.hasNext()) {
            int num1 = (int) itr.next();
            Long amt1 =rajdhaniRepository.rajdhaniGetSum1(num1);
            amount.put(num1,amt1);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum2(ArrayList list2) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list2.iterator();
        while (itr.hasNext()) {
            int num2 = (int) itr.next();
            Long amt2 =rajdhaniRepository.rajdhaniGetSum2(num2);
            amount.put(num2,amt2);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum3(ArrayList list3) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list3.iterator();
        while (itr.hasNext()) {
            int num3 = (int) itr.next();
            Long amt3 =rajdhaniRepository.rajdhaniGetSum3(num3);
            amount.put(num3,amt3);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum4(ArrayList list4) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list4.iterator();
        while (itr.hasNext()) {
            int num4 = (int) itr.next();
            Long amt4 =rajdhaniRepository.rajdhaniGetSum4(num4);
            amount.put(num4,amt4);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum5(ArrayList list5) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list5.iterator();
        while (itr.hasNext()) {
            int num5 = (int) itr.next();
            Long amt5 =rajdhaniRepository.rajdhaniGetSum5(num5);
            amount.put(num5,amt5);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum6(ArrayList list6) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list6.iterator();
        while (itr.hasNext()) {
            int num6 = (int) itr.next();
            Long amt6 =rajdhaniRepository.rajdhaniGetSum6(num6);
            amount.put(num6,amt6);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum7(ArrayList list7) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list7.iterator();
        while (itr.hasNext()) {
            int num7 = (int) itr.next();
            Long amt7 =rajdhaniRepository.rajdhaniGetSum7(num7);
            amount.put(num7,amt7);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum8(ArrayList list8) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list8.iterator();
        while (itr.hasNext()) {
            int num8 = (int) itr.next();
            Long amt8 =rajdhaniRepository.rajdhaniGetSum8(num8);
            amount.put(num8,amt8);
        }
        return amount;
    }

    public Map<Integer,Long> rajdhaniGetSum9(ArrayList list9) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list9.iterator();
        while (itr.hasNext()) {
            int num9 = (int) itr.next();
            Long amt9 =rajdhaniRepository.rajdhaniGetSum9(num9);
            amount.put(num9,amt9);
        }
        return amount;
    }
}
