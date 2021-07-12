package com.bai.service;

import com.bai.bean.Customer;
import com.bai.bean.CustomerData;
import com.bai.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类是完成客户的所有业务（增删改查）
public class CustomerService {
    /*CustomerData customerData = CustomerData.getInstance();
    List<Customer> customerList = customerData.getCustomerList();*/
    private List<Customer> customerList;
    private  Customer currentCustomer;
    //1.查，登录  判断账号密码是否正确
    public void checkPwd(String cardid,String cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        List<Customer> customerList = customerData.getCustomerList();
        //1.拿到cardid中的账户名和cardPwd 对list中的数据对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);
        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                currentCustomer=customer;
                //账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全");
                TextUtil.oneLeveOption();
                Scanner scanner = new Scanner(System.in);
                String option=scanner.nextLine();
                oneOption(option);
            }

        }
    }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                doSelectMoney();
                //当按下1之后，回退到 1级选项
                goOneHome();

                break;
            case "2":
                goGetMoneyHome();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                Money();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                saveMoney();
                goOneHome();
                break;
            case "5":
                System.out.println("退卡");
                System.exit(0);
                break;
        }
    }
    //转账
    private void doTruanMoney(){
        System.out.println("请输入对方的账户号码：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您需要转账的金额：");
        String otherMoney = scanner.nextLine();
        //做计算   自己的钱 -otherMoney，别人的钱+otherMoney
        //自己  减钱
        double otherMoneyInt=Double.parseDouble(otherMoney);
        double currentMoney=currentCustomer.getMoney()-otherMoneyInt;
        //别人  加钱，根据outherAccount本人的账户查询出别人的余额，修改别人的余额
        //因为所有人都在customerList都在这个集合中，那么遍历这个集合
        Customer other=null;
        for (Customer customer : customerList) {
            //如果customer.getAccount等于otherAccount，那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other=customer;
            }
        }
        double otherOneMoney = other.getMoney()+otherMoneyInt;//别人的余额
        //自己和别人都更新一下钱数
        currentCustomer.setMoney(currentMoney);
        other.setMoney(otherOneMoney);  //注意：有问题？不能够创建对象了
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }
    //查询余额
    private void doSelectMoney() {
        double money=currentCustomer.getMoney();
        System.out.println("余额是" + money);
    }

    //转账
    private void Money() {
        System.out.println("请输入您要转账的卡号：");
        Scanner account = new Scanner(System.in);
        int money = account.nextInt();
        Customer nuser = null;
        boolean IsExit = false;
    }




    //存款
    private void saveMoney(){
        System.out.println("请输入您的存款金额：");
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        if (currentCustomer!=null){
            if (money>0){
                currentCustomer.setMoney(currentCustomer.getMoney()+money);
                System.out.println("存款成功");
                System.out.println("你的当前余额为："+currentCustomer.getMoney());
            }else{
                System.out.println("输入错误");
            }

        }
    }

    private void goOneHome(){
        TextUtil.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option=scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);//递归算法
    }
    //取款
    private void goGetMoneyHome(){
        TextUtil.getMoneyUI();
        //1.让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn=scanner.nextLine();
        if (numIn.equals("1")) {
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-100;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("2")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-200;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("3")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-300;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if (numIn.equals("4")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-500;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if (numIn.equals("5")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-800;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("6")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-1000;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("7")){
            //2.那么取款100 那么久应该让顾客的钱数减100
            double money = currentCustomer.getMoney();
            money=money-2000;
            System.out.println("您的余额是:"+money);
            //取完款项之后，更新原有的存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("8")){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入您的取款金额：");
            int money = sc.nextInt();
            if (money>0&&money<=currentCustomer.getMoney()){
                currentCustomer.setMoney(currentCustomer.getMoney()-money);
                System.out.println("取款成功");
                System.out.println("你的当前余额为："+currentCustomer.getMoney());
            }else {
                System.out.println("输入错误");
            }
        }
    }
    /*//取款
    private void withdrawMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的取款金额：");
        int money = sc.nextInt();
        if (money>0&&money<=currentCustomer.getMoney()){
            currentCustomer.setMoney(currentCustomer.getMoney()-money);
            System.out.println("取款成功");
            System.out.println("你的当前余额为："+currentCustomer.getMoney());
        }else {
            System.out.println("输入错误");
        }
    }*/
}
