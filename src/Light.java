import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/14.
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai ，每盏灯可以覆盖到的最远距离为d，
 * 为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。

 输入描述:

 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。
 第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。


 输出描述:

 输出答案，保留两位小数。
 */
public class Light {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int l=sc.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            Light light=new Light();
            Double res=light.leastD(n,l,array);
            //保留两位小数
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.print(df.format(res));
        }
    }

    private Double leastD(int n, int l, int[] array) {
        Arrays.sort(array);
        int res=Integer.MIN_VALUE;
        int mm=Math.max(array[0],l-array[n-1]);
        for(int i=1;i<n;i++){
            if(array[i]-array[i-1]>res){
                res=array[i]-array[i-1];
            }
        }
        Double min=(double)res / 2;
        if(mm>min){
            return  (double)mm;
        }
        return min;
    }

}
