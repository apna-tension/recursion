import java.util.*;
public class palindrome_partitioning {
    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> list = new ArrayList<>();
        
        // in this solve method, we replace the main string with the substring
        // solve(str, new ArrayList<>(), list);

        // in this solve2 method, we don't replace the main string we can carray a new index
        solve2(0, str, new ArrayList<>(), list);
        Iterator<List<String>> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
        // recursive solution :-------------------------
    private static void solve(String str, List<String> list, List<List<String>> ans) {
        if (str.length() == 0 || str.isEmpty() || str == null) {
            ans.add(new ArrayList<>(list));
            // list.clear();
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i+1);
            if (isPalindrome(word)) {
                list.add(word);
                solve(str.substring(i+1), list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    private static void solve2(int index, String str, List<String> list, List<List<String>> ans) {
        if (index >= str.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome2(str, index, i)) {
                list.add(str.substring(index, i+1));
                solve2(i+1, str, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
    private static boolean isPalindrome2(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) return false;
        }
        return true;
    }
    


}