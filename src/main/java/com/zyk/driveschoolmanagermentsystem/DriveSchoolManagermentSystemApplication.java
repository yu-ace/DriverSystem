package com.zyk.driveschoolmanagermentsystem;

import com.zyk.driveschoolmanagermentsystem.model.Student;
import com.zyk.driveschoolmanagermentsystem.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DriveSchoolManagermentSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DriveSchoolManagermentSystemApplication.class, args);
    }

    Scanner scanner = new Scanner(System.in);
    @Override
    public void run(String... args) throws Exception {
        while (true){
            printHelp();
            String input = scanner.next();
            switch (input){
                case "1":
                    System.out.println("请输入学号");
                    String id = scanner.next();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    StudentService.reg(id,name);
                    break;
                case "2":
                    System.out.println("请输入学号");
                    String sid = scanner.next();
                    System.out.println("请输入科目几的成绩");
                    int n = scanner.nextInt();
                    System.out.println("请输入成绩");
                    int grade = scanner.nextInt();
                    StudentService.addGrade(sid,n,grade);
                    break;
                case "3":
                    List<Student> studentList = StudentService.getStudentList();
                    for (Student student : studentList) {
                        System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getJoinTime()+"\t" +
                                student.getClass1Grade()+"\t"+student.getClass2Grade()+"\t"
                        +student.getClass3Grade()+"\t"+student.getClass4Grade()+"\t");
                    }
                    break;
                case "4":
                    int[] averageGrade = StudentService.averageGrade();
                    for (int i = 0; i < averageGrade.length; i++) {
                        System.out.println("科目"+(i+1)+"的平均分是:"+averageGrade[i]);
                    }
                    break;
                case "5":
                    Student[] students = StudentService.max();
                    System.out.println("科目1"+"的最高分是:"+students[0].getClass1Grade()+" 由"+students[0].getName()+"创造");
                    System.out.println("科目2"+"的最高分是:"+students[1].getClass2Grade()+" 由"+students[1].getName()+"创造");
                    System.out.println("科目3"+"的最高分是:"+students[2].getClass3Grade()+" 由"+students[2].getName()+"创造");
                    System.out.println("科目4"+"的最高分是:"+students[3].getClass4Grade()+" 由"+students[3].getName()+"创造");
                    break;
                case "6":
                    Student[] students2 = StudentService.min();
                    System.out.println("科目1"+"的最低分是:"+students2[0].getClass1Grade()+" 由"+students2[0].getName()+"创造");
                    System.out.println("科目2"+"的最低分是:"+students2[1].getClass2Grade()+" 由"+students2[1].getName()+"创造");
                    System.out.println("科目3"+"的最低分是:"+students2[2].getClass3Grade()+" 由"+students2[2].getName()+"创造");
                    System.out.println("科目4"+"的最低分是:"+students2[3].getClass4Grade()+" 由"+students2[3].getName()+"创造");
                    break;
                case "7":
                    List<Student> passed = StudentService.passed();
                    for (Student student : passed) {
                        System.out.println(student.getName());
                    }
                    break;
                case "q":
                    System.exit(0);
                    break;
            }
        }
    }

    public void printHelp(){
        System.out.println("欢迎使用驾校管理系统");
        System.out.println("输入1 学员入学");
        System.out.println("输入2 录入学员成绩");
        System.out.println("输入3 查看学员列表");
        System.out.println("输入4 查看各个科目考试平均分");
        System.out.println("输入5 查看各个科目考试最高分");
        System.out.println("输入6 查看各个科目考试最低分");
        System.out.println("输入7 查看拿证的学生");
        System.out.println("输入q 退出");

    }
}
