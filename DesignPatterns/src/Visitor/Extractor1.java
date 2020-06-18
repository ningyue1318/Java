package Visitor;

public class Extractor1 implements Visitor{
    @Override
    public void visit(PPTFile2 pptFile2) {
        System.out.println("Extract ppt");
    }

    @Override
    public void visit(PdfFile2 pdfFile2) {
        System.out.println("Extract pdf");
    }
}
