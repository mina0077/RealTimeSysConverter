package com.example.realtimesysconverter;

public class FromOctal {
    long Binary;
    int Decimal;
    String Hexa;

    public FromOctal(int octalNumber){

        octalConverter(octalNumber);
    }

    public void octalConverter(int octalNumber){
        int decimalNumber = 0, i = 0;
        long binaryNumber = 0;

        while(octalNumber != 0)
        {
            decimalNumber += (octalNumber % 10) * Math.pow(8, i);
            ++i;
            octalNumber/=10;
        }
        Decimal=decimalNumber;
        Hexa=Integer.toHexString(decimalNumber);

        i = 1;

        while (decimalNumber != 0)
        {
            binaryNumber += (decimalNumber % 2) * i;
            decimalNumber /= 2;
            i *= 10;
        }

        Binary= binaryNumber;

    }

}
