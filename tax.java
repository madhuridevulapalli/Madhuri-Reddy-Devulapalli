import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int income=sc.nextInt();
       int tax=0;
       if(income<300000){
           tax=0;
       }
       else if(income>300000 && income<700000){
           tax1=0;
           tax2=(income-300000)*5/100;
           tax=tax1+tax2;
       }
       else if(income>700000 && income<1000000){
          tax1=0;
          tax2=20000;
          tax3=(income-700000)*10/100;
          tax=tax1+tax2+tax3;
       }
        else if(income>1000000 && income<1200000){
          int tax1=0;
          int tax2=20000;
          int tax3=30000;
          int tax4=(income-100000)*15/100;
          tax=tax1+tax2+tax3+tax4;
        }
         else if(income>1200000 && income<1500000){
          tax1=0;
          tax2=20000;
          tax3=30000;
          tax4=30000;
          tax5=(income-1200000)*20/100;
          tax=tax1+tax2+tax3+tax4+tax5;
        }
         else if(income>1500000){
          tax1=0;
          tax2=20000;
          tax3=30000;
          tax4=30000;
          tax5=60000;
          tax6=(income-1500000)*25/100;
          tax=tax1+tax2+tax3+tax4+tax5+tax6;
        }
        System.out.println(tax);
    }
}