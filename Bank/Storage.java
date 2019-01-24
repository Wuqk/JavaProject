package Bank;

import java.io.*;
import java.util.ArrayList;

public class Storage {
    public Storage(){
        try {
            File f = new File("D:"+File.separator+"BankUser.txt");
            if (!f.exists()){
                f.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void write(ArrayList<User> mData){
        try {
            File f = new File("D:" + File.separator + "BankUser.txt");
            ObjectOutputStream oos = null;
            OutputStream out = new FileOutputStream(f);
            oos = new ObjectOutputStream(out);
            oos.writeObject(mData);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<User> Read(){
        ArrayList<User> UserList = new ArrayList<User>();
        try {
            File f = new File("D:"+File.separator+"BankUser.txt");
            ObjectInputStream ois = null;
            InputStream input = new FileInputStream(f);
            ois = new ObjectInputStream(input);
            UserList =(ArrayList<User>) ois.readObject();
            ois.close();
        }catch (Exception e){
        }
        return UserList;
    }
}
