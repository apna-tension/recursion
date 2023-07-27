import java.util.*;
public class combination_sum_with_ds {
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,3,2};
        int target = 8;
        List<List<Integer>> list = new ArrayList<>();
        solve(arr, 0, target, list, new ArrayList<>());
        // System.out.println(list);
        for (List<Integer> temp : list) {
            System.out.println(temp);
        }
    }
    private static void solve(int[] arr, int index, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) ans.add(new ArrayList<>(ds));
            return;
        }
        if (arr[index] <= target) {
            ds.add(arr[index]);
            solve(arr, index, target-arr[index], ans, ds);
            ds.remove(ds.size()-1);
        }
        solve(arr, index+1, target, ans, ds);
    }
}