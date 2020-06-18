package Visitor;

public abstract class ResourceFile1 {
    protected String filePath;

    public ResourceFile1(String filePath){
        this.filePath = filePath;
    }

    public abstract void accept(Extractor extractor);
}
