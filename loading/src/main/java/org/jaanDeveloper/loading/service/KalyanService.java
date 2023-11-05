package org.jaanDeveloper.loading.service;

import org.jaanDeveloper.loading.model.KalyanBazaar;
import org.jaanDeveloper.loading.repository.KalyanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class KalyanService
{
    @Autowired
    private KalyanRepository repository;

    public List<KalyanBazaar> kalyanGetAllAmount()
    {
        List<KalyanBazaar> amounts;
        amounts = repository.findAll();
        return amounts;
    }

    public void kalyanGetByAddData(KalyanBazaar number) {
        repository.save(number);
    }

    public void kalyanDeleteById(int id) {
        repository.deleteById(id);
    }

    public KalyanBazaar kalyanUpdateData(int id) {

        KalyanBazaar num=null;
        List<KalyanBazaar> playNumberList=repository.findAll();

        for (KalyanBazaar n:playNumberList)
        {
            if (n.getLoadingId()==id)
            {
                num=n;
            }
        }
        return num;
    }

    public void kalyanUpdateNewPlayNumber(KalyanBazaar playNumber)
    {
        repository.save(playNumber);
    }

    public void kalyanClearAllDataOfDatabase()
    {
        repository.deleteAll();
    }

    public List<String> kalyanCheckLoad()
    {
        List<String> list=repository.getAllNumbers();
        return list;
    }

    public Map<Integer,Long> kalyanGetTotalAmount(List<String> playList) {
        Map<Integer,Long>amount=new HashMap<>();
        for (int i=0;i<playList.size();i++)
        {
            int num= Integer.parseInt(playList.get(i));
            Long amt=repository.calculateAmount(Collections.singletonList(Integer.valueOf(playList.get(i))));
            amount.put(num,amt);
        }
        return amount;
    }

    public List<Integer> kalyanGetAllAscendingNumber()
    {

        return repository.kalyanGetAscendingAllNumbers();
    }

    public Map<Integer,Long> kalyanGetSum0(ArrayList list0) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list0.iterator();
        while (itr.hasNext()) {
            int num0 = (int) itr.next();
           Long amt0 =repository.kalyanGetSum0(num0);
            amount.put(num0,amt0);
        }

        return amount;
    }

    public long getMax(List<String> playList1) {
        long max=0;
        Iterator itr= playList1.iterator();
        while (itr.hasNext())
        {
            int num0 = Integer.parseInt( String.valueOf(itr.next()));
            max=repository.getMaxSum0(num0);
        }
        return max;
    }

    public Map<Integer,Long> kalyanGetSum1(ArrayList list1) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list1.iterator();
        while (itr.hasNext()) {
            int num1 = (int) itr.next();
            Long amt1 =repository.kalyanGetSum1(num1);
            amount.put(num1,amt1);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum2(ArrayList list2) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list2.iterator();
        while (itr.hasNext()) {
            int num2 = (int) itr.next();
            Long amt2 =repository.kalyanGetSum2(num2);
            amount.put(num2,amt2);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum3(ArrayList list3) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list3.iterator();
        while (itr.hasNext()) {
            int num3 = (int) itr.next();
            Long amt3 =repository.kalyanGetSum3(num3);
            amount.put(num3,amt3);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum4(ArrayList list4) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list4.iterator();
        while (itr.hasNext()) {
            int num4 = (int) itr.next();
            Long amt4 =repository.kalyanGetSum4(num4);
            amount.put(num4,amt4);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum5(ArrayList list5) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list5.iterator();
        while (itr.hasNext()) {
            int num5 = (int) itr.next();
            Long amt5 =repository.kalyanGetSum5(num5);
            amount.put(num5,amt5);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum6(ArrayList list6) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list6.iterator();
        while (itr.hasNext()) {
            int num6 = (int) itr.next();
            Long amt6 =repository.kalyanGetSum6(num6);
            amount.put(num6,amt6);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum7(ArrayList list7) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list7.iterator();
        while (itr.hasNext()) {
            int num7 = (int) itr.next();
            Long amt7 =repository.kalyanGetSum7(num7);
            amount.put(num7,amt7);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum8(ArrayList list8) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list8.iterator();
        while (itr.hasNext()) {
            int num8 = (int) itr.next();
            Long amt8 =repository.kalyanGetSum8(num8);
            amount.put(num8,amt8);
        }
        return amount;
    }

    public Map<Integer,Long> kalyanGetSum9(ArrayList list9) {
        Map<Integer,Long>amount=new HashMap<>();
        Iterator itr= list9.iterator();
        while (itr.hasNext()) {
            int num9 = (int) itr.next();
            Long amt9 =repository.kalyanGetSum9(num9);
            amount.put(num9,amt9);
        }
        return amount;
    }

    public long getMin(List<String> playList1) {
        long min=0;
        Iterator itr= playList1.iterator();
        while (itr.hasNext())
        {
            int num0 = Integer.parseInt( String.valueOf(itr.next()));
            min=repository.getMinSum0(num0);
        }
        return min;
    }
}
