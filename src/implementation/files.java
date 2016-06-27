
package implementation;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class files implements Serializable{
  private String fileId;
  private String fileName;
  private float fileSize;
  private String fileType;
  private String publisher;
  ImageIcon photo;
  public files(String fileId, String fileName, String publisher, String fileType,float fileSize, ImageIcon photo){
      this.fileId = fileId;
      this.fileName = fileName;
      this.publisher = publisher;
      this.fileType = fileType;
      this.fileSize = fileSize;
      this.photo = photo;
  }

    public String getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public float getFileSize() {
        return fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public String getPublisher() {
        return publisher;
    }

    public ImageIcon getPhoto() {
        return photo;
    }
  
  
}

