import java.util.ArrayList;
import java.util.Scanner;

public class TeacherInformation extends StudentInformation {
    public static final ArrayList<TeacherInformation> teacherInformation = new ArrayList<>();
    public final ArrayList<String> classes = new ArrayList<>();

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name gender id major phone address age class:");
        name = scanner.next();
        gender = scanner.next();
        id = scanner.next();
        major = scanner.next();
        phone = scanner.next();
        address = scanner.next();
        age = String.valueOf(scanner.nextInt());
        String class1 = scanner.next();
        classes.add(class1);
    }

    public void output() {
        System.out.println("name: " + name);
        System.out.println("gender: " + gender);
        System.out.println("id: " + id);
        System.out.println("major: " + major);
        System.out.println("phone: " + phone);
        System.out.println("address: " + address);
        System.out.println("age: " + age);
        System.out.print("class: ");
        for (String x : classes) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public void outputAll() {
        System.out.print(name + " " + gender + " " + id + " " + major + " " + phone + " " + address + " " + age + " ");
        for (String x : classes) {
            System.out.print(x + ", ");
        }
        System.out.println();
    }

    public void classDelete() {
        int j = 1, x;
        for (String className : classes) {
            System.out.println(j + " " + className);
            j++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter delete classes:");
        x = scanner.nextInt();
        j = 1;
        for (int i = 0; i < classes.size(); i++) {
            if (x == j) {
                classes.remove(i);
                System.out.println("successfully delete class!");
                break;
            }
            j++;
        }
    }

    public void change() {
        int x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the information number you want to modify:");
        System.out.println("1.name");
        System.out.println("2.gender");
        System.out.println("3.id");
        System.out.println("4.major");
        System.out.println("5.phone");
        System.out.println("6.address");
        System.out.println("7.age");
        System.out.println("8.add class");
        System.out.println("9.delete class");
        x = scanner.nextInt();
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
                age = String.valueOf(scanner.nextInt());
            }
            case 8 -> {
                System.out.println("Please enter your modified classes:");
                String class1 = scanner.next();
                classes.add(class1);
            }
            case 9 -> {
                System.out.println("Please enter delete classes:");
                classDelete();
            }
        }
    }

    public static void teacherInput() {
        TeacherInformation teacher = new TeacherInformation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of teacher information you want to enter:");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            teacher.input();
            teacherInformation.add(teacher);
        }
        System.out.println("Teacher information added successfully!");
    }

    public static void teacherAdd() {
        TeacherInformation teacher = new TeacherInformation();
        teacher.input();
        teacherInformation.add(teacher);
        System.out.println("Teacher information added successfully!");
    }

    public static void teacherDelete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your teacher id");
        String id = scanner.next();
        boolean found = false;
        for (TeacherInformation teacher : teacherInformation) {
            if (teacher.id.equals(id)) {
                found = true;
                System.out.println("The information of the teacher to be deleted has been queried");
                teacherInformation.remove(teacher);
                break;
            }
        }
        if (!found) {
            System.out.println("Failed to delete the teacher information");
        }
    }

    public static void teacherFind() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the id of the teacher you are looking for");
        String id = scanner.next();
        boolean found = false;
        for (TeacherInformation teacher : teacherInformation) {
            if (teacher.id.equals(id)) {
                found = true;
                System.out.println("The queried teacher information has been found");
                teacher.output();
                break;
            }
        }
        if (!found) {
            System.out.println("Failed to find the teacher information");
        }
    }

    public static void teacherChange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your teacher id");
        String id = scanner.next();
        boolean found = false;
        for (TeacherInformation teacher : teacherInformation) {
            if (teacher.id.equals(id)) {
                found = true;
                teacher.change();
                System.out.println("Succeeded in modifying the information!");
                break;
            }
        }
        if (!found) {
            System.out.println("Failed to find the teacher information");
        }
    }

    public static void teacherInformationAll() {
        System.out.println("name gender id major phone address age classes:");
        for (TeacherInformation teacher : teacherInformation) {
            teacher.outputAll();
        }
    }

}
