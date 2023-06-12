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
    public static void judge(int[] luckNumbers,int[] userNumbers){
        int redHitNumbers=0;
        int blueHitNumbers=0;
        for (int i = 0; i < userNumbers.length-1; i++) {
            for (int j = 0; j < luckNumbers.length-1; j++) {
                if(userNumbers[i]==luckNumbers[j]){
                    redHitNumbers++;
                    break;
                }
            }
        }
        redHitNumbers = userNumbers[6]==luckNumbers[6]?1:0;

        if (blueHitNumbers==1&&redHitNumbers<3){
            System.out.println("恭喜您，中了5元小奖");
        }else if (blueHitNumbers==1&&redHitNumbers==3||blueHitNumbers==0&&redHitNumbers==4){
            System.out.println("恭喜您，中了10元小奖");
        }else if (blueHitNumbers==1&&redHitNumbers==4 || blueHitNumbers==0&&redHitNumbers==5){
            System.out.println("恭喜您，中了200元");
        }else if(blueHitNumbers==1&&redHitNumbers==5){
            System.out.println("恭喜您，中了3000元大奖");
        } else if (blueHitNumbers==0&&redHitNumbers==6) {
            System.out.println("恭喜您，中了500万超级大奖");
        } else if (blueHitNumbers==1&&redHitNumbers==6) {
            System.out.println("恭喜您，中了1000万巨奖");
        }

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
