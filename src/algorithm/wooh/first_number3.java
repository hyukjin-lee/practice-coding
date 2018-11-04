package algorithm.wooh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class first_number3 {

    static List<Integer> integers = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());

        integers.add(a);
        integers.add(b);
        integers.add(c);
        integers.add(d);

        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.size(); j++) {
                if(i == j) {
                    continue;
                }

                for (int k = 0; k < integers.size(); k++) {
                    if(k == j || k == i){
                        continue;
                    }
                    for (int l = 0; l < integers.size(); l++) {
                        if(k == l || l == j || l == i){
                            continue;
                        }
                        max = Math.max(max, calculateDistance(integers.get(i),integers.get(j),integers.get(k),integers.get(l)));
                    }
                }
            }
        }

        System.out.println(max);

    }

    public static int calculateDistance(int a, int b, int c, int d){
        return (int)(Math.pow(Math.abs(a-c),2) + Math.pow(Math.abs(b-d),2));
    }
}
