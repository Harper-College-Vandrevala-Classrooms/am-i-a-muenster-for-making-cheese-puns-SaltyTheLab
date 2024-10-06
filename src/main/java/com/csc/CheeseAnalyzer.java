package com.csc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CheeseAnalyzer {

  private static String largest(int cow, int goat, int ewe, int buffalo) {
    int most;
    most = cow;
    if (goat > most)
      most = goat;
    if (ewe > most)
      most = ewe;
    if (buffalo > most)
      most = buffalo;
    if (most == cow)
      return "Cow";
    else if (most == goat)
      return "Goat";
    else if (most == ewe)
      return "Ewe";
    else if (most == buffalo)
      return "Buffalo";
    return " ";
  }

  public static boolean percentcheck(String x) {
    x = x.replaceAll("\\D+", "");
    String number = x.substring(0, x.length() - 1);
    if (number.length() < 2)
      return false;
    switch (number.length()) {
      case 2 -> {
        number = number.replace("0", "");
        String zero = "0";
        number = number + zero;
      }
      default -> {
        char[] characters = number.toCharArray();
        for (int i = 3; i < number.length(); i++)
          characters[i] = '0';
        number = new String(characters);
        while (number.length() != 3)
          number = number.substring(0, number.length() - 1);
      }
    }
    return Integer.parseInt(number) > 410;
  }

  public static void main(String[] args) throws IOException {
    String x;
    int milk = 0;
    int pasturized = 0;
    int cow = 0;
    int goat = 0;
    int ewe = 0;
    int buffalo = 0;
    int moisture = 0;
    try (BufferedReader eyes = new BufferedReader(new FileReader(
        "C:\\Users\\micha\\Documents\\Java stuff\\am-i-a-muenster-for-making-cheese-puns-SaltyTheLab\\cheese_data_without_ids.csv"));
        BufferedWriter cheese = new BufferedWriter(new FileWriter("output.txt"))) {
      while ((x = eyes.readLine()) != null) {
        if (x.contains("Raw Milk") == true)
          milk++;
        if (x.contains("Pasteurized") == true)
          pasturized++;
        if (x.contains("Cow") == true)
          cow++;
        if (x.contains("Goat") == true)
          goat++;
        if (x.contains("Ewe") == true)
          ewe++;
        if (x.contains("Buffalo") == true)
          buffalo++;
        if (x.contains(",1,") == true && percentcheck(x) == true)
          moisture++;
      }
      cheese.write(String.format(
          "Raw Milk : %d\nPasturized: %d\nThe Most Cheese comes from: %s\nOrganic cheeses with a moisture > 41 percent: %d",
          milk, pasturized, largest(cow, goat, ewe, buffalo), moisture));
    }
  }
}