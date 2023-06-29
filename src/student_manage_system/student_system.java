package student_manage_system;

import java.util.Scanner;
//未完成
public class student_system {
    public static void main(String[] args) {
        loop: while (true) {
            System.out.println("-----学生管理系统-----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择：");
            Scanner sc=new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1"-> addStudent();
                case "2"-> deleteStudent();
                case "3"-> updateStudent();
                case "4"-> queryStudent();
                case "5"-> {
                    System.out.println("退出");
                    //break loop;
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    public static void addStudent(){
        System.out.println("添加学生");
    }

    public static void deleteStudent(){
        System.out.println("删除学生");
    }

    public static void updateStudent(){
        System.out.println("修改学生");
    }

    public static void queryStudent(){
        System.out.println("查询学生");
    }
}
