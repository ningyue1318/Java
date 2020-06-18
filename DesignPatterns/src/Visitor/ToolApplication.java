package Visitor;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {
    public static void main(String[] args) {
        //解耦之前的代码
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new PPTFile("b.ppt"));
        for(ResourceFile resourceFile:resourceFiles){
            resourceFile.extract2txt();
        }

        //解耦之后的代码
        Extractor extractor = new Extractor();
        List<ResourceFile1> resourceFiles1 = new ArrayList<>();
        resourceFiles1.add(new PdfFile1("a.pdf"));
        resourceFiles1.add(new PPTFile1("b.ppt"));
        for(ResourceFile1 resourceFile11 :resourceFiles1){
            resourceFile11.accept(extractor);
        }

        //参观者代码
        Visitor visitor = new Extractor1();
        List<ResourceFile2> resourceFiles2 = new ArrayList<>();
        resourceFiles2.add(new PdfFile2("a.pdf"));
        resourceFiles2.add(new PPTFile2("b.ppt"));
        for(ResourceFile2 resourceFile22:resourceFiles2){
            resourceFile22.accept(visitor);
        }
    }
}
