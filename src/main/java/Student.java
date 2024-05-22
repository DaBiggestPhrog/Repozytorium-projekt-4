public class Student {

  private String name;
  private String surname;
  private int age;
  private String birthDate;

  public Student(String name, String surname, int age, String birthDate) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getBirthDate() {
    return birthDate;
  }

  @Override
  public String toString() {
    return name + " " + surname + " " + age + " " + birthDate;
  }

  public static Student parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 4)
      throw new IllegalArgumentException("Invalid input data for Student");
    return new Student(data[0], data[1], Integer.parseInt(data[2]), data[3]);
  }

  // zabezpieczenie daty urodzenia
  // dni 1-21
  // miesiac 1-12
  // rok 1900-2024
  public static boolean isValidDate(String birthDate) {
    if (!birthDate.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
      return false;
    }

    String[] parts = birthDate.split("\\.");
    int day = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int year = Integer.parseInt(parts[2]);
    // zabezpieczenie zwykle wedlug podanych zakresow
    if (year < 1900 || year > 2024) {
      return false;
    }
    if (month < 1 || month > 12) {
      return false;
    }
    if (day < 1 || day > 31) {
      return false;
    }
    // zabezpieczenie miesiecy ktore maja 30 dni
    if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
      return false;
    }
    // zabezpieczenie miesieca lutego w rokach przestepnych
    if (month == 2) {
      boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
      if (day > 29 || (day == 29 && !isLeapYear)) {
        return false;
      }
    }
    return true;
  }
}
