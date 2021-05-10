package it.euris.restapi.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoCalculator implements IDaoCalculator {

    @Override
    public String sum(String operation) {

        String[] values = operation.split("\\+");
        String[] firstValue = values[0].split(" ");
        String[] secondValue = values[1].split(" ");
        int n = 0;
        int report = 0;

        int p1 = Integer.parseInt(firstValue[0].substring(0, firstValue[0].length() - 1));
        int s1 = Integer.parseInt(firstValue[1].substring(0, firstValue[1].length() - 1));
        int d1 = Integer.parseInt(firstValue[2].substring(0, firstValue[2].length() - 1));

        int p2 = Integer.parseInt(secondValue[1].substring(0, secondValue[1].length() - 1));
        int s2 = Integer.parseInt(secondValue[2].substring(0, secondValue[2].length() - 1));
        int d2 = Integer.parseInt(secondValue[3].substring(0, secondValue[3].length() - 1));

        int finalD = d1 + d2;
        if (finalD >= 12) {
            n = finalD % 12;
            report = (finalD - n) / 12;
            finalD = n;
        }

        int finalS = s1 + s2 + report;

        if (finalS >= 20) {
            n = finalS % 20;
            report = (finalS - n) / 20;
            finalS = n;
        } else {
            report = 0;
        }

        int finalP = p1 + p2 + report;

        String ris = operation +" = "+finalP + "p " + finalS + "s " + finalD + "d ";

        return ris;
    }

    @Override
    public String subtraction(String operation) {
        String[] values = operation.split("-");
        String[] firstValue = values[0].split(" ");
        String[] secondValue = values[1].split(" ");

        int p1 = Integer.parseInt(firstValue[0].substring(0, firstValue[0].length() - 1));
        int s1 = Integer.parseInt(firstValue[1].substring(0, firstValue[1].length() - 1));
        int d1 = Integer.parseInt(firstValue[2].substring(0, firstValue[2].length() - 1));

        int p2 = Integer.parseInt(secondValue[1].substring(0, secondValue[1].length() - 1));
        int s2 = Integer.parseInt(secondValue[2].substring(0, secondValue[2].length() - 1));
        int d2 = Integer.parseInt(secondValue[3].substring(0, secondValue[3].length() - 1));

        while (p2 > p1) {
            if (s1 < 20) {
                s1++;
                d1 = d1 - 12;
            } else {
                p1++;
                s1 = s1 - 20;
            }
        }
        ;

        int finalP = p1 - p2;

        while (s2 > s1) {
            s1++;
            d1 = d1 - 12;
        }
        ;

        int finalS = s1 - s2;

        while (d2 >= d1) {
            if (finalS == 0) {
                finalP = finalP - 1;
                finalS = finalS + 20;
            }
            finalS = finalS - 1;
            d1 = d1 + 12;
        }
        ;

        int finalD = d1 - d2;

        String ris = "";

        if (finalP >= 0 && finalS >= 0 && finalD >= 0) {
            ris = operation +" = "+ finalP + "p " + finalS + "s " + finalD + "d ";
        } else {
            ris = "Error: The second value is greater than the first";
        }
        return ris;
    }

    @Override
    public String multiplication(String operation) {

        String[] values = operation.split("\\*");
        String[] firstValue = values[0].split(" ");
        String[] secondValue = values[1].split(" ");


        int p1 = Integer.parseInt(firstValue[0].substring(0, firstValue[0].length() - 1));
        int s1 = Integer.parseInt(firstValue[1].substring(0, firstValue[1].length() - 1));
        int d1 = Integer.parseInt(firstValue[2].substring(0, firstValue[2].length() - 1));

        int multiplier = Integer.parseInt(secondValue[1]);

        int tempD = d1 * multiplier;
        int tempS = s1 * multiplier;
        int finalP = p1 * multiplier;

        int finalD = 0;

        if (tempD >= 12) {

            finalD = tempD % 12;
            tempS += tempD / 12;

        } else {

            finalD = tempD;

        }

        int finalS = 0;

        if (tempS >= 20) {

            finalS = tempS % 20;
            finalP += tempS / 20;

        } else {

            finalS = tempS;

        }

        String ris =operation +" = "+ finalP + "p " + finalS + "s " + finalD + "d ";


        return ris;
    }


   @Override
   public String division(String dividend, String numberDivider) {

       String[] firstValue = dividend.split(" ");

       int p1 = Integer.parseInt(firstValue[0].substring(0, firstValue[0].length() - 1));
       int s1 = Integer.parseInt(firstValue[1].substring(0, firstValue[1].length() - 1));
       int d1 = Integer.parseInt(firstValue[2].substring(0, firstValue[2].length() - 1));

       int divider = Integer.parseInt(numberDivider);

       int finalP = p1 / divider;
       int restP = p1 % divider;

       s1 += restP * 20;

       int finalS = s1 / divider;
       int restS = s1 % divider;

       d1 += restS * 12;

       int finalD = d1 / divider;
       int restD = d1 % divider;

       int finalRestD = 0;
       int finalRestS = 0;
       int finalRestP = 0;

       while (restD >= 20) {
           finalRestP++;
           restD -= 20;
       }
       while (restD >= 12) {
           finalRestS++;
           restD -= 12;
       }
       finalRestD = restD;

       String ris = dividend +"/"+ divider +" = "+ finalP + "p " + finalS + "s " + finalD + "d ";

       if(finalRestP == 0 && finalRestS == 0 && finalRestD == 0 ){
           ris = dividend +"/"+ divider +" = "+finalP + "p " + finalS + "s " + finalD + "d ";
       } else {
           ris = dividend +"/"+ divider +" = "+ finalP + "p " + finalS + "s " + finalD + "d " + "(" + finalRestP + "p " + finalRestS + "s " + finalRestD + "d " + ")";
       }

       return ris;
   }
}
