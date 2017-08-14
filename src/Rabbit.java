import java.util.*;

/**
 * Created by fengy on 2017/8/14.
 * 一只兔子藏身于20个圆形排列的洞中（洞从1开始编号），一只狼从x号洞开始找,下次隔一个洞找(即在x＋2号洞找)，
 * 在下次个两个洞找(即在x＋5号洞找)，它找了n次仍然没有找到。问兔子可能在那些洞中。

 输入描述:

 输入有多组数据，每组数据一行两个整数分别为x和n(x <= 20,n <= 100000)


 输出描述:

 每组数据一行按从小到大的顺序输出兔子可能在的洞，数字之间用空格隔开。若每个洞都不肯能藏着兔子，输出-1。
 */
public class Rabbit {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=sc.nextInt();
            int n=sc.nextInt();
            Rabbit r=new Rabbit();
            int[] res=r.findRabbit(x,n);
            for(int i=0;i<res.length;i++){
                System.out.print((res[i]+1)+" ");
            }
            System.out.println();
        }

    }
    public int[] findRabbit(int x,int n){
        int[] array=new int[20];
        int org=x-1;
        int add=2;
        List<Integer> list=new ArrayList<Integer>();
       // list.add(x-1);
        array[x-1]=1;
        while(n>0){
            if(x-1+add>=20){
                x=(x-1+add)%20+1-add;
            }
            array[x-1+add]=1;
            x=x+add;
            add++;
            n--;
        }
        for(int i=0;i<20;i++){
            if(array[i]!=1){
                list.add(i);
            }
        }
        int[] res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }
/*
*

有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
给定一个int[][] map,表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,int
  y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
*/
    public int countWays(int[][] map, int x, int y) {
        int res=0;
        int[][] dp=new int[map.length][map[0].length];
        for(int i=0;i<map[0].length;i++){
            if(map[0][i]!=1){
                dp[0][i]=1;
            }else{
                break;
            }
        }
        for(int i=0;i<map.length;i++){
            if(map[i][0]!=1){
                dp[i][0]=1;
            }else{
                break;
            }
        }
        for(int i=1;i<map.length;i++){
            for(int j=1;j<map[0].length;j++){
                if(map[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }
}
