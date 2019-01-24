package Bank;

import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Operator {
    public Storage mStorage = null;
    ArrayList<User> userList = new ArrayList<User>();
    public static int i = 0;
    public static BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    public Operator(){
        mStorage = new Storage();
    }
    public void Login(){
        try {
            System.out.println("请输入用户名：");
            String name = buf.readLine();
            System.out.println("请输入密码：");
            String pwd = buf.readLine();
            boolean flag = false;
            userList = mStorage.Read();
            for (i=0 ;i<userList.size();++i){
                if (userList.get(i).getName().equals(name)&userList.get(i).getPwd().equals(pwd)){
                    flag = true;
                    Menu.choose=3;
                    System.out.println("登录成功！正在连接！");
                    System.out.println("wait......");
                    Thread.sleep(3000);
                    System.out.println("这破机器！半天连不上！");
                    Thread.sleep(1000);
                    break;
                }
            }
            if (!flag){
                System.out.println("用户名或密码输入错误！\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    用户注册
     */
    public void Rrgiser(){
        try{
            System.out.println("请输入用户名：");
            String name = buf.readLine();
            System.out.println("请输入密码：");
            String pwd = buf.readLine();
            System.out.println("请输入密码：");
            String pwdcheck= buf.readLine();
            if (pwd.equals(pwdcheck)){
                userList.add(new User(name,pwd));
                mStorage.write(userList);
                System.out.println("注册成功，请前往登录！\n");
                Menu.choose = 1;
            }else {
                System.out.println("两次输入密码不一致，请重新操作！\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void serarch(){
        System.out.println("余额为："+userList.get(i).getMoney());
        System.out.println("");
    }
    public void addMoney(){
        System.out.println("请输入存款金额：");
        try {
            float aMoney = Integer.parseInt(buf.readLine());
            if (aMoney>=0){
                userList.get(i).setMoney(userList.get(i).getMoney()+aMoney);
                mStorage.write(userList);
                System.out.println("存款成功！");
                System.out.println("当前余额为："+userList.get(i).getMoney());
                System.out.println("");
            }else {
                System.out.println("输入金额不合法！\n");
            }
        }catch (Exception e){
            System.out.println("输入金额不合法！\n");
        }
    }
    public void useMoney(){
        System.out.println("请输入取款金额：");
        try {
            float uMoney = Integer.parseInt(buf.readLine());
            if (uMoney>=0){
                userList.get(i).setMoney(userList.get(i).getMoney()-uMoney);
                mStorage.write(userList);
                System.out.println("取款成功！");
                System.out.println("当前余额为："+userList.get(i).getMoney());
                System.out.println("");
            }else {
                System.out.println("输入金额不合法！\n");
            }
        }catch (Exception e){
            System.out.println("输入金额不合法！\n");
        }

    }
    public void changMoney(){
        System.out.println("请输入要转帐的用户名：");
        try {
            String name = buf.readLine();
            boolean check = false;
            for (int j=0;j<userList.size();++j){
                if (userList.get(i).getName().equals(name)){
                    System.out.println("不能给自己转账！\n");
                    check = true;
                    break;
                }else if (userList.get(j).getName().equals(name)){
                    check = true;
                    System.out.println("请输入要转帐的金额：");
                    float cMoney = Integer.parseInt(buf.readLine());
                    if (cMoney>0){
                        if (cMoney<=userList.get(i).getMoney()) {
                            userList.get(i).setMoney(userList.get(i).getMoney() - cMoney);
                            userList.get(j).setMoney(userList.get(j).getMoney() + cMoney);
                            mStorage.write(userList);
                            System.out.println("转账成功！\n");
                            break;
                        }else {
                            System.out.println("余额不足！\n");
                            break;
                        }
                    }else {
                        System.out.println("输入金额不合法！\n");
                        break;
                    }
                }
            }
            if (!check){
                System.out.println("不存在该用户！\n");
            }
        }catch (Exception e){
            System.out.println("输入金额不合法！\n");
        }
    }
    public boolean isFind(String name){
        ArrayList<User> userList = new ArrayList<User>();
        userList = mStorage.Read();
        boolean flag = false;
        for (int i = 0;i<userList.size();++i){
            if (userList.get(i).getName().equals(name)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
