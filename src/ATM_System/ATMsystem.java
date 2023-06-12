package ATM_System;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMsystem {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Account> accounts=new ArrayList<>();
        while (true) {
            System.out.println("==========黑马ATM系统=========");
            System.out.println("1、账户登陆");
            System.out.println("2.账户开户");

            System.out.println("请您选择操作：");
            int command=sc.nextInt();

            switch (command){
                case 1:
                    login(accounts);
                    break;
                case 2:
                    register(accounts);
                    break;
                default:
                    System.out.println("您输入的操作命令不存在~~");
                    break;
            }
        }
    }

    private static void login(ArrayList<Account> accounts) {
        System.out.println("=====系统登陆操作=====");
        if (0==accounts.size()){
            System.out.println("对不起，当前系统中，无任何用户，请先开户，再来登陆~~");
            return;
        }
        System.out.println("请输入登陆卡号：");
        String cardid=sc.next();
        Account acc = getAccountByCardId(cardid,accounts);
        if (null!=acc){
            while (true){
                System.out.println("请输入登录密码：");
                String passWard = sc.next();
                if(acc.getPassWord().equals(passWard)){
                    System.out.println("恭喜您，"+acc.getUserName()+"先生/女士进入系统，您的卡号是："+acc.getCardid());
                    showUserCommand();
                }else {
                    System.out.println("对不起，您输入的密码有误~~");
                }
            }
        }else {
            System.out.println("对不起，系统不存在该卡号~~");
        }
    }

    private static void showUserCommand() {
        while (true) {
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    System.out.println("待完善");
                    break;
                case 2:
                    System.out.println("待完善");
                    break;
                case 3:
                    System.out.println("待完善");
                    break;
                case 4:
                    System.out.println("待完善");
                    break;
                case 5:
                    System.out.println("待完善");
                    break;
                case 6:
                    System.out.println("待完善");
                    break;
                case 7:
                    System.out.println("待完善");
                    break;
                default:
                    System.out.println("输入有误，请重新输入~~");
            }
        }
    }

    private static void register(ArrayList<Account> accounts) {
        System.out.println("====系统开户操作=====");
        Account account = new Account();
        System.out.println("请输入账户用户名：");
        String userName=sc.next();
        account.setUserName(userName);
        while (true) {
            System.out.println("请您输入账户密码：");
            String passward=sc.next();
            System.out.println("请输入确认密码：");
            String okPassWard=sc.next();
            if(okPassWard.equals(passward)){
                account.setPassWord(okPassWard);
                break;
            }else {
                System.out.println("对不起，您输入的2次密码不一致，请重新确认~~");
            }
        }
        System.out.println("请输入账户当次限额：");
        double quotaMoney=sc.nextDouble();
        account.setQuotaMoney(quotaMoney);

        String cardid=getRandomCardId(accounts);
        account.setCardid(cardid);

        accounts.add(account);
        System.out.println("恭喜您，"+userName+"先生/女士，您开户成功，您的卡号是："+cardid+",请您妥善保管卡号");
    }

    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r=new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId+=r.nextInt(10);
            }
            Account acc=getAccountByCardId(cardId,accounts);
            if(null==acc){
                return cardId;
            }
        }
    }

    private static Account getAccountByCardId(String cardId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if(acc.getCardid().equals(cardId)){
                return acc;
            }
        }
        return null;
    }
}
