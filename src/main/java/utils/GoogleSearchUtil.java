package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class firstQuestionUtil {

    public static List<String> ExtractUrls(String text){
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        String url;
        while (urlMatcher.find())
        {
            url = text.substring(urlMatcher.start(0), urlMatcher.end(0));
            System.out.println(url);
            containedUrls.add(url);
        }
        return containedUrls;
    }

}
