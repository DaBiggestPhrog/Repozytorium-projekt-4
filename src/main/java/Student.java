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
}
