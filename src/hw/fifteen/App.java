package hw.fifteen;

import java.util.*;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toMap;

public class App
{
    public static void main(String[] args)
    {
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().name("name1").age(1).mark(11).build());
        studentList.add(Student.builder().name("name3").age(3).mark(33).build());
        studentList.add(Student.builder().name("name2").age(2).mark(22).build());
        studentList.add(Student.builder().name("name4").age(4).mark(44).build());
        studentList.add(Student.builder().name("name5").age(5).mark(55).build());


        //1 get set of students' names
        Set<String> studentNames = studentList.stream().map(Student::getName).collect(toSet());
        System.out.println("Set of students' names:");
        System.out.println(studentNames);
        System.out.println();

        //2get map <studentName, student>
        Map<String,Student> studentMap = studentList.stream().collect(toMap(Student::getName, student->student));
        System.out.println("Map <studentName,Student>:");
        studentMap.forEach((name,student)-> System.out.println(String.format("%s = %s", name, student.toString())));
        System.out.println();

        //3get list of students sorted by age
        List<Student> sortedStudentList = new LinkedList<>(studentList);
        sortedStudentList.sort(Comparator.comparingDouble(Student::getAge));
        System.out.println("List of students, sorted by age:");
        System.out.println(sortedStudentList);
        System.out.println();

        //4 count students
        System.out.println("Number of students:");
        System.out.println(studentList.stream().count());
        System.out.println();

        //5 count unique students
        studentList.add(Student.builder().name("name5").age(5).mark(55).build());
        System.out.println("Number of unique students:");
        System.out.println(studentList.stream().distinct().count());
        System.out.println();

        //6 transform map from #2 to set of ages
        Set<Double> studentAges = studentMap.values().stream().map(Student::getAge).collect(toSet());
        System.out.println("Set of students' ages:");
        studentAges.forEach(System.out::println);
    }
}
