
package fileserver;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fileserver {
    public static void main(String[] args) {
        LogIn l = new LogIn();
        l.setVisible(true);
        l.setDefaultCloseOperation(EXIT_ON_CLOSE);
        l.setResizable(false);
        l.setLocation(400, 250);
    }
    
}
