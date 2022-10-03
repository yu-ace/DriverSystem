package com.zyk.driveschoolmanagermentsystem.dao;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONUtil;
import com.zyk.driveschoolmanagermentsystem.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static void save(List<Student> studentList){
        String s = JSONUtil.toJsonStr(studentList);
        FileWriter writer = new FileWriter(FileUtil.getUserHomePath()+"/dsm/data");

        writer.write(s);
    }

    public static List<Student> load(){
        try {
            FileReader fileReader = new FileReader(FileUtil.getUserHomePath()+"/dsm/data");
            String result = fileReader.readString();
            List<Student> students = JSONUtil.toList(result, Student.class);
            return students;
        }catch (Exception ex){
            return new ArrayList<>();
        }
    }
}
