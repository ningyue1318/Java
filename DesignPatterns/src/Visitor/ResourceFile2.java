package Visitor;

public abstract class ResourceFile2 {
    protected String filePath;

    public ResourceFile2(String filePath){
        this.filePath = filePath;
    }

    public abstract void accept(Visitor visitor);
}
