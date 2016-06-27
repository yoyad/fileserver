
package fileserver;

class files {
    
    int id;
    String filename;
    String author;                                                                /////user will download here
    files(int id, String filename, String author) {
        this.id = id;
        this.filename = filename;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getAuthor() {
        return author;
    }
    
}
