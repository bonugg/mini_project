package com.mini_project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadImageFromUrlTest {
    static String li = "";

    public static void main(String []args) {
        String url = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(url);
        String http = "https://coupang.com/";
        //String http = "https://www.notion.so/12-Stored-Sub-Program-c3903c369f5547d28aa3b649d02dd49c";

        String title;
        String content;
        String image;
        String a= "";


        Matcher matcher = p.matcher(http); // 게시글 내용이 들어있는 변수 넣으세요
        if( matcher.find() ) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();
            String exportUrl = http.substring(startIndex , endIndex); // 게시글 내용이 들어있는 변수에서 url만 짜르기

            try {
                Document doc = null;

                doc = Jsoup.connect(exportUrl).header("User-Agent" , "Mozilla/5.0").get();
                System.out.println(doc);

                title = doc.select("meta[property=og:title]").attr("content");  // 제목
                content = doc.select("meta[property=og:description]").attr("content"); // 내용
                image = doc.select("meta[property=og:image]").attr("content"); // 이미지

                System.out.println("321");
                System.out.println(title);
                System.out.println(content);
                System.out.println(image);
                System.out.println("123");
                if (title.equals("")) {
                    title = doc.select("title").html();
                    System.out.println(title);
                }
                if(content.equals("") || content.contains("<head>")){
                    content = http;
                    System.out.println(content);
                }
                if(image.equals("")){
                    image = doc.select("img[class]").attr("src");
                    if(image.equals("")){
                        System.out.println("예외");
                        a = doc.select("meta[name=author]").attr("content");
                        image = "https://".concat(a).concat(".com").concat(doc.select("img").attr("src").substring(2));
                    }
                    System.out.println(image);
                }

            } catch (Exception e) {
                title = "1";
                content = "1";
                image = "1";

            }
        }


    }
}