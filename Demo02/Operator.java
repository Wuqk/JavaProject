package day0118.Demo02;

import java.util.ArrayList;
import java.util.Scanner;

public class Operator {
    private ArrayList<Person> person_list;
    private UtilIo mutilio;

    public Operator() throws Exception {
        mutilio = new UtilIo();
        mutilio.SetFileName("perdeson_info.txt");
        person_list = new ArrayList<Person>();
        person_list = mutilio.Reader();
    }

    public void Add(Person person) throws Exception {
        System.out.println("Operator Add:" + this.person_list.size());
        this.person_list.add(person);
        mutilio.Write(this.person_list);
        System.out.println("Operator Adder:" + this.person_list.size());
    }

    public void Del(String strName) throws Exception {
        System.out.println("Operator Del.");
        ArrayList<Person> person_list = mutilio.Reader();
        boolean isFind = false;
        for (int i = 0; i < person_list.size(); i++)
            if (person_list.get(i).GetName().equals(strName)) {
                System.out.println("是否确定删除该条信息？1、是   2、否");
                Scanner scan = new Scanner(System.in);
                int choose = scan.nextInt();
                if (choose == 1) {
                    this.person_list.remove(this.person_list.get(i));
                    //System.out.println(this.person_list);
                    mutilio.Write(this.person_list);
                    System.out.println("删除成功！");
                    isFind = true;
                } else if (choose == 2) {
                    break;
                }
            }
        if (!isFind) {
            System.out.println("No Find Info:" + strName);
        }
    }

    public void Modi(String strName) throws Exception {
        System.out.println("Operator Modi.");
        //mutilio.Write(person);
        ArrayList<Person> person_list = mutilio.Reader();
        boolean isFind = false;
        for (int i = 0; i < person_list.size(); i++)
            if (person_list.get(i).GetName().equals(strName)) {
                System.out.println("请输入修改之后的年龄：");
                Scanner scanner = new Scanner(System.in);
                int mAge = scanner.nextInt();
                //this.person_list.set(i,(new Person(strName,mAge)));
                this.person_list.get(i).SetAge(mAge);
                mutilio.Write(this.person_list);
                isFind = true;
                System.out.println("修改成功！");
            }
        if (!isFind) {
            System.out.println("No Find Info:" + strName);
        }
    }

    public void DisplayAll() throws Exception {
        ArrayList<Person> person_list = mutilio.Reader();
        for (int i = 0; i < person_list.size(); i++) {
            System.out.println("Find result:" + person_list.get(i));
        }
    }

    public void Find(String strName) throws Exception {
        System.out.println("Operator Find.");
        //System.out.println(mutilio.Reader());
        ArrayList<Person> person_list = mutilio.Reader();
        boolean isFind = false;
        for (int i = 0; i < person_list.size(); i++) {
            if (person_list.get(i).GetName().equals(strName)) {
                System.out.println("Find result:" + person_list.get(i));
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("No Find Info:" + strName);
        }
    }
}
