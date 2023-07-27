import java.util.*;
public class subseq_string_returnList {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(solve(str, ""));
    }
    private static ArrayList<String> solve(String str, String p) {
        if (str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = solve(str.substring(1), p);
        ArrayList<String> right = solve(str.substring(1), p+ch);
        right.addAll(left);
        return right;
    }
}