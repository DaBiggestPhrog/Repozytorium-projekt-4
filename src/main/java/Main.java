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
        System.out.println("3. Wyszukaj studenta po nazwisku");
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
            System.out.println("Podaj datę urodzenia studenta (dd.mm.yyyy):");
            String birthDate = reader.readLine();
            if (!Student.isValidDate(birthDate)) {
              System.out.println("Niepoprawna data. Spróbuj ponownie.");
              break;
            }
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
          case 3:
            System.out.println("Podaj nazwisko studenta do wyszukania:");
            String searchSurname = reader.readLine();
            Student foundStudent = s.findStudentByName(searchSurname);
            if (foundStudent != null) {
              System.out.println("Znaleziono studenta: " + foundStudent.toString());
            } else {
              System.out.println("Nie znaleziono studenta o nazwisku " + searchSurname);
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
