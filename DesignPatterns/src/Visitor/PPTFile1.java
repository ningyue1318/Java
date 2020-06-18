package Visitor;

public class PPTFile1 extends ResourceFile1{
    public PPTFile1(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }
}
