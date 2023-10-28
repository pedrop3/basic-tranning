package Datas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 * 
 * Example
 * 
 * 
 * Return '12:01:00'.
 * 
 * 
 * Return '00:01:00'.
 * 
 * Function Description
 * 
 * Complete the timeConversion function in the editor below. It should return a
 * new string representing the input time in 24 hour format.
 * 
 * timeConversion has the following parameter(s):
 * 
 * string s: a time in hour format
 * Returns
 * 
 * string: the time in hour format
 * Input Format
 * 
 * A single string that represents a time in -hour clock format (i.e.: or ).
 * 
 * Constraints
 * 
 * All input times are valid
 * Sample Input 0
 * 
 * 07:05:45PM
 * Sample Output 0
 * 
 * 19:05:45
 ***/

public class TimeConvert24 {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String time = bufferedReader.readLine();

        timeConverstion(time);

    }

    private static void timeConverstion(String time) {

        SimpleDateFormat simpleDateFormat12 = new SimpleDateFormat("HH:mm:ssa");
        SimpleDateFormat simpleDateFormat24 = new SimpleDateFormat("HH:mm:ss");

        Date date;
        try {
            date = simpleDateFormat12.parse(time);
            String time24 = simpleDateFormat24.format(date);
            System.out.println(time24);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}