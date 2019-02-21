    package ERP_System;
//Used to verify and check the values for emails, phone numbers and GST Number

public class Verification {
    //Used to verify Email
    public boolean verifyEmail(String Email) {
        return Email.contains("@") && Email.contains(".com");
    }
    //Used to verify Phone Number
    public boolean verifyNumber(String number) {
        return Long.parseLong(number) > 9999999 && number.length() == 10;
    }
    //Used to verify GST Number
    public boolean verifyGST(String gst) {
        return Integer.parseInt(gst.substring(0, 2)) >= 0 && Integer.parseInt(gst.substring(0, 2)) <= 35 && gst.length() == 15;
    }
}
