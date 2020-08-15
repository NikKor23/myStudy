package com.company;

public class Main {

    public static void main(String[] args) {
        String name = "Вася 5000 рублей, Петя - 7500 рублей, а Маша - 30000 рублей";
        getPayNew(name);
        getPay(name);
    }

    public static void getPayNew(String string){
      string = string.replaceAll("[^0-9]", " ");
      string = string.trim();
      String substring;
      int sum = 0;

      while (string != "") {
          string = string.trim();
          int spaceIndex = string.indexOf(" ");
          if (spaceIndex == -1) {
              substring = string;
              string = "";
          }
          else {
              substring = string.substring(0, spaceIndex);
              string = string.replaceAll(string.substring(0, spaceIndex), "");
          }
          sum += Integer.parseInt(substring);
      }
      System.out.println(sum);
    }

    public static void getPay(String string){
        int sum = 0;

        while (string != "") {
            String substr;
            string = string.trim();
            int s = string.indexOf(" ");
            if (s == -1) {
                 substr = string;
            }
            else substr = string.substring(0, s);
            substr = substr.trim();
            String p = "";
            for (int i = 0; i <= substr.length() - 1; i++){
                if (Character.isDigit(substr.charAt(i))) {
                    p = p + substr.charAt(i);
                }
                else {
                    p = "";
                    string = string.replace(substr, "");
                }
            }
            if (p != "") {
                sum = sum + Integer.parseInt(p);
                string = string.replace(substr, "");
            }
        }
        System.out.println(sum);

    }
}
