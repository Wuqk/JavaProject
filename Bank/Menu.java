package Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Menu {
    Operator mOperator = new Operator();
    public static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    public static int choose = 0;
    public void List(){
        while (true){
            System.out.println("=============CLAY系统============");
            System.out.println("1、用户登录");
            System.out.println("2、用户注册");
            System.out.println("");
            System.out.println("请输入操作序号：");
           try{
               choose = Integer.parseInt(buf.readLine());
               if (choose!=3) {
                   if (choose == 1) {
                       mOperator.Login();
                   } else if (choose == 2) {
                       mOperator.Rrgiser();
                   } else {
                       System.out.println("不存在该操作！");
                   }
                   if (choose == 3) {
                       display();
                   }
               }
           }catch (Exception e){
               System.out.println("不存在该操作！");
           }
        }
    }
    public void display(){
        while (true) {
            System.out.println("=============CLAY系统============");
            System.out.println("1、查询余额");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、退出登录");
            System.out.println("6、退出系统\n");
            System.out.println("请输入操作序号：");
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
