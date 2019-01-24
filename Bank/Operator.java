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
            System.out.println("�������û�����");
            String name = buf.readLine();
            System.out.println("���������룺");
            String pwd = buf.readLine();
            boolean flag = false;
            userList = mStorage.Read();
            for (i=0 ;i<userList.size();++i){
                if (userList.get(i).getName().equals(name)&userList.get(i).getPwd().equals(pwd)){
                    flag = true;
                    Menu.choose=3;
                    System.out.println("��¼�ɹ����������ӣ�");
                    System.out.println("wait......");
                    Thread.sleep(3000);
                    System.out.println("���ƻ��������������ϣ�");
                    Thread.sleep(1000);
                    break;
                }
            }
            if (!flag){
                System.out.println("�û����������������\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
    �û�ע��
     */
    public void Rrgiser(){
        try{
            System.out.println("�������û�����");
            String name = buf.readLine();
            System.out.println("���������룺");
            String pwd = buf.readLine();
            System.out.println("���������룺");
            String pwdcheck= buf.readLine();
            if (pwd.equals(pwdcheck)){
                userList.add(new User(name,pwd));
                mStorage.write(userList);
                System.out.println("ע��ɹ�����ǰ����¼��\n");
                Menu.choose = 1;
            }else {
                System.out.println("�����������벻һ�£������²�����\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void serarch(){
        System.out.println("���Ϊ��"+userList.get(i).getMoney());
        System.out.println("");
    }
    public void addMoney(){
        System.out.println("���������");
        try {
            float aMoney = Integer.parseInt(buf.readLine());
            if (aMoney>=0){
                userList.get(i).setMoney(userList.get(i).getMoney()+aMoney);
                mStorage.write(userList);
                System.out.println("���ɹ���");
                System.out.println("��ǰ���Ϊ��"+userList.get(i).getMoney());
                System.out.println("");
            }else {
                System.out.println("������Ϸ���\n");
            }
        }catch (Exception e){
            System.out.println("������Ϸ���\n");
        }
    }
    public void useMoney(){
        System.out.println("������ȡ���");
        try {
            float uMoney = Integer.parseInt(buf.readLine());
            if (uMoney>=0){
                userList.get(i).setMoney(userList.get(i).getMoney()-uMoney);
                mStorage.write(userList);
                System.out.println("ȡ��ɹ���");
                System.out.println("��ǰ���Ϊ��"+userList.get(i).getMoney());
                System.out.println("");
            }else {
                System.out.println("������Ϸ���\n");
            }
        }catch (Exception e){
            System.out.println("������Ϸ���\n");
        }

    }
    public void changMoney(){
        System.out.println("������Ҫת�ʵ��û�����");
        try {
            String name = buf.readLine();
            boolean check = false;
            for (int j=0;j<userList.size();++j){
                if (userList.get(i).getName().equals(name)){
                    System.out.println("���ܸ��Լ�ת�ˣ�\n");
                    check = true;
                    break;
                }else if (userList.get(j).getName().equals(name)){
                    check = true;
                    System.out.println("������Ҫת�ʵĽ�");
                    float cMoney = Integer.parseInt(buf.readLine());
                    if (cMoney>0){
                        if (cMoney<=userList.get(i).getMoney()) {
                            userList.get(i).setMoney(userList.get(i).getMoney() - cMoney);
                            userList.get(j).setMoney(userList.get(j).getMoney() + cMoney);
                            mStorage.write(userList);
                            System.out.println("ת�˳ɹ���\n");
                            break;
                        }else {
                            System.out.println("���㣡\n");
                            break;
                        }
                    }else {
                        System.out.println("������Ϸ���\n");
                        break;
                    }
                }
            }
            if (!check){
                System.out.println("�����ڸ��û���\n");
            }
        }catch (Exception e){
            System.out.println("������Ϸ���\n");
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
