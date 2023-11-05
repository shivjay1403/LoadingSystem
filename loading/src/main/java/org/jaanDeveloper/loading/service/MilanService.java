package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.MainBazaar;
import org.jaanDeveloper.loading.model.MilanDayBazaar;
import org.jaanDeveloper.loading.repository.MainRepository;
import org.jaanDeveloper.loading.repository.MilanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MilanService {
    @Autowired
    private MilanRepository milanRepository;

    public List<MilanDayBazaar> milanGetAllAmount()
    {
        List<MilanDayBazaar> amounts;
        amounts = milanRepository.findAll();
        return amounts;
    }

    public void milanGetByAddData(MilanDayBazaar number) {
        milanRepository.save(number);
    }

    public void milanDeleteById(int id) {
        milanRepository.deleteById(id);
    }

    public MilanDayBazaar milanUpdateData(int id) {

        MilanDayBazaar num=null;
        List<MilanDayBazaar> playNumberList=milanRepository.findAll();

        for (MilanDayBazaar n:playNumberList)
        {
            if (n.getLoadingId()==id)
            {
                num=n;
            }
        }
        return num;
    }

    public void milanUpdateNewPlayNumber(MilanDayBazaar playNumber)
    {
        milanRepository.save(playNumber);
    }

    public void milanClearAllDataOfDatabase()
    {
        milanRepository.deleteAll();
    }

    public List<Integer> milanCheckLoad()
    {
        List<Integer> list=milanRepository.getAllNumbers();
        return list;
    }

    public Map<Integer,Long> milanGetTotalAmount(List<Integer> playList) {
        Map<Integer,Long>amount=new HashMap<>();
        for (int i=0;i<playList.size();i++)
        {
            int num=playList.get(i);
            Long amt=milanRepository.calculateAmount(Collections.singletonList(playList.get(i)));
            amount.put(num,amt);
        }
        return amount;
    }


    // Get Milan Ascending //

    public List<Integer> milanGetAllAscendingNumber()
    {
        return milanRepository.milanGetAscendingAllNumbers();
    }

    public Map<Integer,Long> milanGetSum0(ArrayList list0) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list0.iterator();
        while (itr.hasNext()) {
            int num0 = (int) itr.next();
            Long amt0 =milanRepository.milanGetSum0(num0);
            amount.put(num0,amt0);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum1(ArrayList list1) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list1.iterator();
        while (itr.hasNext()) {
            int num1 = (int) itr.next();
            Long amt1 =milanRepository.milanGetSum1(num1);
            amount.put(num1,amt1);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum2(ArrayList list2) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list2.iterator();
        while (itr.hasNext()) {
            int num2 = (int) itr.next();
            Long amt2 =milanRepository.milanGetSum2(num2);
            amount.put(num2,amt2);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum3(ArrayList list3) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list3.iterator();
        while (itr.hasNext()) {
            int num3 = (int) itr.next();
            Long amt3 =milanRepository.milanGetSum3(num3);
            amount.put(num3,amt3);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum4(ArrayList list4) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list4.iterator();
        while (itr.hasNext()) {
            int num4 = (int) itr.next();
            Long amt4 =milanRepository.milanGetSum4(num4);
            amount.put(num4,amt4);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum5(ArrayList list5) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list5.iterator();
        while (itr.hasNext()) {
            int num5 = (int) itr.next();
            Long amt5 =milanRepository.milanGetSum5(num5);
            amount.put(num5,amt5);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum6(ArrayList list6) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list6.iterator();
        while (itr.hasNext()) {
            int num6 = (int) itr.next();
            Long amt6 =milanRepository.milanGetSum6(num6);
            amount.put(num6,amt6);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum7(ArrayList list7) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list7.iterator();
        while (itr.hasNext()) {
            int num7 = (int) itr.next();
            Long amt7 =milanRepository.milanGetSum7(num7);
            amount.put(num7,amt7);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum8(ArrayList list8) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list8.iterator();
        while (itr.hasNext()) {
            int num8 = (int) itr.next();
            Long amt8 =milanRepository.milanGetSum8(num8);
            amount.put(num8,amt8);
        }
        return amount;
    }

    public Map<Integer,Long> milanGetSum9(ArrayList list9) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list9.iterator();
        while (itr.hasNext()) {
            int num9 = (int) itr.next();
            Long amt9 =milanRepository.milanGetSum9(num9);
            amount.put(num9,amt9);
        }
        return amount;
    }
}
