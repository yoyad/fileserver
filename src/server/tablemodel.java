package server;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import implementation.*;
public class tablemodel extends AbstractTableModel {

    String[] cols = {
        "FileId", "FileName", "Publisher", "FileType", "FileSize(MB)"
    };
    List<files> list = new ArrayList<>();

    public tablemodel(List<files> filelist) {
        this.list = filelist;
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col) {
        return cols[col];
    }

    public Object getValueAt(int row, int col) {
        files record = list.get(row);
        switch (col) {
            case 0:
                return record.getFileId();
            case 1:
                return record.getFileName();
            case 2:
                return record.getPublisher();
            case 3:
                return record.getFileType();
            case 4:
                return record.getFileSize();
            default:
                return record.getFileName();
        }

    }

}
