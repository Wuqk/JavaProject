package Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    Operator mOperator = new Operator();
    public static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    public static int choose = 0;
    public void List(){
        while (true){
            System.out.println("=============CLAYϵͳ============");
            System.out.println("1���û���¼");
            System.out.println("2���û�ע��");
            System.out.println("");
            System.out.println("�����������ţ�");
           try{
               choose = Integer.parseInt(buf.readLine());
               if (choose!=3) {
                   if (choose == 1) {
                       mOperator.Login();
                   } else if (choose == 2) {
                       mOperator.Rrgiser();
                   } else {
                       System.out.println("�����ڸò�����");
                   }
                   if (choose == 3) {
                       display();
                   }
               }
           }catch (Exception e){
               System.out.println("�����ڸò�����");
           }
        }
    }
    public void display(){
        while (true) {
            System.out.println("=============CLAYϵͳ============");
            System.out.println("1����ѯ���");
            System.out.println("2�����");
            System.out.println("3��ȡ��");
            System.out.println("4��ת��");
            System.out.println("5���˳���¼");
            System.out.println("6���˳�ϵͳ\n");
            System.out.println("�����������ţ�");
            try {
                int nValue = Integer.parseInt(buf.readLine());
                this.Function(nValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void Function(int nValue){
        switch (nValue){
            case 1:{
                mOperator.serarch();
                break;
            }
            case 2:{
                mOperator.addMoney();
                break;
            }
            case 3:{
            mOperator.useMoney();
                break;
            }
            case 4:{
            mOperator.changMoney();
                break;
            }
            case 5:{
                this.List();
                break;
            }
            case 6:{
                System.exit(1);
                break;
            }
        }
    }
}
