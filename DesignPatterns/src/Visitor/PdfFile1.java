package Visitor;

public class PdfFile1 extends ResourceFile1{
    public PdfFile1(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }
}
