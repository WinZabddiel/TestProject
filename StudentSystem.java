package student.system;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        //创建学生集合
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎使用学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");

            System.out.println("请选择：");

            Scanner sc = new Scanner(System.in);
            int election = sc.nextInt();

            switch (election) {
                case 1 -> {
                    addStudent(array);
                    break;
                }
                case 2 -> {
                    deleteStudent(array);
                    break;
                }
                case 3 -> {
                    upgradeStudent(array);
                    break;
                }
                case 4 -> {
                    getStudent(array);
                    break;
                }
                case 5 -> {
                    //System.out.println("5 退出");
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
            }
        }

    }

    /**
     * 添加学生
     *
     * @param array
     */
    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        //给出相应提示，让用户输入学号
        System.out.println("请输入学号：");
        String sid = sc.nextLine();
        //做一个标记，用于判断学号是否重复
        boolean isFlag = true;
        //判断学号是否重复
        for(int i = 0; i < array.size(); i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                System.out.println("该学号已存在，请重新输入");
                //学号重复则将标记改为false，从而让程序无法执行下一步
                isFlag = false;
            }
        }
        //只有当isFlag == true时，才进行姓名，年龄，地址的录入
        while (isFlag) {
            System.out.println("请输入姓名：");
            String name = sc.nextLine();

            System.out.println("请输入年龄：");
            String age = sc.nextLine();

            System.out.println("请输入地址：");
            String address = sc.nextLine();

            Student s = new Student();

            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);

            array.add(s);

            System.out.println("添加学生成功");
            //将isFlag改为false，跳出while循环
            isFlag = false;
        }

    }

    /**
     * 查看所有学生
     *
     * @param array
     */
    public static void getStudent(ArrayList<Student> array) {
        //先判断库中是否存在学生数据
        if (array.size() == 0) {
            System.out.println("无信息，请添加信息再查询");
        } else {
            System.out.println("学号\t\t\t姓名\t\t年龄\t" + "\t地址");

            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getSid() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress() + "\t");
            }
        }
    }

    /**
     * 删除学生
     *
     * @param array
     */
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入待删学生学号：");
        String sid = sc.nextLine();
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
            }
        }
        if(index == -1){
            System.out.println("该信息不存在，请重新输入");
        }else{
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                if (s.getSid().equals(sid)) {
                    array.remove(index);
                }
            }
            System.out.println("删除学生成功");
        }


    }

    /**
     * 修改学生
     *
     * @param array
     */
    public static void upgradeStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入待修改的学生学号：");
        String sid = sc.nextLine();

        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("该信息不存在，请重新输入");
        } else {
            System.out.println("请输入新的学生姓名：");
            String name = sc.nextLine();
            System.out.println("请输入新的学生年龄：");
            String age = sc.nextLine();
            System.out.println("请输入新的学生地址：");
            String address = sc.nextLine();

            Student s = new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);

            for (int i = 0; i < array.size(); i++) {
                Student student = array.get(i);
                if (student.getSid().equals(sid)) {
                    array.set(i, s);
                    break;
                }
            }
            System.out.println("修改学生成功");
        }

    }
}


