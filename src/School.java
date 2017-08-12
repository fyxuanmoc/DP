import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/12.
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。
 * 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 输入描述:
 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
 输出描述:

 一行输出答案。
 */
public class School {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        School s=new School();
        while(sc.hasNext()){
            int classNum=sc.nextInt();
            int fullScore=sc.nextInt();
            int avg=sc.nextInt();
            int[][] map=new int[classNum][2];
            for(int i=0;i<classNum;i++){
                for(int j=0;j<2;j++){
                    map[i][j]=sc.nextInt();
                }
            }
            Long res=s.leastTime(classNum,fullScore,avg,map);
            System.out.println(res);
        }
    }

    private Long leastTime(int classNum,int fullScore, int avg, int[][] map) {
        Long res=new Long(0);
        Long[] dp=new Long[classNum*avg+1];
        int nowScore=0;
        for(int i=0;i<classNum;i++){
            nowScore=map[i][0]+nowScore;
        }
        if(nowScore>=classNum*avg){
            return res;
        }
        dp[nowScore]=new Long(0);
        for(int i=nowScore+1;i<classNum*avg+1;i++){
            dp[i]=min(map,fullScore)+dp[i-1];
        }
        res=dp[classNum*avg];
        return res;
    }

    private int min(int[][] map,int full) {
        int min=Integer.MAX_VALUE;
        int temp=0;
        for(int i=0;i<map.length;i++){
            if(map[i][0]<full){
                if(min>map[i][1]){
                    min=map[i][1];
                    temp=i;
                }
            }
        }
        map[temp][0]++;
        return min;
    }
}

