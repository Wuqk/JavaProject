package Bank;

import java.io.Serializable;
public class User implements Serializable {

    public static final long serialVersionUID = 0b10011100L;
    private String name;
    private String pwd;
    private float money = 0f;
    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public void setMoney(float money){
        this.money = money;
    }
    public String getName(){
        return this.name;
    }
    public String getPwd(){
        return this.pwd;
    }
    public float getMoney(){
        return this.money;
    }
}

