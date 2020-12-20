package leetcode;

public class ReformatPhoneNumber1694 {

    public void ReformatPhoneNumber1694() {
        String number = "012345678";
        number = cleanNumber(number);
        StringBuffer sReturnNumber = new StringBuffer();
        StringBuffer sTemporal = new StringBuffer();
        int iContThree = 1;
        if (number.length() == 2 || number.length() == 3) {
            System.out.println(number);
        } else if (number.length() == 4) {
            sReturnNumber.append(number);
            sReturnNumber.insert(2, '-');
            System.out.println(sReturnNumber.toString());
        }
        for (int i = 0; i < number.length() && number.length() > 4; i++) {
            if (iContThree == 3) {
                sReturnNumber.append(number.charAt(i));
                sReturnNumber.append('-');
                iContThree = 0;
                if (i + 2 == number.length() - 1 || i + 4 == number.length() - 1) {
                    sTemporal.append(number.substring(i + 1));
                    break;
                }
            } else {
                sReturnNumber.append(number.charAt(i));
            }
            iContThree++;
        }
        if (sTemporal.length() == 2) {
            sReturnNumber.append(sTemporal.toString());
        } else if (sTemporal.length() == 4) {
            sTemporal.insert(2, '-');
            sReturnNumber.append(sTemporal.toString());
        } else if (sReturnNumber.length() != 0 && sReturnNumber.charAt(sReturnNumber.length() - 1) == '-') {
            sReturnNumber.deleteCharAt(sReturnNumber.length() - 1);
        }
        System.out.println(sReturnNumber.toString());
        System.out.println(sTemporal.toString());
    }

    public String cleanNumber(String sValue) {
        StringBuffer sNumber = new StringBuffer(sValue);
        for (int i = 0; i < sNumber.length(); i++) {
            if (sNumber.charAt(i) == ' ' || sNumber.charAt(i) == '-') {
                sNumber.deleteCharAt(i);
                i = i - 1;
            }
        }
        return sNumber.toString();
    }
}
