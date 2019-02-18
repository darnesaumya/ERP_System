package ERP_System;
//Used to verify and check the values for emails, phone numbers and GST Number

public class Verification {

    public boolean verifyEmail(String Email) {
        return Email.contains("@") && Email.contains(".com");
    }

    public boolean verifyNumber(String number) {
        return Integer.parseInt(number) > 9999999 && number.length() == 10;
    }

    public boolean verifyGST(String gst) {
        return Integer.parseInt(gst.substring(0, 2)) >= 0 && Integer.parseInt(gst.substring(0, 2)) <= 35 && gst.length() == 15;
    }
}
