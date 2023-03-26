import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManipulation {
    public static void readData() {
        try {
            // Read student grades data
            String studentGradeFilePath = "student_Grade_file.txt";
            readOrCreateFile(studentGradeFilePath);
            BufferedReader studentGradeFile = new BufferedReader(new FileReader(studentGradeFilePath));
            String line;
            while ((line = studentGradeFile.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                String id = scanner.next();
                String name = scanner.next();
                int chinese = scanner.nextInt();
                int math = scanner.nextInt();
                int english = scanner.nextInt();
                int sum = scanner.nextInt();

                StudentGrade stu = new StudentGrade();
                stu.id = id;
                stu.name = name;
                stu.chinese = chinese;
                stu.math = math;
                stu.english = english;
                stu.sum = sum;
                StudentGrade.studentGrade.add(stu);

                scanner.close();
            }
            studentGradeFile.close();

            // Read student information data
            String studentInformationFilePath = "student_information_file.txt";
            readOrCreateFile(studentInformationFilePath);
            BufferedReader studentInformationFile = new BufferedReader(new FileReader(studentInformationFilePath));
            while ((line = studentInformationFile.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                StudentInformation stu = new StudentInformation();
                stu.name = scanner.next();
                stu.gender = scanner.next();
                stu.id = scanner.next();
                stu.major = scanner.next();
                stu.phone = scanner.next();
                stu.address = scanner.next();
                stu.age = String.valueOf(scanner.nextInt());
                stu.classes = scanner.next();

                StudentInformation.studentInformation.add(stu);
                scanner.close();
            }
            studentInformationFile.close();

            // Read teacher information data
            String teacherInformationFilePath = "teacher_information_file.txt";
            readOrCreateFile(teacherInformationFilePath);
            BufferedReader teacherInformationFile = new BufferedReader(new FileReader(teacherInformationFilePath));
            while ((line = teacherInformationFile.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                TeacherInformation teacher = new TeacherInformation();
                teacher.name = scanner.next();
                teacher.gender = scanner.next();
                teacher.id = scanner.next();
                teacher.major = scanner.next();
                teacher.phone = scanner.next();
                teacher.address = scanner.next();
                teacher.age = String.valueOf(scanner.nextInt());

                while (scanner.hasNext()) {
                    String class1 = scanner.next();
                    teacher.classes.add(class1);
                }
                TeacherInformation.teacherInformation.add(teacher);
                scanner.close();
            }
            teacherInformationFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readOrCreateFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);

        // Check if the file exists; if not, create the file
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.println("File created: " + filePath);
        }
    }
    public static void saveData() {
        try {
            // Save student grades data
            BufferedWriter studentGradeFile = new BufferedWriter(new FileWriter("student_Grade_file.txt"));
            for (StudentGrade x : StudentGrade.studentGrade) {
                studentGradeFile.write(x.id + " " + x.name + " " + x.chinese + " " + x.math + " " + x.english + " " + x.sum);
                studentGradeFile.newLine();
            }
            studentGradeFile.close();

            // Save student information data
            BufferedWriter studentInformationFile = new BufferedWriter(new FileWriter("student_information_file.txt"));
            for (StudentInformation x : StudentInformation.studentInformation) {
                studentInformationFile.write(x.name + " " + x.gender + " " + x.id + " " + x.major + " " + x.phone + " " + x.address + " " + x.age + " " + x.classes);
                studentInformationFile.newLine();
            }
            studentInformationFile.close();

            // Save teacher information data
            BufferedWriter teacherInformationFile = new BufferedWriter(new FileWriter("teacher_information_file.txt"));
            for (TeacherInformation x : TeacherInformation.teacherInformation) {
                teacherInformationFile.write(x.name + " " + x.gender + " " + x.id + " " + x.major + " " + x.phone + " " + x.address + " " + x.age + " ");
                for (String y : x.classes) {
                    teacherInformationFile.write(y + " ");
                }
                teacherInformationFile.newLine();
            }
            teacherInformationFile.close();

            StudentGrade.studentGrade.clear();
            StudentInformation.studentInformation.clear();
            TeacherInformation.teacherInformation.clear();
            readData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
