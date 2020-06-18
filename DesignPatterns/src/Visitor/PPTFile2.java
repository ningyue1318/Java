package Visitor;

public class PPTFile2 extends ResourceFile2 {


    public PPTFile2(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
