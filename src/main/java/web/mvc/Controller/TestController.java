package web.mvc.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestController {
    public static void main(String [] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        String d1 = dateformat.format(date);
        String d2 = "2018-03-30 05:05:12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long m = sdf.parse(d2).getTime() - sdf.parse(d1).getTime();

        System.out.println("相差天数:"+ ( m / (1000 * 60 * 60 * 24) ) );
        System.out.println("第"+(int)((m / (1000 * 60 * 60 * 24))/182)+"学期");
    }
}
