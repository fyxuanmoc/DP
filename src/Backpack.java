import java.util.Scanner;

/**
 * Created by fengy on 2017/8/14.
 * 一个背包有一定的承重cap，有N件物品，每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量记录在数组w中，每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 测试样例：
 [1,2,3],[1,2,3],3,6
 返回：6
 */
public class Backpack {
    public static void main(String[] args){
        Backpack b=new Backpack();
        int[] w={42,25,30,35,42,21,26,28};
        int[] v={261,247,419,133,391,456,374,591};
        int n=8;
        int cap=297;
        System.out.println(b.maxValue(w,v,n,cap));
    }
//[],[],8,297
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // 前i个物品中最大重量不超过j
        int[][] dp=new int[n+1][cap+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<cap+1;j++){
                if(w[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],v[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }
        return dp[n-1][cap];
    }
}
