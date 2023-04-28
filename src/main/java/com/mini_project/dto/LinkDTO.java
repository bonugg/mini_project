package com.mini_project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
public class LinkDTO {
    private String LINK;
    private String TITLE;
    private String CONTENTS;
    private String IMAGE;

    public void link_rs(String link){
        System.out.println(link);
        System.out.println("");
        this.LINK = link;
        String url = "[(http(s)?):\\/\\/(www\\.)?a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

        Pattern p = Pattern.compile(url);
        String con = "";

        Matcher matcher = p.matcher(link); // 게시글 내용이 들어있는 변수 넣으세요
        if( matcher.find() ) {
            int startIndex = matcher.start();
            int endIndex = matcher.end();

            String exportUrl = link.substring(startIndex , endIndex); // 게시글 내용이 들어있는 변수에서 url만 짜르기
            try {
                Document doc = null;

                doc = Jsoup.connect(exportUrl).header("User-Agent" , "Mozilla/5.0").get();

                this.TITLE = doc.select("meta[property=og:title]").attr("content");  // 제목
                this.CONTENTS = doc.select("meta[property=og:description]").attr("content"); // 내용
                this.IMAGE = doc.select("meta[property=og:image]").attr("content"); // 이미지

                if(this.IMAGE.equals("")){
                    this.IMAGE = doc.select("img[class]").attr("src");
                    if(this.IMAGE.equals("")){
                        con = doc.select("meta[name=author]").attr("content");
                        this.IMAGE = "https://".concat(con).concat(".com").concat(doc.select("img").attr("src").substring(2));
                    }
                }

                if(this.CONTENTS.equals("")){
                    this.CONTENTS = link;
                }

            } catch (Exception e) {
                this.TITLE = this.LINK;
                this.IMAGE = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg?20200913095930";
                this.CONTENTS = this.LINK;
            }
        }
    }
}
