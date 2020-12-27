package CodeingInterview;

/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Jz44 {
    public String ReverseSentence(String str) {
        if(str==null||str.length()==0) return "";
        String revereStr = "";
        while (str.contains(" ")){
            String temp = str.substring(0,str.indexOf(" ")+1);
            str = str.substring(str.indexOf(" ")+1,str.length());
            revereStr = temp+revereStr;
        }
        return str+" "+revereStr;
    }

    public String ReverseSentence1(String str){
        if(str==null||str.length()==0) return "";
        char [] chars = str.toCharArray();
        reverse(chars,0,str.length()-1);
        System.out.println(new String(chars));
        int start = 0;
        int end = 0;
        while (end<str.length()){
            if(chars[end]==' '){
                reverse(chars,start,end-1);
                start = end+1;
            }
            end++;
        }
        return new String(chars);
    }

    public void reverse(char []data,int start,int end){
        while(start<end){
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Jz44 z = new Jz44();
        System.out.println(z.ReverseSentence1("I am a student."));
    }
}
