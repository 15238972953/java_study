package base_case;

import java.util.Scanner;

public class Buy_plane_ticket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请您输入机票原价：");
        double money = sc.nextDouble();

        System.out.println("请您输入机票月份（1-12）：");
        int month = sc.nextInt();

        System.out.println("请您选择仓位类型：");
        String type = sc.next();

        System.out.println("机票优惠后的价格是："+calc(money,month,type));
    }

    public static double calc(double money,int month,String type){
        if(month >=5 && month <=10){
            switch (type){
                case "头等舱":
                    money*=0.9;
                    break;
                case "经济舱":
                    money*=0.85;
                    break;
                default:
                    System.out.println("您输入的仓库类型有误;");
                    money=-1;
            }
        }else if(month ==11 || month == 12 || month >=1 &&money<=4){
            switch (type){
                case "头等舱":
                    money*=0.7;
                    break;
                case "经济舱":
                    money*=0.65;
                    break;
                default:
                    System.out.println("您输入的仓库类型有误;");
                    money=-1;
            }
        }else {
            System.out.println("对不起，您输入的月份有问题");
            return -1;
        }
        return money;
    }
}
