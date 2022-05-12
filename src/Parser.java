import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Parser {
    private int count;
    private static String filePath = "Emoji.txt";
    public void Start() throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("https://unicode-table.com/ru/emoji/").get();

        Elements divElements = doc.getElementsByAttributeValue("class", " character-list__link js-char-popup-item");
        FileWriter fileWriter = new FileWriter(filePath);

        divElements.forEach(divElement -> {
            String uname = divElement.text();
            String ucode = divElement.attr("data-symbol");

            articleList.add(new Article(uname, ucode));
            try {
                fileWriter.write(String.valueOf(articleList.get(count++) + "\n"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        fileWriter.close();
    }
}

class Article {
    private String uname;
    private String ucode;

    public Article(String uname, String ucode) {
        this.uname = uname;
        this.ucode = ucode;
    }

    public String setUname() { return uname; }

    public void setUname(String uname) { this.uname = uname; }

    public String getUcode() { return ucode; }

    public void setUcode(String ucode) { this.ucode = ucode; }

    @Override
    public String toString() {
        return  uname + "\n" + ucode;
    }
}