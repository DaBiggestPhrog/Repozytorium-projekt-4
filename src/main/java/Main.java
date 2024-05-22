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
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      Service s = new Service();

      while (true) {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Dodaj nowego studenta");
        System.out.println("2. Wyświetl wszystkich studentów");
        System.out.println("0. Wyjdź");

        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
          case 1:
            System.out.println("Podaj imię studenta:");
            String name = reader.readLine();
            System.out.println("Podaj nazwisko studenta:");
            String surname = reader.readLine();
            System.out.println("Podaj wiek studenta:");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Podaj datę urodzenia studenta (yyyy-mm-dd):");
            String birthDate = reader.readLine();
            s.addStudent(new Student(name, surname, age, birthDate));
            System.out.println("Nowy student został dodany do bazy danych.");
            break;
          case 2:
            System.out.println("Lista wszystkich studentów:");
            var students = s.getStudents();
            for (Student student : students) {
              System.out.println(student.toString());
            }
            break;
          case 0:
            System.out.println("Koniec programu.");
            return;
          default:
            System.out.println("Niepoprawny wybór. Wybierz ponownie.");
            break;
        }
      }
    } catch (IOException e) {
      System.out.println("I/O ERROR: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.out.println("INVALID TYPE ERROR");
    }
  }
}
