import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrade {

    public String id, name;
    public int chinese, english, math, sum;
    public static final ArrayList<StudentGrade> studentGrade = new ArrayList<>();

    public void output() {
        System.out.println("id name chinese math english:");
        System.out.println(id + " " + name + " " + chinese + " " + math + " " + english);
    }

    public void studentGradeChange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.chinese grade");
        System.out.println("2.math grade");
        System.out.println("3.english grade");
        int x = scanner.nextInt();
        System.out.println("Please enter the grade you want to modify");
        switch (x) {
            case 1 -> chinese = scanner.nextInt();
            case 2 -> math = scanner.nextInt();
            case 3 -> english = scanner.nextInt();
        }
        sum = chinese + math + english;
    }
}
