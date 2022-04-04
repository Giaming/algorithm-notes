package org.剑指offer;

import org.datastructure.八段锁.Main;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Demo {
//    public static void main(String[] args) {
//        new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());
//    }
//    public static void main(String[] args) throws ClassNotFoundException {
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        Class clazz = classLoader.loadClass("org.剑指offer.A");
//        System.out.println("Test");
////        clazz.forName("org.剑指offer.A");
//    }
//    private static int x = 10;
//    private static Integer y = 10;
//    public static void update(int value) {
//        value = 3 * value;
//    }
//    public static void update(Integer value) {
//        value = 3 * value;
//    }
//
//    public static void main(String[] args) {
//        update(x);
//        update(y);
//        System.out.println(x);
//        System.out.println(y);
//
//        Thread t1 = new Thread();
//        t1.setPriority(3);
//    }


//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] strs = s.split(" ");
//
//
//        System.out.println("A");  // ②
//        new Demo();
//        System.out.println("-------");
//        new Demo();
//
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }
        Arrays.stream(arr).forEach(ints -> {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
        });
    }

//    public Demo() {
//        System.out.println("B");  // ④
//    }
//
//    {
//        System.out.println("C");  // ③
//    }
//
//    static {
//        System.out.println("D");  // 最先执行
//    }
}

class Test2{
    public static final String a = new String("JD");
    static {
        System.out.println("OK");
    }
}