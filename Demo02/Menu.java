package day0118.Demo02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Operator mOperator;

    public void List() throws Exception {
        mOperator = new Operator();
        Scanner scanner = new Scanner(System.in);
        int nValue = 0;
        while (true) {
            System.out.println("==========XXXϵͳ==========");
            System.out.println("1.��������");
            System.out.println("2.ɾ������");
            System.out.println("3.�޸�����");
            System.out.println("4.��������");
            System.out.println("5.��ʾ��������");
            System.out.println("0.�˳�ϵͳ\n");
            System.out.println("������ѡ���");
            nValue = scanner.nextInt();
            if (nValue == 0) {
                break;
            } else {
                this.Operator(nValue);
            }
        }
        System.exit(1);
    }

    public void Operator(int nValue) throws Exception {
        switch (nValue) {
            case 1: {
                BufferedReader buf = null;
                buf = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("�������û�����");
                String strValue = buf.readLine();

                System.out.println("���������䣺");
                int nAge = scanner.nextInt();
                Person nPerson = new Person(strValue, nAge);
                mOperator.Add(nPerson);
                break;
            }
            case 2: {
                mOperator.DisplayAll();
                BufferedReader buf = null;
                buf = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("������Ҫɾ�����û�����");
                String strValue = buf.readLine();
                mOperator.Del(strValue);
                break;
            }
            case 3: {
                mOperator.DisplayAll();
                BufferedReader buf = null;
                buf = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("������Ҫ�޸ĵ��û�����");
                String strValue = buf.readLine();
                mOperator.Modi(strValue);
                break;

            }
            case 4: {
                BufferedReader buf = null;
                buf = new BufferedReader(new InputStreamReader(System.in));
                Scanner scanner = new Scanner(System.in);
                System.out.println("�������û�����");
                String strValue = buf.readLine();
                mOperator.Find(strValue);
                break;
            }
            case 5: {
                mOperator.DisplayAll();
                break;
            }
            default: {
                System.out.println("No Find Data Value:" + nValue);
            }
        }
    }
}

