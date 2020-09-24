package jvm.syn.neu;

public class Parcel {
    class Contents{
        private int i =11;
        public int value(){return i;}
    }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        Parcel.Contents c = p.new Contents();
        Test01 a = new Test01();

    }
}
