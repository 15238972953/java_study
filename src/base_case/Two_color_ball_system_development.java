package base_case;

import java.util.Random;
import java.util.Scanner;

public class Two_color_ball_system_development {
    public static void main(String[] args) {

        int[] luckNumber = createLuckNumber();
        printarray(luckNumber);
        int[] userNumbers = userInputNumbers();
        printarray(userNumbers);
    }
    public static void printarray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static int[] userInputNumbers(){
        int[] numbers=new int[7];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < numbers.length-1; i++) {
            System.out.println("请您输入第"+(i+1)+"个红球号码");
            int data = sc.nextInt();
            numbers[i]=data;
        }
        System.out.println("请您输入蓝球号码（1-16）：");
        numbers[6]=sc.nextInt();
        return numbers;
    }
    public static int[] createLuckNumber(){
        int[] numbers=new int[7];
        Random r=new Random();
        for (int i = 0; i < numbers.length-1; i++) {
            while (true){
                int data=r.nextInt(33)+1;
                boolean flag=true;
                for (int j = 0; j < i; j++) {
                    if(numbers[j]==data){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    numbers[i]=data;
                    break;
                }
            }
        }
        numbers[numbers.length-1]=r.nextInt(16)+1;
        return numbers;
    }
}
