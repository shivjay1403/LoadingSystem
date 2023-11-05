package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.RajdhaniBazaar;
import org.jaanDeveloper.loading.model.TimeBazaar;
import org.jaanDeveloper.loading.repository.RajdhaniRepository;
import org.jaanDeveloper.loading.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimeService {
    @Autowired
    private TimeRepository timeRepository;

    public List<TimeBazaar> timeGetAllAmount()
    {
        List<TimeBazaar> amounts;
        amounts = timeRepository.findAll();
        return amounts;
    }

    public void timeGetByAddData(TimeBazaar number) {
        timeRepository.save(number);
    }

    public void timeDeleteById(int id) {
        timeRepository.deleteById(id);
    }

    public TimeBazaar timeUpdateData(int id) {

        TimeBazaar num=null;
        List<TimeBazaar> playNumberList=timeRepository.findAll();

        for (TimeBazaar n:playNumberList)
        {
            if (n.getLoadingId()==id)
            {
                num=n;
            }
        }
        return num;
    }

    public void timeUpdateNewPlayNumber(TimeBazaar playNumber)
    {
        timeRepository.save(playNumber);
    }

    public void timeClearAllDataOfDatabase()
    {
        timeRepository.deleteAll();
    }

    public List<Integer> timeCheckLoad()
    {
        List<Integer> list=timeRepository.getAllNumbers();
        return list;
    }

    public Map<Integer,Long> timeGetTotalAmount(List<Integer> playList) {
        Map<Integer,Long>amount=new HashMap<>();
        for (int i=0;i<playList.size();i++)
        {
            int num=playList.get(i);
            Long amt=timeRepository.calculateAmount(Collections.singletonList(playList.get(i)));
            amount.put(num,amt);
        }
        return amount;
    }

    // Get time Ascending //

    public List<Integer> timeGetAllAscendingNumber()
    {
        return timeRepository.timeGetAscendingAllNumbers();
    }

    public Map<Integer,Long> timeGetSum0(ArrayList list0) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list0.iterator();
        while (itr.hasNext()) {
            int num0 = (int) itr.next();
            Long amt0 =timeRepository.timeGetSum0(num0);
            amount.put(num0,amt0);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum1(ArrayList list1) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list1.iterator();
        while (itr.hasNext()) {
            int num1 = (int) itr.next();
            Long amt1 =timeRepository.timeGetSum1(num1);
            amount.put(num1,amt1);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum2(ArrayList list2) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list2.iterator();
        while (itr.hasNext()) {
            int num2 = (int) itr.next();
            Long amt2 =timeRepository.timeGetSum2(num2);
            amount.put(num2,amt2);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum3(ArrayList list3) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list3.iterator();
        while (itr.hasNext()) {
            int num3 = (int) itr.next();
            Long amt3 =timeRepository.timeGetSum3(num3);
            amount.put(num3,amt3);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum4(ArrayList list4) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list4.iterator();
        while (itr.hasNext()) {
            int num4 = (int) itr.next();
            Long amt4 =timeRepository.timeGetSum4(num4);
            amount.put(num4,amt4);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum5(ArrayList list5) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list5.iterator();
        while (itr.hasNext()) {
            int num5 = (int) itr.next();
            Long amt5 =timeRepository.timeGetSum5(num5);
            amount.put(num5,amt5);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum6(ArrayList list6) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list6.iterator();
        while (itr.hasNext()) {
            int num6 = (int) itr.next();
            Long amt6 =timeRepository.timeGetSum6(num6);
            amount.put(num6,amt6);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum7(ArrayList list7) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list7.iterator();
        while (itr.hasNext()) {
            int num7 = (int) itr.next();
            Long amt7 =timeRepository.timeGetSum7(num7);
            amount.put(num7,amt7);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum8(ArrayList list8) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list8.iterator();
        while (itr.hasNext()) {
            int num8 = (int) itr.next();
            Long amt8 =timeRepository.timeGetSum8(num8);
            amount.put(num8,amt8);
        }
        return amount;
    }

    public Map<Integer,Long> timeGetSum9(ArrayList list9) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list9.iterator();
        while (itr.hasNext()) {
            int num9 = (int) itr.next();
            Long amt9 =timeRepository.timeGetSum9(num9);
            amount.put(num9,amt9);
        }
        return amount;
    }
}
