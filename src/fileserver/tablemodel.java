
package fileserver;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class tablemodel extends AbstractTableModel {
    
        String [] cols = {
            "id" , "filename" , "author"
        } ;
        List<files> list = new ArrayList<>();
        public tablemodel(List<files> list){
            this.list = list;
        }
    
    public int getRowCount() {
        return list.size();
     }

  
    public int getColumnCount() {
        return cols.length;
    }

   public String getColumnName(int col){
       return cols[col];
   }
    public Object getValueAt(int row, int col) {
        files temp = list.get(row);
        switch (col) {
            case 0:
                return temp.getId();
            case 1:
                return temp.getFilename();
            case 2:
                return temp.getAuthor();
            default:
                    return temp.getFilename();
        }
    }
    
}

