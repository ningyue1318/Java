package Visitor;

public class PdfFile2 extends ResourceFile2{
    public PdfFile2(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
