import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarDay {
    public static List<String> func(List<String> dates){
        Map<String, String> map = new HashMap<>();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
        List<String> result = new ArrayList<>();
        for(String date: dates){
            String[] parts = date.split(" ");
            String day = parts[0];
            String month = parts[1].substring(0,3);
            String year = parts[2];
            int i = 0;
            for(; i < day.length(); i++){
                if(!(day.charAt(i) >= '0' && day.charAt(i) <= '9'))
                    break;
            }
            day = day.substring(0,i);
            if(day.length() == 1)
                day = "0"+day;
            month = map.get(month);
            String newFormatDate = year+"-"+month+"-"+day;
            result.add(newFormatDate);
            System.out.println(newFormatDate);
        }
        return result;
    }
}
