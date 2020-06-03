package Algorithms.Daily.WeekOne.PartOne;

import java.math.BigDecimal;
import java.util.Scanner;

//快手2020春

/**
 * 多多鸡打算造一本自己的电子字典，里面的所有单词都只由a和b组成。
 * 每个单词的组成里a的数量不能超过N个且b的数量不能超过M个。
 * 多多鸡的幸运数字是K，它打算把所有满足条件的单词里的字典序第K小的单词找出来，作为字典的封面。
 */

/**
 * 输入描述:
 *
 * 共一行，三个整数N, M, K。(0 < N, M < 50, 0 < K < 1,000,000,000,000,000)
 */

/**
 * 输出描述:
 *
 * 共一行，为字典序第K小的单词。
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N个a
        int N = sc.nextInt();
        //M个b
        int M = sc.nextInt();
        //第K个单词
        long K = sc.nextLong();

        System.out.println(dic(N,M,K));


    }
    //N个a,M个b
    public static String dic(int N, int M, long K){
        BigDecimal index = BigDecimal.valueOf(0);
        StringBuilder s = new StringBuilder();
        int num_a = N;
        int num_b = M;
        while (BigDecimal.valueOf(K).compareTo(index) > 0 && num_a!=0 && num_b!=0){
            if (BigDecimal.valueOf(K).compareTo(index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2))) > 0){
                s.append("b");
                index = index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2));
                num_b--;
            }
            else if (BigDecimal.valueOf(K).compareTo(index.add(cal(num_a - 1, num_b)).add(BigDecimal.valueOf(2))) == 0){
                s.append("b");
                return s.toString();
            }
            else {
                s.append("a");
                index = index.add(BigDecimal.valueOf(1));
                num_a--;
            }
        }
        if (num_a==0){
            for (long i =0;i<K-index.longValue(); i++){
                s.append("b");
            }
        }
        if (num_b==0){
            for (long i =0;i<K-index.longValue(); i++){
                s.append("a");
            }
        }

        return s.toString();

    }

    //解决 x个a和y个b有多少种排列方式
    public static BigDecimal cal(int x, int y){
        BigDecimal res = BigDecimal.valueOf(0);
        int min = Math.min(x,y);
        int max = Math.max(x,y);
        for (int i=1; i<=min; i++){
            res = res.add(new BigDecimal(2).pow(i));
        }
        for (int i = min+1; i<=x+y; i++){
            BigDecimal e = BigDecimal.valueOf(0);
            for (int j = min ;j>=i-max;j--){
                e = e.add(doFactorial(i).divide((doFactorial(j).multiply(doFactorial(i - j))), 2));
            }
            res  = res.add(e);
        }
        return res;
    }

    public static BigDecimal doFactorial(int n){
        if(n<0){
            return BigDecimal.valueOf(-1);//传入的数据不合法
        }
        if(n==0){
            return BigDecimal.valueOf(1);
        }else if(n==1){//递归结束的条件
            return BigDecimal.valueOf(1);
        }else{
            return BigDecimal.valueOf(n).multiply(doFactorial(n-1));
        }
    }
}
