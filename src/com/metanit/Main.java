package com.metanit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение вида 5+4, числа должны быть целыми от 1 до 10 включительно: \n");
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;
        String oper = "";
        String input = sc.next();

        try {
            String[] strings = input.split("\\W");
            String[] operator = input.split("\\w");
            oper = operator[operator.length - 1];
            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[1]);
            } catch (Exception e) {}
            if (strings.length != 2) {
                throw new Exception();
            }
            if ( a<11 && a>0 && b<11 && b>0 ) {
                System.out.println("Результат = " + operation(a, b, oper));
            }
            else  {
                a = RomanArabicConverter.romanToArabic(strings[0]);
                b = RomanArabicConverter.romanToArabic(strings[1]);
                if ( a<11 && a>0 && b<11 && b>0 ) {
                    System.out.println("Результат = " + RomanArabicConverter.arabicToRoman(operation(a, b, oper)));
                }
                else{
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            System.out.println("Числа должны быть целыми от 1 до 10 включительно");
        }
    }

    private static int operation(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                throw new Exception();
        }
    }
}