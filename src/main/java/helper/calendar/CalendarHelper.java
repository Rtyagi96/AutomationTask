package helper.calendar;

import helper.logger.LoggerHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Logger;

public class CalendarHelper {
    private Logger log = LoggerHelper.getLogger(CalendarHelper.class);

    LocalDate currentDate;
    Month currentMonth;

    public String getNewDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        //Getting current date
        Calendar cal = Calendar.getInstance();

        //Displaying current date in the desired format
        log.info("Current Date in MM-dd-yyyy ---> " + sdf.format(cal.getTime()));

        //Provide the number of days to be added to the current date
        cal.add(Calendar.DAY_OF_MONTH, 5);

        //Date after adding the days to the current date
        String newDate = sdf.format(cal.getTime());

        //Displaying the new Date after addition of Days to current date
        log.info("New date after Addition MM-dd-yyyy ---> " + newDate);

        return newDate;
    }

    public String getCurrentMonth() {
        currentDate = LocalDate.now();
        currentMonth = currentDate.getMonth();
        log.info("String for current month of the year ---> " + currentMonth);
        return currentMonth.toString();
    }

    public StringBuilder reverseMonth(){
        currentDate = LocalDate.now();
        currentMonth = currentDate.getMonth();
        StringBuilder stringBuilder = new StringBuilder();

        // append a string into StringBuilder input
        stringBuilder.append(currentMonth.toString());

        StringBuilder reverseMonth = stringBuilder.reverse();
        log.info("Reverse string of the current month ---> " + reverseMonth);
        // reverse StringBuilder input
        return reverseMonth;
    }
    public String getDateValue() {
        LocalDate localDate = getNewDateFirefox();
        System.out.println(localDate);
        int currentDay = localDate.getDayOfMonth();
        System.out.println(currentDay);
        return String.valueOf(currentDay);
    }

    public String getMonthValue() {
        LocalDate localDate = getNewDateFirefox();
        int currentMonth = localDate.getMonthValue();
        System.out.println(currentMonth);
        return String.valueOf(currentMonth);
    }

    public String getYearValue() {
        LocalDate localDate = getNewDateFirefox();
        int currentYear = localDate.getYear();
        System.out.println(currentYear);
        return String.valueOf(currentYear);
    }
    public LocalDate getNewDateFirefox() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        //Getting current date
        Calendar cal = Calendar.getInstance();

        //Displaying current date in the desired format
        log.info("Current Date in MM-dd-yyyy ---> " + sdf.format(cal.getTime()));

        //Provide the number of days to be added to the current date
        cal.add(Calendar.DAY_OF_MONTH, 5);

        //Date after adding the days to the current date
        String newDate = sdf.format(cal.getTime());

        //Displaying the new Date after addition of Days to current date

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate NewDateAfterAddition = LocalDate.parse(newDate, formatter);
        log.info("New date after Addition MM-dd-yyyy ---> " + NewDateAfterAddition);

        return NewDateAfterAddition;
    }
}
