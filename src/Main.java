import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("If there is no initial data, proceed and the file is automatically created");
        FileManipulation.readData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu();
            System.out.println("Please press Enter to continue");
            scanner.nextLine();
        }
    }
    public static void menu() {
        System.out.println("*===============================================================================================*");
        System.out.println("**&&&&&&&&&&&&&&& welcome to use the student information management system &&&&&&&&&&&&&&&&&&&&**");
        System.out.println("**                        0: exit                                                              **");
        System.out.println("**                        1: Input student information                                         **");
        System.out.println("**                        2: Add student information                                           **");
        System.out.println("**                        3: Delete student information                                        **");
        System.out.println("**                        4: Find student information                                          **");
        System.out.println("**                        5: Modify student information                                        **");
        System.out.println("**                        6: student achievement ranking                                       **");
        System.out.println("**                        7: show students queried                                             **");
        System.out.println("**                        8: Display student information                                       **");
        System.out.println("**                        9: Display all the student information                               **");
        System.out.println("**                        10: Modify student grade                                             **");
        System.out.println("**                        11: Display student grade                                            **");
        System.out.println("**                        12: Input teacher information                                        **");
        System.out.println("**                        13: Add teacher information                                          **");
        System.out.println("**                        14: Delete teacher information                                       **");
        System.out.println("**                        15: Find teacher information                                         **");
        System.out.println("**                        16: Modify teacher information                                       **");
        System.out.println("**                        17: Display all the teacher information                              **");
        System.out.println("**                        18: Save data                                                        **");
        System.out.println("**&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&**");
        System.out.println("*===============================================================================================*");

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        switch (x) {
            case 0 -> System.exit(0);
            case 1 -> StudentInformation.studentInput();
            case 2 -> StudentInformation.studentAdd();
            case 3 -> StudentInformation.studentDelete();
            case 4 -> StudentInformation.studentFind();
            case 5 -> StudentInformation.studentChange();
            case 6 -> StudentInformation.studentSort();
            case 7 -> StudentInformation.studentQualified();
            case 8 -> StudentInformation.studentInformation();
            case 9 -> StudentInformation.studentInformationAll();
            case 10 -> StudentInformation.studentGradeChange();
            case 11 -> StudentInformation.studentGradeDisplay();
            case 12 -> TeacherInformation.teacherInput();
            case 13 -> TeacherInformation.teacherAdd();
            case 14 -> TeacherInformation.teacherDelete();
            case 15 -> TeacherInformation.teacherFind();
            case 16 -> TeacherInformation.teacherChange();
            case 17 -> TeacherInformation.teacherInformationAll();
            case 18 -> FileManipulation.saveData();
            default -> System.out.println("Invalid input!");
        }
    }
}

