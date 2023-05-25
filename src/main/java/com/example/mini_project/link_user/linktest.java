package com.example.mini_project.link_user;

import com.example.mini_project.oauth.UserLikeRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class linktest {
    public static void main(String[] args) {

        String url = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(url);
        String con = "https://tagilog.tistory.com/377";
        String TITLE = "";
        String CONTENTS = "";
        String IMAGE = "";

        Matcher matcher = p.matcher(con); // 게시글 내용이 들어있는 변수 넣으세요
        if (matcher.find()) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            String exportUrl = con.substring(startIndex, endIndex); // 게시글 내용이 들어있는 변수에서 url만 짜르기
            try {
                Document doc = null;

                doc = Jsoup.connect(exportUrl).header("User-Agent", "Mozilla/5.0").get();
                System.out.println(doc);

                TITLE = doc.select("meta[property=og:title]").attr("content");  // 제목
                CONTENTS = doc.select("meta[property=og:description]").attr("content"); // 내용
                IMAGE = doc.select("meta[property=og:image]").attr("content"); // 이미지
                System.out.println(TITLE);
                System.out.println(CONTENTS);
                System.out.println(IMAGE);

                if (TITLE.equals("")) {
                    TITLE = doc.select("title").html();
                }
                if (CONTENTS.equals("") || CONTENTS.contains("<head>")) {
                    CONTENTS = con;
                }
                if (IMAGE.equals("")) {
                    IMAGE = doc.select("img[class]").attr("src");
                    if (con.contains("google.com")) {
                        IMAGE = "https://pbs.twimg.com/profile_images/770139154898382848/ndFg-IDH_400x400.jpg";
                        if (IMAGE.equals("")) {
                            con = doc.select("meta[name=author]").attr("content");
                            IMAGE = "https://".concat(con).concat(".com").concat(doc.select("img").attr("src").substring(2));
                        }
                    }
                }
                if (!(IMAGE.contains("https://")) && !(IMAGE.contains("http://"))) {
                    if(!(IMAGE.contains("tistory"))){
                        IMAGE = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg?20200913095930";
                    }
                }
                System.out.println(TITLE);
                System.out.println(CONTENTS);
                System.out.println(IMAGE);
            } catch (Exception e) {
                TITLE = con;
                IMAGE = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg?20200913095930";
                CONTENTS = con;
            }
        } else {
            con = "유효하지 않은 링크";
        }
    }
}
