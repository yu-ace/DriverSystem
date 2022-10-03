package com.zyk.driveschoolmanagermentsystem.service;


import com.zyk.driveschoolmanagermentsystem.dao.StudentDao;
import com.zyk.driveschoolmanagermentsystem.model.Student;

import java.util.*;

public class StudentService {

    static List<Student> studentList = StudentDao.load();

    public static Student reg(String id,String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setJoinTime(new Date());

        studentList.add(student);
        StudentDao.save(studentList);
        return student;
    }

    public static void addGrade(String id,int n,int grade){
        for (Student student : studentList) {
            if(student.getId().equals(id)){
                switch (n){
                    case 1:
                        student.setClass1Grade(grade);
                        break;
                    case 2:
                        student.setClass2Grade(grade);
                        break;
                    case 3:
                        student.setClass3Grade(grade);
                        break;
                    case 4:
                        student.setClass4Grade(grade);
                        break;
                }
            }
        }
        StudentDao.save(studentList);
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static int[] averageGrade(){
        int[] sum = new int[4];
        int[] num = new int[4];
        int[] result = new int[4];
        for (Student student : studentList) {
            if(student.getClass1Grade()!=0){
                sum[0] = sum[0] + student.getClass1Grade();
                num[0] = num[0] +1;
            }
            if(student.getClass2Grade()!=0){
                sum[1] = sum[1] + student.getClass2Grade();
                num[1] = num[1] +1;
            }
            if(student.getClass3Grade()!=0){
                sum[2] = sum[2] + student.getClass3Grade();
                num[2] = num[2] +1;
            }
            if(student.getClass4Grade()!=0){
                sum[3] = sum[3] + student.getClass4Grade();
                num[3] = num[3] +1;
            }
        }
        for (int i = 0; i < 4; i++) {
            if( num[i]!=0 ) {
                int avg = sum[i] / num[i];
                result[i] = avg;
            }else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static Student[] max(){
        Student[] result = new Student[4];
        List<Student> tmp = new ArrayList<>(studentList.size());
        tmp.addAll(studentList);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -1*Integer.compare(o1.getClass1Grade(), o2.getClass1Grade());
            }
        });
        result[0] = tmp.get(0);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -1*Integer.compare(o1.getClass2Grade(), o2.getClass2Grade());
            }
        });
        result[1] = tmp.get(0);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -1*Integer.compare(o1.getClass3Grade(), o2.getClass3Grade());
            }
        });
        result[2] = tmp.get(0);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -1*Integer.compare(o1.getClass4Grade(), o2.getClass4Grade());
            }
        });
        result[3] = tmp.get(0);
        return result;
    }

    public static Student[] min(){
        Student[] result = new Student[4];
        List<Student> tmp = new ArrayList<>(studentList.size());
        tmp.addAll(studentList);
        List<Student> delete = new ArrayList<>();
        for (Student student : tmp) {
            if(student.getClass1Grade() == 0){
                delete.add(student);
            }
        }
        tmp.removeAll(delete);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getClass1Grade(), o2.getClass1Grade());
            }
        });
        result[0] = tmp.get(0);

        delete = new ArrayList<>();
        for (Student student : tmp) {
            if(student.getClass2Grade() == 0){
                delete.add(student);
            }
        }
        tmp.removeAll(delete);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getClass2Grade(), o2.getClass2Grade());
            }
        });
        result[1] = tmp.get(0);

        delete = new ArrayList<>();
        for (Student student : tmp) {
            if(student.getClass3Grade() == 0){
                delete.add(student);
            }
        }
        tmp.removeAll(delete);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getClass3Grade(), o2.getClass3Grade());
            }
        });
        result[2] = tmp.get(0);

        delete = new ArrayList<>();
        for (Student student : tmp) {
            if(student.getClass4Grade() == 0){
                delete.add(student);
            }
        }
        tmp.removeAll(delete);
        tmp.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getClass4Grade(), o2.getClass4Grade());
            }
        });
        result[3] = tmp.get(0);
        return result;
    }

    public static List<Student> passed(){
        List<Student> passedStudentList = new ArrayList<>();
        for (Student student : studentList) {
            if(isPassed(student)){
                passedStudentList.add(student);
            }
        }
        return passedStudentList;
    }

    public static boolean isPassed(Student student) {
        return student.getClass1Grade() > 90
                && student.getClass2Grade() > 90
                && student.getClass3Grade() > 90
                && student.getClass4Grade() > 90;
    }
}
