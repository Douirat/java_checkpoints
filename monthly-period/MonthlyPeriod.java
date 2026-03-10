import java.time.*;
import java.time.format.DateTimeFormatter;

public class MonthlyPeriod {
    public String calculatePeriod(String startDate, String endDate) {
        try{    
            LocalDate a = LocalDate.parse(startDate), b = LocalDate.parse(endDate);
            if(a.isAfter(b)){
                LocalDate t = a;
                a = b;
                b = t;
                }

                Period period = Period.between(a, b);
                int y = period.getYears(), m = period.getMonths();
                String ys = y == 0 ? "" : y == 1 ? y + " year" : y + " years";
                String ms = m == 0 ? "" : m == 1 ? m + " month" : m + " months";
                return ys.isEmpty() ? ms.isEmpty() ? "" : ms : ms.isEmpty()? ys : ys + " and " + ms;
        }catch(Exception e){
            return "Error";
        }
    }
}