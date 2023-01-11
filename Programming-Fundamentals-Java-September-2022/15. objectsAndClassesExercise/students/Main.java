package objectsAndClassesExercise.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentsList = new ArrayList<>();

        for (int studentCount = 1; studentCount <= countStudents; studentCount++) {
            String data = scanner.nextLine();
            //"Desislava Topuzakova 5.60"
            String [] dataParts = data.split(" "); // ["Desislava", "Topuzakova", "5.60"]
            String firstName = dataParts[0];
            String lastName = dataParts[1];
            double grade = Double.parseDouble(dataParts[2]);

            Student student = new Student(firstName, lastName, grade);
            studentsList.add(student);
        }

        //списък със студенти
        //1. сортира по оценка
        studentsList.sort(Comparator.comparing(Student::getGrade).reversed());
        //2. отпечатвам всеки един студент
        for (Student student : studentsList) {
            //"{first name} {second name}: {grade}"
            System.out.println(student); //обект се преобразува в текст чрез toString
        }
    }
}
