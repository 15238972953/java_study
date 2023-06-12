package base_case;

import java.util.Random;

public class verification_code {
    public static void main(String[] args) {
        String code = createCode(5);
        System.out.println("随机验证码："+code);
    }

    public static String createCode(int n){
        String code="";
        Random r=new Random();
        for (int i=0;i<n;i++){
            int type=r.nextInt(3);
            switch (type){
                case 0:
                    char ch1=(char)(r.nextInt(26)+65);
                    code+=ch1;
                    break;
                case 1:
                    char ch2=(char) (r.nextInt(26)+97);
                    code+=ch2;
                    break;
                case 2:
                    code+=r.nextInt(10);
                    break;
            }
        }
        return code;
    }
}
