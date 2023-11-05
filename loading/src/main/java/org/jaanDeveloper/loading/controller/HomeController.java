package org.jaanDeveloper.loading.controller;

import jakarta.servlet.http.HttpSession;
import org.jaanDeveloper.loading.model.*;
import org.jaanDeveloper.loading.repository.UserRegisterRepository;
import org.jaanDeveloper.loading.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.*;


@Controller
public class HomeController{
    ArrayList<Integer> integerArrayList=new ArrayList<>();
    @Autowired
    private KalyanService kService;
    @Autowired
    private MainService mainService;
    @Autowired
    private MilanService milanService;
    @Autowired
    private RajdhaniService rajdhaniService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private ContactUsService contactUsService;
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserRegisterRepository userRegisterRepository;

    @GetMapping("/")
    public String getHomePage(Model model)
    {
        return "home";
    }


    @GetMapping("/user/contactUs")
    public String getContactPage(Model model)
    {
        ContactUs contactUs=new ContactUs();
        model.addAttribute("conInfo",contactUs);
        return "contact";
    }
    @GetMapping("/user/conInfo")
    public String contactInfo(ContactUs conInfo,Model model)
    {
        boolean num =contactUsService.contactUsGetByAddData(conInfo);
        System.out.println(num);

        if (num==true) {
            model.addAttribute("success","Information Stored Successful");
        }else
        {
            model.addAttribute("fail","Information NOT STORED");
        }
        return "redirect:/";
    }

    @GetMapping("/gamePage")
    public String gamePage()
    {
        return "gamePage";
    }

    // kalyan coding starts //
    @GetMapping("/admin/kalyanPlay")
    public String kalyanDisplayAllPlay(Model model)
    {
        model.addAttribute("plays",kService.kalyanGetAllAmount());
        return "kalyanDisplayAll";
    }
    @GetMapping("/KalyanLetsPlay")
    public String letsPlay(Model model)
    {
        KalyanBazaar num=new KalyanBazaar();
        model.addAttribute("plays",num);
        return "/KalyanLetsPlay";
    }
    @GetMapping("/kalyanSubmitData")
    public String getByAddData(KalyanBazaar number,Model model)
    {
       int num= Integer.parseInt(String.valueOf(number.getLoadNum()));
       float amt=number.getPlayAmt();
        kService.kalyanGetByAddData(number);
        model.addAttribute("num",number);
        model.addAttribute("amt",amt);
        return "redirect:/KalyanLetsPlay";
    }
    @GetMapping("/deleteRecord/{id}")
    public String deleteMobile(@PathVariable(value = "id") int id,Model model)
    {
        kService.kalyanDeleteById(id);
        return "redirect:/kalyanPlay";

    }

    @GetMapping("/updateRecord/{id}")
    public String updatePlayNumber(@PathVariable(value = "id") int id,Model model)
    {
       model.addAttribute("plays",kService.kalyanUpdateData(id));
        return "kalyanUpdateForm";

    }
    @GetMapping("/kalyanSubmitNewData")
    public String updatePlayNumberInfo(KalyanBazaar playNumber)
    {
        kService.kalyanUpdateNewPlayNumber(playNumber);
        return "redirect:/kalyanPlay";
    }
    @GetMapping("/admin/kalyanClearData")
    public String kalyanClearAllData()
    {
        kService.kalyanClearAllDataOfDatabase();
        return "redirect:/kalyanPlay";
    }
    @GetMapping("/admin/kalyanCheckLoad")
    public String checkLoad(Model model)
    {
        List<String> playList =kService.kalyanCheckLoad();

    HashMap totalAmount= (HashMap) kService.kalyanGetTotalAmount(playList);
    ArrayList value=new ArrayList<>();
        System.out.println("Loading of Kalyan Bazaar");
        for(Object m : totalAmount.entrySet()){
            System.out.println(m);
            value.add(m);
        }
        model.addAttribute("data",value);
        return "/kalyanCheckLoad";
    }

    // Kalyan Coding Completed //

    // Main Bazaar Coding Starts //

    @GetMapping("/admin/mainPlay")
    public String mainDisplayAllPlay(Model model)
    {
        model.addAttribute("plays",mainService.mainGetAllAmount());
        return "mainDisplayAll";
    }
    @GetMapping("/mainLetsPlay")
    public String mainLetsPlay(Model model)
    {
        MainBazaar num=new MainBazaar();
        model.addAttribute("plays",num);
        return "mainLetsPlay";
    }
    @GetMapping("/mainSubmitData")
    public String mainGetByAddData(MainBazaar number)
    {
        mainService.mainGetByAddData(number);
        return "redirect:/mainLetsPlay";
    }
    @GetMapping("/mainDeleteRecord/{id}")
    public String mainDeleteMobile(@PathVariable(value = "id") int id,Model model)
    {
        mainService.mainDeleteById(id);
        return "redirect:/mainPlay";
    }

    @GetMapping("/mainUpdateRecord/{id}")
    public String mainUpdatePlayNumber(@PathVariable(value = "id") int id,Model model)
    {
        model.addAttribute("plays",mainService.mainUpdateData(id));
        return "mainUpdateForm";

    }
    @GetMapping("/mainSubmitNewData")
    public String mainUpdatePlayNumberInfo(MainBazaar playNumber)
    {
        mainService.mainUpdateNewPlayNumber(playNumber);
        return "redirect:/mainPlay";
    }
    @GetMapping("/admin/mainClearData")
    public String mainClearAllData()
    {
        mainService.mainClearAllDataOfDatabase();
        return "redirect:/mainPlay";
    }
    @GetMapping("/admin/mainCheckLoad")
    public String mainCheckLoad(Model model)
    {
        ArrayList integerArrayList1=new ArrayList<>();
        List<Integer> playList =mainService.mainCheckLoad();

        HashMap<Integer,Long> totalAmount= (HashMap<Integer, Long>) mainService.mainGetTotalAmount(playList);
        ArrayList value=new ArrayList<>();
        System.out.println("Loading of Main Bazaar");
        for(Object m : totalAmount.entrySet()){
            System.out.println(m);
            value.add(m);
        }

        model.addAttribute("keys",value);
        return "/mainCheckLoad";
    }

    // Main Bazaar Coding Completed //

    // MilanDay Bazaar Coding Starts //

    @GetMapping("/admin/milanPlay")
    public String milanDisplayAllPlay(Model model)
    {
        model.addAttribute("plays",milanService.milanGetAllAmount());
        return "milanDisplayAll";
    }
    @GetMapping("/milanLetsPlay")
    public String milanLetsPlay(Model model)
    {
        MilanDayBazaar num=new MilanDayBazaar();
        model.addAttribute("plays",num);
        return "milanLetsPlay";
    }
    @GetMapping("/milanSubmitData")
    public String milanGetByAddData(MilanDayBazaar number)
    {
        milanService.milanGetByAddData(number);
        return "redirect:/milanLetsPlay";
    }
    @GetMapping("/milanDeleteRecord/{id}")
    public String milanDeleteMobile(@PathVariable(value = "id") int id,Model model)
    {
        milanService.milanDeleteById(id);
        return "redirect:/milanPlay";
    }

    @GetMapping("/milanUpdateRecord/{id}")
    public String milanUpdatePlayNumber(@PathVariable(value = "id") int id,Model model)
    {
        model.addAttribute("plays",milanService.milanUpdateData(id));
        return "milanUpdateForm";

    }
    @GetMapping("/milanSubmitNewData")
    public String milanUpdatePlayNumberInfo(MilanDayBazaar playNumber)
    {
        milanService.milanUpdateNewPlayNumber(playNumber);
        return "redirect:/milanPlay";
    }
    @GetMapping("/admin/milanClearData")
    public String milanClearAllData()
    {
        milanService.milanClearAllDataOfDatabase();
        return "redirect:/milanPlay";
    }
    @GetMapping("/admin/milanCheckLoad")
    public String milanCheckLoad(Model model)
    {
        ArrayList integerArrayList1=new ArrayList<>();
        List<Integer> playList =milanService.milanCheckLoad();

        HashMap<Integer,Long> totalAmount= (HashMap<Integer, Long>) milanService.milanGetTotalAmount(playList);
        ArrayList value=new ArrayList<>();
        System.out.println("Loading of Milan Bazaar");
        for(Object m : totalAmount.entrySet()){
            System.out.println(m);
            value.add(m);
        }

        model.addAttribute("keys",value);
        return "/milanCheckLoad";
    }
    // MilanDay Bazaar Coding Complete //


    // Rajdhani Bazaar Coding Starts //


    @GetMapping("/admin/rajdhaniPlay")
    public String rajdhaniDisplayAllPlay(Model model)
    {
        model.addAttribute("plays",rajdhaniService.rajdhaniGetAllAmount());
        return "rajdhaniDisplayAll";
    }
    @GetMapping("/rajdhaniLetsPlay")
    public String rajdhaniLetsPlay(Model model)
    {
        RajdhaniBazaar num=new RajdhaniBazaar();
        model.addAttribute("plays",num);
        return "rajdhaniLetsPlay";
    }
    @GetMapping("/rajdhaniSubmitData")
    public String rajdhaniGetByAddData(RajdhaniBazaar number)
    {
        rajdhaniService.rajdhaniGetByAddData(number);
        return "redirect:/rajdhaniLetsPlay";
    }
    @GetMapping("/rajdhaniDeleteRecord/{id}")
    public String rajdhaniDeleteMobile(@PathVariable(value = "id") int id,Model model)
    {
        rajdhaniService.rajdhaniDeleteById(id);
        return "redirect:/rajdhaniPlay";
    }

    @GetMapping("/rajdhaniUpdateRecord/{id}")
    public String rajdhaniUpdatePlayNumber(@PathVariable(value = "id") int id,Model model)
    {
        model.addAttribute("plays",rajdhaniService.rajdhaniUpdateData(id));
        return "rajdhaniUpdateForm";

    }
    @GetMapping("/rajdhaniSubmitNewData")
    public String rajdhaniUpdatePlayNumberInfo(RajdhaniBazaar playNumber)
    {
        rajdhaniService.rajdhaniUpdateNewPlayNumber(playNumber);
        return "redirect:/rajdhaniPlay";
    }
    @GetMapping("/admin/rajdhaniClearData")
    public String rajdhaniClearAllData()
    {
        rajdhaniService.rajdhaniClearAllDataOfDatabase();
        return "redirect:/rajdhaniPlay";
    }
    @GetMapping("/admin/rajdhaniCheckLoad")
    public String rajdhaniCheckLoad(Model model)
    {
        ArrayList integerArrayList1=new ArrayList<>();
        List<Integer> playList =rajdhaniService.rajdhaniCheckLoad();

        HashMap<Integer,Long> totalAmount= (HashMap<Integer, Long>) rajdhaniService.rajdhaniGetTotalAmount(playList);
        ArrayList value=new ArrayList<>();
        System.out.println("Loading of Rajdhani Bazaar");
        for(Object m : totalAmount.entrySet()){
            System.out.println(m);
            value.add(m);
        }
        model.addAttribute("keys",value);
        return "/rajdhaniCheckLoad";
    }

    // Rajdhani Bazaar Coding Complete //

    // Time Bazaar coding Starts //

    @GetMapping("/admin/timePlay")
    public String timeDisplayAllPlay(Model model)
    {
        model.addAttribute("plays",timeService.timeGetAllAmount());
        return "timeDisplayAll";
    }
    @GetMapping("/timeLetsPlay")
    public String timeLetsPlay(Model model)
    {
        TimeBazaar num=new TimeBazaar();
        model.addAttribute("plays",num);
        return "timeLetsPlay";
    }
    @GetMapping("/timeSubmitData")
    public String timeGetByAddData(TimeBazaar number)
    {
        timeService.timeGetByAddData(number);
        return "redirect:/timeLetsPlay";
    }
    @GetMapping("/timeDeleteRecord/{id}")
    public String timeDeleteMobile(@PathVariable(value = "id") int id,Model model)
    {
        timeService.timeDeleteById(id);
        return "redirect:/timePlay";
    }

    @GetMapping("/timeUpdateRecord/{id}")
    public String timeUpdatePlayNumber(@PathVariable(value = "id") int id,Model model)
    {
        model.addAttribute("plays",timeService.timeUpdateData(id));
        return "timeUpdateForm";

    }
    @GetMapping("/timeSubmitNewData")
    public String timeUpdatePlayNumberInfo(TimeBazaar playNumber)
    {
        timeService.timeUpdateNewPlayNumber(playNumber);
        return "redirect:/timePlay";
    }
    @GetMapping("/admin/timeClearData")
    public String timeClearAllData()
    {
        timeService.timeClearAllDataOfDatabase();
        return "redirect:/timePlay";
    }
    @GetMapping("/admin/timeCheckLoad")
    public String timeCheckLoad(Model model)
    {
        ArrayList integerArrayList1=new ArrayList<>();
        List<Integer> playList =timeService.timeCheckLoad();

        HashMap<Integer,Long> totalAmount= (HashMap<Integer, Long>) timeService.timeGetTotalAmount(playList);
        ArrayList value=new ArrayList<>();
        System.out.println("Loading of Time Bazaar");
        for(Object m : totalAmount.entrySet()){
            System.out.println(m);
            value.add(m);
        }

        model.addAttribute("keys",value);
        return "/timeCheckLoad";
    }

    // Time Bazaar Coding Complete //

    // checking All Load At time //
@GetMapping("/admin/checkingAllLoad")
    public String checkingGetAllLoad(Model model)
    {
        List<String> playList1 =kService.kalyanCheckLoad();
        long kalyanMax=0;
        int kalyanNum=0;
        long kMin=0;
        int kMinNum=0;
        double kalyanHighPay=0;
        double kalyanLowPay=0;
        double totalKalyanGame=0;
        double kalyanProfitLoss=0;
        HashMap<Integer,Long> totalAmount1= (HashMap) kService.kalyanGetTotalAmount(playList1);
        for (Map.Entry<Integer, Long> v:totalAmount1.entrySet())
        {
           int num= v.getKey();
           long amt=v.getValue();
            totalKalyanGame=totalKalyanGame+amt;
            System.out.println(num+" "+amt);
            if (amt>kalyanMax)
            {
                kalyanMax=amt;
                kalyanNum=num;
            }

        }
        boolean kx=false;
        for (Map.Entry<Integer, Long> v:totalAmount1.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            System.out.println(num+" "+amt);
                if (kx==false)
            {
                kMin=amt;
                kMinNum=num;
                kx=true;
            }
            if (amt<kMin)
            {
                kMin=amt;
                kMinNum=num;
            }

        }
        System.out.println("kalyan Minimum amt "+kMin);
        kalyanHighPay=kalyanMax*90;
        kalyanLowPay=kMin*90;
        kalyanProfitLoss=totalKalyanGame-kalyanLowPay;
        System.out.println("Minimum : "+kMinNum+" "+kMin);

        ArrayList value1=new ArrayList<>();
        System.out.println("Loading of Kalyan Bazaar");
        for(Object m : totalAmount1.entrySet())
        {
            //System.out.println(m);
            value1.add(m);
        }

       // Main Bazaar
        List<Integer> playList2 =mainService.mainCheckLoad();
        long mainMax=0;
        int mainNum=0;
        long mainMin=0;
        int mainMinNum=0;
        double totalMainGame=0;
        double mainHighPay=0;
        double mainLowPay=0;
        double mainProfitLoss=0;
        HashMap<Integer,Long> totalAmount2= (HashMap<Integer, Long>) mainService.mainGetTotalAmount(playList2);
        for (Map.Entry<Integer, Long> v:totalAmount2.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            totalMainGame=totalMainGame+amt;
            System.out.println(num+" "+amt);
            if (amt>mainMax)
            {
                mainMax=amt;
                mainNum=num;
            }
        }
        boolean ma=false;
        for (Map.Entry<Integer, Long> v:totalAmount2.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            System.out.println(num+" "+amt);
            if (ma==false)
            {
                mainMin=amt;
                mainMinNum=num;
                ma=true;
            }
            if (amt<mainMin)
            {
                mainMin=amt;
                mainMinNum=num;
            }

        }
        mainHighPay=mainMax*90;
        mainLowPay=mainMin*90;

        mainProfitLoss=totalMainGame-mainLowPay;
        ArrayList value2=new ArrayList<>();
        System.out.println("Loading of Main Bazaar");
        for(Object m : totalAmount2.entrySet()){
            System.out.println(m);
            value2.add(m);
        }

       // Milan Bazaar
        List<Integer> playList3 =milanService.milanCheckLoad();
        long milanMax=0;
        int milanNum=0;
        long milanMin=0;
        int milanMinNum=0;
        double totalMilanGame=0;
        double milanHighPay=0;
        double milanLowPay=0;
        double milanProfitLoss=0;
        HashMap<Integer,Long> totalAmount3= (HashMap<Integer, Long>) milanService.milanGetTotalAmount(playList3);
        for (Map.Entry<Integer, Long> v:totalAmount3.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            totalMilanGame=totalMilanGame+amt;
            System.out.println(num+" "+amt);
            if (amt>milanMax)
            {
                milanMax=amt;
                milanNum=num;
            }
        }
        boolean mi=false;
        for (Map.Entry<Integer, Long> v:totalAmount3.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            System.out.println(num+" "+amt);
            if (mi==false)
            {
                milanMin=amt;
                milanMinNum=num;
                mi=true;
            }
            if (amt<milanMin)
            {
                milanMin=amt;
                milanMinNum=num;
            }

        }
        milanHighPay=milanMax*90;
        milanLowPay=milanMin*90;
        milanProfitLoss=totalMilanGame-milanLowPay;
        ArrayList value3=new ArrayList<>();
        System.out.println("Loading of Milan Bazaar");
        for(Object m : totalAmount3.entrySet()){
            System.out.println(m);
            value3.add(m);
        }

      // Rajdhani Bazaar
        List<Integer> playList4 =rajdhaniService.rajdhaniCheckLoad();
        long rajdhaniMax=0;
        int rajdhaniNum=0;
        long rajdhaniMin=0;
        int rajdhaniMinNum=0;
        double totalRajdhaniGame=0;
        double rajdhaniHighPay=0;
        double rajdhaniLowPay=0;
        double rajdhaniProfitLoss=0;
        HashMap<Integer,Long> totalAmount4= (HashMap<Integer, Long>) rajdhaniService.rajdhaniGetTotalAmount(playList4);
        for (Map.Entry<Integer, Long> v:totalAmount4.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            totalRajdhaniGame=totalRajdhaniGame+amt;
            System.out.println(num+" "+amt);
            if (amt>rajdhaniMax)
            {
                rajdhaniMax=amt;
                rajdhaniNum=num;
            }
        }
        boolean ra=false;
        for (Map.Entry<Integer, Long> v:totalAmount4.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            System.out.println(num+" "+amt);
            if (ra==false)
            {
                rajdhaniMin=amt;
                rajdhaniMinNum=num;
                ra=true;
            }
            if (amt<rajdhaniMin)
            {
                rajdhaniMin=amt;
                rajdhaniMinNum=num;
            }

        }
        rajdhaniHighPay=rajdhaniMax*90;
        rajdhaniLowPay=rajdhaniMin*90;
        rajdhaniProfitLoss=totalRajdhaniGame-rajdhaniLowPay;
        ArrayList value4=new ArrayList<>();
        System.out.println("Loading of Rajdhani Bazaar");
        for(Object m : totalAmount4.entrySet()){
            System.out.println(m);
            value4.add(m);
        }


        // time bazaar

        List<Integer> playList5 =timeService.timeCheckLoad();
        long timeMax=0;
        int timeNum=0;
        long timeMin=0;
        int timeMinNum=0;
        double totalTimeGame=0;
        double timeHighPay=0;
        double timeLowPay=0;
        double timeProfitLoss=0;
        HashMap<Integer,Long> totalAmount5= (HashMap<Integer, Long>) timeService.timeGetTotalAmount(playList5);
        for (Map.Entry<Integer, Long> v:totalAmount5.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            totalTimeGame=totalTimeGame+amt;
            System.out.println(num+" "+amt);
            if (amt>timeMax)
            {
                timeMax=amt;
                timeNum=num;
            }
        }
        boolean ti=false;
        for (Map.Entry<Integer, Long> v:totalAmount5.entrySet())
        {
            int num= v.getKey();
            long amt=v.getValue();
            System.out.println(num+" "+amt);
            if (ti==false)
            {
                timeMin=amt;
                timeMinNum=num;
                ti=true;
            }
            if (amt<timeMin)
            {
                timeMin=amt;
                timeMinNum=num;
            }

        }
        timeHighPay=timeMax*90;
        timeLowPay=timeMin*90;
        timeProfitLoss=totalTimeGame-timeLowPay;
        ArrayList value5=new ArrayList<>();
        System.out.println("Loading of Time Bazaar");
        for(Object m : totalAmount5.entrySet()){
            System.out.println(m);
            value5.add(m);
        }
        model.addAttribute("kalyan",value1);
        model.addAttribute("kalyanMax",kalyanMax);
        model.addAttribute("kalyanNum",kalyanNum);
        model.addAttribute("kalyanMin",kMin);
        model.addAttribute("kalyanMinNum",kMinNum);
        model.addAttribute("totalKalyanGame",totalKalyanGame);
        model.addAttribute("kalyanHighPay",kalyanHighPay);
        model.addAttribute("kalyanLowPay",kalyanLowPay);
        model.addAttribute("kalyanProfitLoss",kalyanProfitLoss);


        model.addAttribute("main",value2);
        model.addAttribute("mainMax",mainMax);
        model.addAttribute("mainNum",mainNum);
        model.addAttribute("mainMin",mainMin);
        model.addAttribute("mainMinNum",mainMinNum);
        model.addAttribute("totalMainGame",totalMainGame);
        model.addAttribute("mainHighPay",mainHighPay);
        model.addAttribute("mainLowPay",mainLowPay);
        model.addAttribute("mainProfitLoss",mainProfitLoss);

        model.addAttribute("milan",value3);
        model.addAttribute("milanMax",milanMax);
        model.addAttribute("milanNum",milanNum);
        model.addAttribute("milanMin",milanMin);
        model.addAttribute("milanMinNum",milanMinNum);
        model.addAttribute("totalMilanGame",totalMilanGame);
        model.addAttribute("milanHighPay",milanHighPay);
        model.addAttribute("milanLowPay",milanLowPay);
        model.addAttribute("milanProfitLoss",milanProfitLoss);

        model.addAttribute("rajdhani",value4);
        model.addAttribute("rajdhaniMax",rajdhaniMax);
        model.addAttribute("rajdhaniNum",rajdhaniNum);
        model.addAttribute("rajdhaniMin",rajdhaniMin);
        model.addAttribute("rajdhaniMinNum",rajdhaniMinNum);
        model.addAttribute("totalRajdhaniGame",totalRajdhaniGame);
        model.addAttribute("rajdhaniHighPay",rajdhaniHighPay);
        model.addAttribute("rajdhaniLowPay",rajdhaniLowPay);
        model.addAttribute("rajdhaniProfitLoss",rajdhaniProfitLoss);

        model.addAttribute("time",value5);
        model.addAttribute("timeMax",timeMax);
        model.addAttribute("timeNum",timeNum);
        model.addAttribute("timeMin",timeMin);
        model.addAttribute("timeMinNum",timeMinNum);
        model.addAttribute("totalTimeGame",totalTimeGame);
        model.addAttribute("timeHighPay",timeHighPay);
        model.addAttribute("timeLowPay",timeLowPay);
        model.addAttribute("timeProfitLoss",timeProfitLoss);

        return "/allMarketLoad";
    }

    // Kalyan Market Ascending Number //

    @GetMapping("/admin/kalyanAscendingNumber")
    public String kalyanGetAllAscending(Model model)
    {
        ArrayList list= (ArrayList) kService.kalyanGetAllAscendingNumber();

        ArrayList list0=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();

        Iterator itr= list.iterator();
        while (itr.hasNext()) {
            int num= (int) itr.next();
            if (num<10)
            {
                list0.add(num);
            }
            if (num>9 && num<20)
            {
                list1.add(num);
            }
            if (num>19 && num<30) {
                list2.add(num);
            }
            if (num>29 && num<40) {
                list3.add(num);
            }
            if (num>39 && num<50) {
                list4.add(num);
            }
            if (num>49 && num<60) {
                list5.add(num);
            }
            if (num>59 && num<70) {
                list6.add(num);
            }
            if (num>69 && num<80) {
                list7.add(num);
            }
            if (num>79 && num<90) {
                list8.add(num);
            }
            if (num>89 && num<100) {
                list9.add(num);
            }
        }
        HashMap totalAmount0= (HashMap) kService.kalyanGetSum0(list0);
        ArrayList value0=new ArrayList<>();
        for(Object m : totalAmount0.entrySet()){

            value0.add(m);
        }
        HashMap totalAmount1= (HashMap) kService.kalyanGetSum1(list1);
        ArrayList value1=new ArrayList<>();
        for(Object m : totalAmount1.entrySet()){

            value1.add(m);
        }
        HashMap totalAmount2= (HashMap) kService.kalyanGetSum2(list2);
        ArrayList value2=new ArrayList<>();
        for(Object m : totalAmount2.entrySet()){

            value2.add(m);
        }
        HashMap totalAmount3= (HashMap) kService.kalyanGetSum3(list3);
        ArrayList value3=new ArrayList<>();
        for(Object m : totalAmount3.entrySet()){
            value3.add(m);
        }
        HashMap totalAmount4= (HashMap) kService.kalyanGetSum4(list4);
        ArrayList value4=new ArrayList<>();
        for(Object m : totalAmount4.entrySet()){

            value4.add(m);
        }
        HashMap totalAmount5= (HashMap)kService.kalyanGetSum5(list5);
        ArrayList value5=new ArrayList<>();
        for(Object m : totalAmount5.entrySet()){

            value5.add(m);
        }
        HashMap totalAmount6= (HashMap) kService.kalyanGetSum6(list6);
        ArrayList value6=new ArrayList<>();
        for(Object m : totalAmount6.entrySet()){

            value6.add(m);
        }
        HashMap totalAmount7= (HashMap) kService.kalyanGetSum7(list7);
        ArrayList value7=new ArrayList<>();
        for(Object m : totalAmount7.entrySet()){

            value7.add(m);
        }
        HashMap totalAmount8= (HashMap) kService.kalyanGetSum8(list8);
        ArrayList value8=new ArrayList<>();
        for(Object m : totalAmount8.entrySet()){

            value8.add(m);
        }
        HashMap totalAmount9= (HashMap) kService.kalyanGetSum9(list9);
        ArrayList value9=new ArrayList<>();
        for(Object m : totalAmount9.entrySet()){

            value9.add(m);
        }
        model.addAttribute("list0",value0);
        model.addAttribute("list1",value1);
        model.addAttribute("list2",value2);
        model.addAttribute("list3",value3);
        model.addAttribute("list4",value4);
        model.addAttribute("list5",value5);
        model.addAttribute("list6",value6);
        model.addAttribute("list7",value7);
        model.addAttribute("list8",value8);
        model.addAttribute("list9",value9);
        return "kalyanAscendingNum";
    }


    // Main Market Ascending Number //

    @GetMapping("/admin/mainAscendingNumber")
    public String mainGetAllAscending(Model model)
    {
        ArrayList list= (ArrayList) mainService.mainGetAllAscendingNumber();

        ArrayList list0=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();

        Iterator itr= list.iterator();
        while (itr.hasNext()) {
            int num= (int) itr.next();
            if (num<10)
            {
                list0.add(num);
            }
            if (num>9 && num<20)
            {
                list1.add(num);
            }
            if (num>19 && num<30) {
                list2.add(num);
            }
            if (num>29 && num<40) {
                list3.add(num);
            }
            if (num>39 && num<50) {
                list4.add(num);
            }
            if (num>49 && num<60) {
                list5.add(num);
            }
            if (num>59 && num<70) {
                list6.add(num);
            }
            if (num>69 && num<80) {
                list7.add(num);
            }
            if (num>79 && num<90) {
                list8.add(num);
            }
            if (num>89 && num<100) {
                list9.add(num);
            }
        }
        HashMap totalAmount0= (HashMap) mainService.mainGetSum0(list0);
        ArrayList value0=new ArrayList<>();
        for(Object m : totalAmount0.entrySet()){

            value0.add(m);
        }
        HashMap totalAmount1= (HashMap) mainService.mainGetSum1(list1);
        ArrayList value1=new ArrayList<>();
        for(Object m : totalAmount1.entrySet()){

            value1.add(m);
        }
        HashMap totalAmount2= (HashMap) mainService.mainGetSum2(list2);
        ArrayList value2=new ArrayList<>();
        for(Object m : totalAmount2.entrySet()){

            value2.add(m);
        }
        HashMap totalAmount3= (HashMap) mainService.mainGetSum3(list3);
        ArrayList value3=new ArrayList<>();
        for(Object m : totalAmount3.entrySet()){
            value3.add(m);
        }
        HashMap totalAmount4= (HashMap) mainService.mainGetSum4(list4);
        ArrayList value4=new ArrayList<>();
        for(Object m : totalAmount4.entrySet()){

            value4.add(m);
        }
        HashMap totalAmount5= (HashMap)mainService.mainGetSum5(list5);
        ArrayList value5=new ArrayList<>();
        for(Object m : totalAmount5.entrySet()){

            value5.add(m);
        }
        HashMap totalAmount6= (HashMap) mainService.mainGetSum6(list6);
        ArrayList value6=new ArrayList<>();
        for(Object m : totalAmount6.entrySet()){

            value6.add(m);
        }
        HashMap totalAmount7= (HashMap) mainService.mainGetSum7(list7);
        ArrayList value7=new ArrayList<>();
        for(Object m : totalAmount7.entrySet()){

            value7.add(m);
        }
        HashMap totalAmount8= (HashMap) mainService.mainGetSum8(list8);
        ArrayList value8=new ArrayList<>();
        for(Object m : totalAmount8.entrySet()){

            value8.add(m);
        }
        HashMap totalAmount9= (HashMap) mainService.mainGetSum9(list9);
        ArrayList value9=new ArrayList<>();
        for(Object m : totalAmount9.entrySet()){

            value9.add(m);
        }
        model.addAttribute("list0",value0);
        model.addAttribute("list1",value1);
        model.addAttribute("list2",value2);
        model.addAttribute("list3",value3);
        model.addAttribute("list4",value4);
        model.addAttribute("list5",value5);
        model.addAttribute("list6",value6);
        model.addAttribute("list7",value7);
        model.addAttribute("list8",value8);
        model.addAttribute("list9",value9);
        return "mainAscendingNum";
    }

    // milan Market Ascending Number //

    @GetMapping("/admin/milanAscendingNumber")
    public String milanGetAllAscending(Model model)
    {
        ArrayList list= (ArrayList) milanService.milanGetAllAscendingNumber();

        ArrayList list0=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();

        Iterator itr= list.iterator();
        while (itr.hasNext()) {
            int num= (int) itr.next();
            if (num<10)
            {
                list0.add(num);
            }
            if (num>9 && num<20)
            {
                list1.add(num);
            }
            if (num>19 && num<30) {
                list2.add(num);
            }
            if (num>29 && num<40) {
                list3.add(num);
            }
            if (num>39 && num<50) {
                list4.add(num);
            }
            if (num>49 && num<60) {
                list5.add(num);
            }
            if (num>59 && num<70) {
                list6.add(num);
            }
            if (num>69 && num<80) {
                list7.add(num);
            }
            if (num>79 && num<90) {
                list8.add(num);
            }
            if (num>89 && num<100) {
                list9.add(num);
            }
        }
        HashMap totalAmount0= (HashMap) milanService.milanGetSum0(list0);
        ArrayList value0=new ArrayList<>();
        for(Object m : totalAmount0.entrySet()){

            value0.add(m);
        }
        HashMap totalAmount1= (HashMap) milanService.milanGetSum1(list1);
        ArrayList value1=new ArrayList<>();
        for(Object m : totalAmount1.entrySet()){

            value1.add(m);
        }
        HashMap totalAmount2= (HashMap) milanService.milanGetSum2(list2);
        ArrayList value2=new ArrayList<>();
        for(Object m : totalAmount2.entrySet()){

            value2.add(m);
        }
        HashMap totalAmount3= (HashMap) milanService.milanGetSum3(list3);
        ArrayList value3=new ArrayList<>();
        for(Object m : totalAmount3.entrySet()){
            value3.add(m);
        }
        HashMap totalAmount4= (HashMap) milanService.milanGetSum4(list4);
        ArrayList value4=new ArrayList<>();
        for(Object m : totalAmount4.entrySet()){

            value4.add(m);
        }
        HashMap totalAmount5= (HashMap)milanService.milanGetSum5(list5);
        ArrayList value5=new ArrayList<>();
        for(Object m : totalAmount5.entrySet()){

            value5.add(m);
        }
        HashMap totalAmount6= (HashMap) milanService.milanGetSum6(list6);
        ArrayList value6=new ArrayList<>();
        for(Object m : totalAmount6.entrySet()){

            value6.add(m);
        }
        HashMap totalAmount7= (HashMap) milanService.milanGetSum7(list7);
        ArrayList value7=new ArrayList<>();
        for(Object m : totalAmount7.entrySet()){

            value7.add(m);
        }
        HashMap totalAmount8= (HashMap) milanService.milanGetSum8(list8);
        ArrayList value8=new ArrayList<>();
        for(Object m : totalAmount8.entrySet()){

            value8.add(m);
        }
        HashMap totalAmount9= (HashMap) milanService.milanGetSum9(list9);
        ArrayList value9=new ArrayList<>();
        for(Object m : totalAmount9.entrySet()){

            value9.add(m);
        }
        model.addAttribute("list0",value0);
        model.addAttribute("list1",value1);
        model.addAttribute("list2",value2);
        model.addAttribute("list3",value3);
        model.addAttribute("list4",value4);
        model.addAttribute("list5",value5);
        model.addAttribute("list6",value6);
        model.addAttribute("list7",value7);
        model.addAttribute("list8",value8);
        model.addAttribute("list9",value9);
        return "milanAscendingNum";
    }

    // rajdhani Market Ascending Number //

    @GetMapping("/admin/rajdhaniAscendingNumber")
    public String rajdhaniGetAllAscending(Model model)
    {
        ArrayList list= (ArrayList) rajdhaniService.rajdhaniGetAllAscendingNumber();

        ArrayList list0=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();

        Iterator itr= list.iterator();
        while (itr.hasNext()) {
            int num= (int) itr.next();
            if (num<10)
            {
                list0.add(num);
            }
            if (num>9 && num<20)
            {
                list1.add(num);
            }
            if (num>19 && num<30) {
                list2.add(num);
            }
            if (num>29 && num<40) {
                list3.add(num);
            }
            if (num>39 && num<50) {
                list4.add(num);
            }
            if (num>49 && num<60) {
                list5.add(num);
            }
            if (num>59 && num<70) {
                list6.add(num);
            }
            if (num>69 && num<80) {
                list7.add(num);
            }
            if (num>79 && num<90) {
                list8.add(num);
            }
            if (num>89 && num<100) {
                list9.add(num);
            }
        }
        HashMap totalAmount0= (HashMap) rajdhaniService.rajdhaniGetSum0(list0);
        ArrayList value0=new ArrayList<>();
        for(Object m : totalAmount0.entrySet()){

            value0.add(m);
        }
        HashMap totalAmount1= (HashMap) rajdhaniService.rajdhaniGetSum1(list1);
        ArrayList value1=new ArrayList<>();
        for(Object m : totalAmount1.entrySet()){

            value1.add(m);
        }
        HashMap totalAmount2= (HashMap) rajdhaniService.rajdhaniGetSum2(list2);
        ArrayList value2=new ArrayList<>();
        for(Object m : totalAmount2.entrySet()){

            value2.add(m);
        }
        HashMap totalAmount3= (HashMap) rajdhaniService.rajdhaniGetSum3(list3);
        ArrayList value3=new ArrayList<>();
        for(Object m : totalAmount3.entrySet()){
            value3.add(m);
        }
        HashMap totalAmount4= (HashMap) rajdhaniService.rajdhaniGetSum4(list4);
        ArrayList value4=new ArrayList<>();
        for(Object m : totalAmount4.entrySet()){

            value4.add(m);
        }
        HashMap totalAmount5= (HashMap)rajdhaniService.rajdhaniGetSum5(list5);
        ArrayList value5=new ArrayList<>();
        for(Object m : totalAmount5.entrySet()){

            value5.add(m);
        }
        HashMap totalAmount6= (HashMap) rajdhaniService.rajdhaniGetSum6(list6);
        ArrayList value6=new ArrayList<>();
        for(Object m : totalAmount6.entrySet()){

            value6.add(m);
        }
        HashMap totalAmount7= (HashMap) rajdhaniService.rajdhaniGetSum7(list7);
        ArrayList value7=new ArrayList<>();
        for(Object m : totalAmount7.entrySet()){

            value7.add(m);
        }
        HashMap totalAmount8= (HashMap) rajdhaniService.rajdhaniGetSum8(list8);
        ArrayList value8=new ArrayList<>();
        for(Object m : totalAmount8.entrySet()){

            value8.add(m);
        }
        HashMap totalAmount9= (HashMap) rajdhaniService.rajdhaniGetSum9(list9);
        ArrayList value9=new ArrayList<>();
        for(Object m : totalAmount9.entrySet()){

            value9.add(m);
        }
        model.addAttribute("list0",value0);
        model.addAttribute("list1",value1);
        model.addAttribute("list2",value2);
        model.addAttribute("list3",value3);
        model.addAttribute("list4",value4);
        model.addAttribute("list5",value5);
        model.addAttribute("list6",value6);
        model.addAttribute("list7",value7);
        model.addAttribute("list8",value8);
        model.addAttribute("list9",value9);
        return "rajdhaniAscendingNum";
    }

    // time Market Ascending Number //

    @GetMapping("/admin/timeAscendingNumber")
    public String timeGetAllAscending(Model model)
    {
        ArrayList list= (ArrayList) timeService.timeGetAllAscendingNumber();

        ArrayList list0=new ArrayList();
        ArrayList list1=new ArrayList();
        ArrayList list2=new ArrayList();
        ArrayList list3=new ArrayList();
        ArrayList list4=new ArrayList();
        ArrayList list5=new ArrayList();
        ArrayList list6=new ArrayList();
        ArrayList list7=new ArrayList();
        ArrayList list8=new ArrayList();
        ArrayList list9=new ArrayList();

        Iterator itr= list.iterator();
        while (itr.hasNext()) {
            int num= (int) itr.next();
            if (num<10)
            {
                list0.add(num);
            }
            if (num>9 && num<20)
            {
                list1.add(num);
            }
            if (num>19 && num<30) {
                list2.add(num);
            }
            if (num>29 && num<40) {
                list3.add(num);
            }
            if (num>39 && num<50) {
                list4.add(num);
            }
            if (num>49 && num<60) {
                list5.add(num);
            }
            if (num>59 && num<70) {
                list6.add(num);
            }
            if (num>69 && num<80) {
                list7.add(num);
            }
            if (num>79 && num<90) {
                list8.add(num);
            }
            if (num>89 && num<100) {
                list9.add(num);
            }
        }
        HashMap totalAmount0= (HashMap) timeService.timeGetSum0(list0);
        ArrayList value0=new ArrayList<>();
        for(Object m : totalAmount0.entrySet()){

            value0.add(m);
        }
        HashMap totalAmount1= (HashMap) timeService.timeGetSum1(list1);
        ArrayList value1=new ArrayList<>();
        for(Object m : totalAmount1.entrySet()){

            value1.add(m);
        }
        HashMap totalAmount2= (HashMap) timeService.timeGetSum2(list2);
        ArrayList value2=new ArrayList<>();
        for(Object m : totalAmount2.entrySet()){

            value2.add(m);
        }
        HashMap totalAmount3= (HashMap) timeService.timeGetSum3(list3);
        ArrayList value3=new ArrayList<>();
        for(Object m : totalAmount3.entrySet()){
            value3.add(m);
        }
        HashMap totalAmount4= (HashMap) timeService.timeGetSum4(list4);
        ArrayList value4=new ArrayList<>();
        for(Object m : totalAmount4.entrySet()){

            value4.add(m);
        }
        HashMap totalAmount5= (HashMap)timeService.timeGetSum5(list5);
        ArrayList value5=new ArrayList<>();
        for(Object m : totalAmount5.entrySet()){

            value5.add(m);
        }
        HashMap totalAmount6= (HashMap) timeService.timeGetSum6(list6);
        ArrayList value6=new ArrayList<>();
        for(Object m : totalAmount6.entrySet()){

            value6.add(m);
        }
        HashMap totalAmount7= (HashMap) timeService.timeGetSum7(list7);
        ArrayList value7=new ArrayList<>();
        for(Object m : totalAmount7.entrySet()){

            value7.add(m);
        }
        HashMap totalAmount8= (HashMap) timeService.timeGetSum8(list8);
        ArrayList value8=new ArrayList<>();
        for(Object m : totalAmount8.entrySet()){

            value8.add(m);
        }
        HashMap totalAmount9= (HashMap) timeService.timeGetSum9(list9);
        ArrayList value9=new ArrayList<>();
        for(Object m : totalAmount9.entrySet()){

            value9.add(m);
        }
        model.addAttribute("list0",value0);
        model.addAttribute("list1",value1);
        model.addAttribute("list2",value2);
        model.addAttribute("list3",value3);
        model.addAttribute("list4",value4);
        model.addAttribute("list5",value5);
        model.addAttribute("list6",value6);
        model.addAttribute("list7",value7);
        model.addAttribute("list8",value8);
        model.addAttribute("list9",value9);
        return "timeAscendingNum";
    }

    /*
    @GetMapping("/loginUser")
    public String checkUser(Model model)
    {
        UserRegister userRegister=new UserRegister();
        model.addAttribute("user",userRegister);
        return "/uRegister";
    }*/
    @GetMapping("/userReg")
    public String saveUser(Model model)
    {
        UserRegister userRegister=new UserRegister();
        model.addAttribute("userReg",userRegister);
        return "/uRegister";
    }
    @PostMapping("/saveUser")
    public String userRegister(UserRegister userRegister , HttpSession session)
    {
       UserRegister saveUserRegister =userRegisterService.saveUserRegister(userRegister);
       if (saveUserRegister!=null)
       {
           session.setAttribute("msg","Register Successfully ");
       }else {
           session.setAttribute("msg","Something Wrong !");
       }
        return "redirect:/userReg";
    }

    @GetMapping("/signin")
    public String getLogin(Model model)
    {
        UserRegister userRegister=new UserRegister();
        model.addAttribute("uCheck",userRegister);
        return "/ulogin";
    }
    @GetMapping("/forgetPass")
    public String forgetPass(Model model)
    {
        UserRegister userRegister=new UserRegister();
        model.addAttribute("fPass",userRegister);
        return "/forgetPass";
    }
    @GetMapping("/changePass")
    public String changePass(UserRegister userRegister,Model model,HttpSession session)
    {
        String url="";

        String username=userRegister.getUsername();
        UserRegister userRegister1=userRegisterRepository.getByChangePassword(username);
        if (userRegister1!=null) {
            session.setAttribute("uname", userRegister1.getUsername());
            UserRegister newUser = new UserRegister();
            model.addAttribute("fPass", newUser);
            url="/savePass";
        }else {
            UserRegister newUser = new UserRegister();
            model.addAttribute("fPass", newUser);
            session.setAttribute("passChangeMsg","Oops User Not Found ?");
           url= "redirect:/signin?error";
        }
        return url;
    }
    @PostMapping("/updatePass")
    public String updatePass(UserRegister userRegister,Model model,HttpSession session)
    {
        String uname= (String) session.getAttribute("uname");
        String cpass=new BCryptPasswordEncoder().encode(userRegister.getPassword());
        System.out.println(uname);
        System.out.println(cpass);
        int tx=userRegisterRepository.updatePassword(uname,cpass);
        if (tx==1)
        {
            session.setAttribute("passChangeMsg","Password Change Successfully ");
        }else {
            session.setAttribute("passChangeMsg","Something Wrong !");
        }

        return "redirect:/signin";
    }

@ModelAttribute
public  void commonUser(Principal p,Model model)
{
    if (p!=null) {
        String uName = p.getName();
        UserRegister userRegister = userRegisterRepository.findByUsername(uName);
        model.addAttribute("user", userRegister);
    }
}

}