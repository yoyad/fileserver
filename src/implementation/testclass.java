
package implementation;

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
            System.out.println(list);
        }catch(Exception e){
            e.getMessage();
        }

    }
}

