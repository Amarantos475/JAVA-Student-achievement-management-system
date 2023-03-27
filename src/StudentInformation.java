import java.util.ArrayList;
import java.util.Scanner;

public class StudentInformation {
    String name;
    String gender;
    String id;
    String major;
    String phone;
    String address;
    String age;
    String classes;
    public static final ArrayList<StudentInformation> studentInformation = new ArrayList<>();

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id name gender major phone address age class:");
        id = scanner.next();
        name = scanner.next();
        gender = scanner.next();
        major = scanner.next();
        phone = scanner.next();
        address = scanner.next();
        age = scanner.next();
        classes = scanner.next();

        StudentGrade stu = new StudentGrade();
        System.out.println("Please enter the grade Chinese math English:");
        stu.chinese = (int) scanner.nextDouble();
        stu.math = (int) scanner.nextDouble();
        stu.english = (int) scanner.nextDouble();
        stu.sum = stu.chinese + stu.math + stu.english;
        System.out.println("Enter successfully");
        stu.id = id;
        stu.name = name;
        StudentGrade.studentGrade.add(stu);
    }

    public void output() {
        System.out.println("name: " + name);
        System.out.println("gender: " + gender);
        System.out.println("id: " + id);
        System.out.println("major: " + major);
        System.out.println("phone: " + phone);
        System.out.println("address: " + address);
        System.out.println("age: " + age);
        System.out.println("class: " + classes);
    }

    public void outputAll() {
        System.out.println(name + " " + gender + " " + id + " " + major + " " + phone + " " + address + " " + age + " " + classes);
    }

    public void change() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the information number you want to modify:");
        System.out.println("1.name");
        System.out.println("2.gender");
        System.out.println("3.id");
        System.out.println("4.major");
        System.out.println("5.phone");
        System.out.println("6.address");
        System.out.println("7.age");
        System.out.println("8.class");
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                System.out.println("Please enter your modified name:");
                name = scanner.next();
            }
            case 2 -> {
                System.out.println("Please enter your modified gender:");
                gender = scanner.next();
            }
            case 3 -> {
                System.out.println("Please enter your modified id:");
                id = scanner.next();
            }
            case 4 -> {
                System.out.println("Please enter your modified major:");
                major = scanner.next();
            }
            case 5 -> {
                System.out.println("Please enter your modified phone:");
                phone = scanner.next();
            }
            case 6 -> {
                System.out.println("Please enter your modified address:");
                address = scanner.next();
            }
            case 7 -> {
                System.out.println("Please enter your modified age:");
                age = scanner.next();
            }
            case 8 -> {
                System.out.println("Please enter your modified classes:");
                classes = scanner.next();
            }
        }
    }

    public static void studentInput() {
        StudentInformation stu = new StudentInformation();
        System.out.println("Please enter the number of student information you want to enter:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            stu.input();
            studentInformation.add(stu);
        }
        System.out.println("Student information added successfully!");
    }

    public static void studentAdd() {
        StudentInformation stu = new StudentInformation();
        stu.input();
        studentInformation.add(stu);
        System.out.println("Student information added successfully!");
    }

    public static void studentDelete() {
        System.out.println("Please enter your student id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        boolean found = false;
        for (StudentInformation student : studentInformation) {
            if (student.id.equals(id)) {
                found = true;
                System.out.println("The information of the student to be deleted has been queried");
                studentInformation.remove(student);
                break;
            }
        }
        if (!found) {
            System.out.println("Failed to delete the student information");
        }
    }

    public static void studentFind() {
        System.out.println("Please enter the id of the student you are looking for");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        boolean found = false;
        for (StudentInformation student : studentInformation) {
            if (student.id.equals(id)) {
                found = true;
                System.out.println("The queried student information has been found");
                student.output();
                break;
            }
        }
        if (!found) {
            System.out.println("Failed to find the student information");
        }
    }
    public static void studentChange() {
        System.out.println("Please enter your student id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int f = 0;
        for (StudentInformation i : studentInformation) {
            if (i.id.equals(id)) {
                f = 1;
                i.change();
                System.out.println("Succeeded in modifying the information!");
            }
        }
        if (f == 0) {
            System.out.println("Failed to find the student information");
        }
    }

    public static void studentGradeDisplay() {
        System.out.println("id name sum chinese math english");
        for (StudentGrade x : StudentGrade.studentGrade) {
            System.out.println(x.id + " " + x.name + " " + x.sum + " " + x.chinese + " " + x.math + " " + x.english);
        }
    }

    static void studentSort() {
        System.out.println("Please enter the information you want to rank according to:");
        System.out.println("1.sum");
        System.out.println("2.math");
        System.out.println("3.english");
        System.out.println("4.chinese");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> StudentGrade.studentGrade.sort((a, b) -> Integer.compare(b.sum, a.sum));
            case 2 -> StudentGrade.studentGrade.sort((a, b) -> Integer.compare(b.math, a.math));
            case 3 -> StudentGrade.studentGrade.sort((a, b) -> Integer.compare(b.english, a.english));
            case 4 -> StudentGrade.studentGrade.sort((a, b) -> Integer.compare(b.chinese, a.chinese));
        }
        System.out.println("Sort success!");
        studentGradeDisplay();
    }

    static void studentQualified() {
        int c1 = 0, c2 = 0, c3 = 0, n = StudentGrade.studentGrade.size();
        for (StudentGrade x : StudentGrade.studentGrade) {
            if (x.chinese >= 60)
                c1++;
            if (x.math >= 60)
                c2++;
            if (x.english >= 60)
                c3++;
        }
        System.out.printf("Chinese pass rate: %.2f%%%n", (double) c1 / n * 100);
        System.out.printf("Math pass rate: %.2f%%%n", (double) c2 / n * 100);
        System.out.printf("English pass rate: %.2f%%%n", (double) c3 / n * 100);
    }
    static void studentInformation() {
        System.out.println("Please enter your student id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int f = 0;
        for (StudentGrade i : StudentGrade.studentGrade) {
            if (i.id.equals(id)) {
                f = 1;
                i.output();
                break;
            }
        }
        if (f == 0) {
            System.out.println("Failed to find the student information");
        }
    }

    public static void studentInformationAll() {
        System.out.println("name gender id major phone address age classes:");
        for (StudentInformation student : studentInformation) {
            student.outputAll();
        }
    }

    static void studentGradeChange() {
        System.out.println("Please enter your student id");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        int f = 0;
        for (StudentGrade i : StudentGrade.studentGrade) {
            if (i.id.equals(id)) {
                f = 1;
                System.out.println("1.change grade\n2.delete grade");
                int x = scanner.nextInt();
                if (x == 1) {
                    i.studentGradeChange();
                } else {
                    StudentGrade.studentGrade.remove(i);
                    System.out.println("Deleted successfully!");
                }
                break;
            }
        }
        if (f == 0) {
            System.out.println("Failed to find the student information");
        }
    }
}
