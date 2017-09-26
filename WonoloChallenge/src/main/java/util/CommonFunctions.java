package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class CommonFunctions {


    public static int getRandomNumber(int range) {
        Random rand = new Random();
        int num = rand.nextInt(range);
        return num;
    }
	
    public static String convertIntegerToString(Integer i) {
        return Integer.toString(i);
    }
    
    public static String getCurrentTime() {
        String time = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        time = formater.format(calendar.getTime());
        return time;
    }

}
