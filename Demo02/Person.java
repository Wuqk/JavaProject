package day0118.Demo02;

import java.io.Serializable;

public class Person implements Serializable {
    public static final long serialVersionUID = 0b1L;
    private String name;    // ����name���ԣ����Ǵ����Բ������л�
    private int age;        // ����age����

    public Person(String name, int age) {    // ͨ��������������
        this.name = name;
        this.age = age;
    }

    public void SetAge(int nAge) {
        this.age = nAge;
    }

    public String GetName() {
        return this.name;
    }

    public String toString() {    // ��дtoString()����
        return "������" + this.name + "�����䣺" + this.age;
    }
};


