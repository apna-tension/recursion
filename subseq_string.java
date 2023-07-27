import java.util.*;
public class subseq_string {
    public static void main(String[] args) {
        String str = "abc";
        solve(str, "");
        System.out.println();
    }
    // print all the subsequence of a string ;
    private static void solve(String str, String p) {
        if (str.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        char ch = str.charAt(0);
        solve(str.substring(1), p+ch);
        solve(str.substring(1), p);
    }
}
