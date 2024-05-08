/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Podaj imię studenta:");
      String name = reader.readLine();
      System.out.println("Podaj wiek studenta:");
      int age = Integer.parseInt(reader.readLine());

      s.addStudent(new Student(name, age));

      System.out.println("Nowy student został dodany do bazy danych.");
    } catch (IOException e) {
      System.out.println("Wystąpił błąd podczas dodawania nowego studenta do bazy danych: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("Wystąpił błąd podczas podawania wieku.");
    }
  }
}
