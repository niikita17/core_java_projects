import java.util.*;

class Student {
    private int id;
    private String name;
    private int grades;
    private int feesTotal;
    private int feesPaid;

    public Student(int id, String name, int grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.feesPaid = 0;
        this.feesTotal = 30000;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public void payFees(int fees) {
        this.feesPaid = this.feesPaid + fees;
        School.updateTotalMoneyEarned(fees);
    }

    public int getId() {
        return id;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public String getName() {
        return name;
    }

    public int getGrades() {
        return grades;
    }

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    public String toString() {
        return "Student name is : " + name + " , roll no.: " + id + " , grade: " + grades + " and fees paid is : "
                + feesPaid + "";
    }
}

class Teacher {
    private int id;
    private String name;
    private int salary;

    public Teacher(int id, String name, int salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        School.updateTotalMoneySpent(this.salary);
        return salary;

    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
        School.updateTotalMoneySpent(salary);
    }

    public String toString() {
        return "Teacher name is : " + name + " , teacher id.: " + id + " and salary is : "
                + salary + "";
    }
}

class School {
    private List<Teacher> teachers;
    private List<Student> students;
    private static int TotalMoneyEarned;
    private static int TotalMoneySpent;

    public School(List<Teacher> teacher, List<Student> student) {
        this.teachers = teacher;
        this.students = student;
        TotalMoneySpent = 0;
        TotalMoneyEarned = 0;

    }

    public void setTeachers(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getTeacher() {
        return teachers;
    }

    public void setStudent(Student student) {
        students.add(student);

    }

    public List<Student> getStudent() {
        return students;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        TotalMoneyEarned += MoneyEarned;
    }

    public int GetTotalMoneyEarned() {
        return TotalMoneyEarned;
    }

    public static void updateTotalMoneySpent(int MoneySpent) {
        TotalMoneySpent += MoneySpent;
    }

    public int GetTotalMoneySpent() {
        return TotalMoneySpent;
    }

}

public class Main {
    public static void main(String[] args) {
        Teacher lizzy = new Teacher(101, "lizzy", 300);
        Teacher mellisa = new Teacher(102, "mellisa", 350);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(lizzy);
        teacherList.add(mellisa);

        Student jonh = new Student(10001, "jonh", 4);
        Student erica = new Student(10002, "erica", 3);
        List<Student> studentList = new ArrayList<>();
        studentList.add(jonh);
        studentList.add(erica);

        School s1 = new School(teacherList, studentList);
        System.out.println(" intitially fees earned by school : RS. " + s1.GetTotalMoneyEarned());

        jonh.payFees(1000);
        erica.payFees(1000);

        System.out.println(" fees earned by school : RS. " + s1.GetTotalMoneyEarned());
        // System.out.println(" salary of teacher : " + lizzy.getSalary());

        System.out.println("Money Spent by School : Rs. " + s1.GetTotalMoneySpent());
        System.out.println(jonh.toString());
        System.out.println(lizzy.toString());

    }
}