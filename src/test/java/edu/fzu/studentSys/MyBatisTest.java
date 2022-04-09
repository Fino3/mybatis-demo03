package edu.fzu.studentSys;

import edu.fzu.studentSys.pojo.Student;
import edu.fzu.studentSys.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findStudentByNameOrMajorTest() {
        SqlSession session = MyBatisUtils.getSqlSession();

        Student student1 = new Student();
        student1.setName("张三");

        Student student2 = new Student();
        student2.setMajor("软件工程");

        Student student3 = new Student();

        List<Student> students1 = session.selectList("edu.fzu.studentSys.mapper.StudentMapper.findStudent",student1);
        List<Student> students2 = session.selectList("edu.fzu.studentSys.mapper.StudentMapper.findStudent",student2);
        List<Student> students3 = session.selectList("edu.fzu.studentSys.mapper.StudentMapper.findStudent",student3);

        for (Student student : students1) {
            System.out.println(student);
        }
        System.out.println();
        for (Student student : students2) {
            System.out.println(student);
        }
        System.out.println();
        for (Student student : students3) {
            System.out.println(student);
        }

        //测试查询id<4的学生
        List<Integer> ids = new ArrayList<Integer>();
        for (int i=1;i<5;i++) {
            ids.add(i);
        }
        List<Student> students4 = session.selectList("edu.fzu.studentSys.mapper.StudentMapper.findByList",ids);
        for (Student student : students4) {
            System.out.println(student);
        }

        session.close();
    }

    @Test
    public void insertStudentTest() {
        SqlSession session = MyBatisUtils.getSqlSession();

        Student student = new Student();
        student.setName("张八");
        student.setId(7);
        student.setMajor("大数据");
        student.setSno("221900207");

        session.selectList("edu.fzu.studentSys.mapper.StudentMapper.insertStudent",student);

        Student student1 = new Student();
        List<Student> students1 = session.selectList("edu.fzu.studentSys.mapper.StudentMapper.findStudent",student1);

        for (Student student2 : students1) {
            System.out.println(student2);
        }

        session.close();
    }

}



//数据库
/*
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dm_student
-- ----------------------------
DROP TABLE IF EXISTS `dm_student`;
CREATE TABLE `dm_student`  (
  `id` int(0) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dm_student
-- ----------------------------
INSERT INTO `dm_student` VALUES (1, '张三', '软件工程', '221900201');
INSERT INTO `dm_student` VALUES (2, '李四', '计算机', '221900202');
INSERT INTO `dm_student` VALUES (3, '王五', '软件工程', '221900203');
INSERT INTO `dm_student` VALUES (4, '赵四', '大数据', '');
INSERT INTO `dm_student` VALUES (5, '钱六', '计算机', '221900205');
INSERT INTO `dm_student` VALUES (6, '孙七', '大数据', '221900206');

SET FOREIGN_KEY_CHECKS = 1;

 */