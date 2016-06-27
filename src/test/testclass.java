package test;

import implementation.files;
import java.rmi.Naming;
import interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class testclass {

    public static void main(String[] args) {
        try {
            interfaces.Interface ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
            
            List<files> list = new ArrayList<>();
            list = ref.populatetable("videoTab");
            if (list == null) {
                System.out.println("this is test case");
            } else {
                System.out.println(list);
                for (files f : list) {
                    System.out.println(f.getFileName());
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
