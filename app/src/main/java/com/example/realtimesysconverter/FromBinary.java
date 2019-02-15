package com.example.realtimesysconverter;

public class FromBinary {
     int Octal,Decimal;
     String Hexa;


    public FromBinary(long binaryNumber ){
        binaryConverter(binaryNumber);
    }

    public  void binaryConverter(long binaryNumber)
    {
        int octalNumber = 0, decimalNumber = 0, i = 0;

        while(binaryNumber != 0)
        {
            decimalNumber += (binaryNumber % 10) * Math.pow(2, i);
            ++i;
            binaryNumber /= 10;
        }
        Decimal=decimalNumber;
        Hexa=Integer.toHexString(decimalNumber);
        i = 1;

        while (decimalNumber != 0)
        {
            octalNumber += (decimalNumber % 8) * i;
            decimalNumber /= 8;
            i *= 10;
        }

         Octal= octalNumber;
    }

    }


