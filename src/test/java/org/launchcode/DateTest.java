package org.launchcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) {


    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
    }
}

class testUser {

    Date date;

    public String getDateString() {
        return dateString;
    }

    String dateString;

    static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public testUser() {
        this.date = new Date();
        this.dateString = dateFormat.format(this.date);
    }

    public static void main(String[] args) {
        testUser Todd = new testUser();
        System.out.println(Todd.getDateString());
    }
}
