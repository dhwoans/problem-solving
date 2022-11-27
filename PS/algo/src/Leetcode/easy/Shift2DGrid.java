package Leetcode.easy;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> last = new ArrayList<>();


            for (int j = 0; j < grid.length; j++) {
                last.add(grid[j][grid[j].length-1]);
            }
            //step 1
            for (int j = 0; j < grid.length; j++) {
                for (int l = grid[j].length-1; l >= 1; l--) {
                    grid[j][l] = grid[j][l-1];
                }
            }
            //step 2
            for (int j = 1; j < last.size(); j++) {
                System.out.println(j);
                grid[j][0] = last.get(j-1);

            }
            //step 3
            grid[0][0] = last.get(last.size()-1);
        }
        for (int[] ints : grid) {
            for (int i : ints) {
                System.out.print(i);
            }
            System.out.println();
        }
        //리스트로 옮기기
        for (int j = 0; j < grid.length; j++) {
            list.add(new ArrayList<>());
        }
        for (int j = 0; j < grid.length; j++) {
            for (int l = 0; l < grid[j].length; l++) {
                list.get(j).add(grid[j][l]);
            }
        }
        return list;
    }
}
