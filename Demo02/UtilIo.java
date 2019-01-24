package day0118.Demo02;

import java.io.*;
import java.util.ArrayList;

public class UtilIo {
    private String mFileName;

    public void SetFileName(String fileName) {
        this.mFileName = fileName;
    }

    public void Write(ArrayList<Person> mData) throws Exception {
        File f = new File("D:" + File.separator + this.mFileName);    // ���屣��·��
        ObjectOutputStream oos = null;    // �������������
        OutputStream out = new FileOutputStream(f);    // �ļ������
        oos = new ObjectOutputStream(out);
        oos.writeObject(mData);    // �������
        oos.close();    // �ر�
    }

    public ArrayList<Person> Reader() throws Exception {
        ArrayList<Person> persons = new ArrayList<Person>();
        File f = new File("D:" + File.separator + this.mFileName);    // ���屣��·��
        ObjectInputStream ois = null;    // ��������������
        InputStream input = new FileInputStream(f);    // �ļ�������
        ois = new ObjectInputStream(input);    // ʵ��������������
        persons = (ArrayList<Person>) ois.readObject();    // ��ȡ����
        ois.close();    // �ر�
        return persons;
    }
}
