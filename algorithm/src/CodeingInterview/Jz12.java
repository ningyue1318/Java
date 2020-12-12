package CodeingInterview;

/*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    保证base和exponent不同时为0
 */
public class Jz12 {
    //暴力法
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1.0;
        }
        double result = 1;
        for(int i=0;i<(exponent>0?exponent:-exponent);i++){
            result=result*base;
        }
        return exponent>0?result:(1.0/result);
    }

    //快速幂
    public double Power1(double base, int exponent) {
        if(exponent==0){
            return 1.0;
        }
        boolean isPositive = true;
        if(exponent<0){
            isPositive = false;
            exponent = -exponent;
        }
        double result;
        if(exponent%2==0){
            result = q_power(base,exponent/2);
            result = result*result;
        }else{
            result = q_power(base,(exponent-1)/2);
            result = result*result*base;
        }
        return isPositive?result:(1.0/result);
    }

    public double q_power(double base,int exponent){
        if(exponent==1){
            return base;
        }
        double result = q_power(base,exponent/2);
        return result*result;
    }

    public double Power2(double base,int exponent){
        if(exponent==0){
            return 1.0;
        }
        if(exponent<0){
            exponent = -exponent;
            base = 1.0/base;
        }
        int flag = 1;
        double result = base;
        while (exponent!=0) {
            if ((flag & exponent) != 0) {
                result *= base;
            }
            exponent = exponent >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Jz12 z = new Jz12();
        System.out.println(z.Power2(2,3));

    }
}
