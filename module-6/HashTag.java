import java.util.*;
import java.util.regex.*;


public class HashTag {
    public static void main(String[] args) {
        String post = "Learning Java is fun! #java #coding #100DaysOfCode";
        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(post);
        List<String> hashtags = new ArrayList<>();


        while (matcher.find()) {
            hashtags.add(matcher.group(1));
        }
        System.out.println("Hashtags found: " + hashtags);
    }
}
