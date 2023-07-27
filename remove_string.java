import java.util.*;
public class remove_string {
    public static void main(String[] args) {
        String str = "adhjshsjhfksa;kjksfdskkjfs";
        String remove = "a;";
        System.out.println(solve(str, remove));
    }
    private static String solve(String str, String remove) {
        if (str.isEmpty()) return "";
        if (str.startsWith(remove)) return solve(str.substring(remove.length()), remove);
        else return str.charAt(0) + solve(str.substring(1), remove);
    }
}