import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Parser {
    private int count = 0;

    public void Start() throws IOException {
        List<Article> articleList = new ArrayList<>();                                                                  //  Создаем массив articleList

        Document doc = Jsoup.connect("https://unicode-table.com/ru/emoji/").get();                                  //  Получаем HTML код страницы

        Elements divElements = doc.getElementsByAttributeValue("class", " character-list__link js-char-popup-item");    //  Получаем класс character-list__link js-char-popup-item
        File filePathName = new File("Emoji.txt");                                                             //  Указываем название файла для хранения емоджи
        FileWriter nFile = new FileWriter(filePathName);                                                                //  Создаем текстовый файл

        divElements.forEach(divElement -> {                                                                             //  Проходимся по каждому елементу divElement
            String uname = divElement.text();                                                                           //  Парсим uname - Код емоджи
            String utitle = divElement.attr("title");                                                         //  Парсим utitle - Описание
            String ucode = divElement.attr("data-symbol");                                                    //  Парсим ucode - Емоджи

            articleList.add(new Article(uname, utitle, ucode));                                                         //  Записываем спарсенные данные в массив
            try {                                                                                                       //
                nFile.write(String.valueOf(articleList.get(count++) + "\n"));                                       //
            } catch (IOException e) {                                                                                   //  Выгрузка строк массива в текстовый файл
                throw new RuntimeException(e);                                                                          //
            }                                                                                                           //
        });

        nFile.close();
    }
}

class Article {
    private String uname;
    private String utitle;
    private String ucode;

    public Article(String uname, String utitle, String ucode) {
        this.uname = uname;
        this.utitle = utitle;
        this.ucode = ucode;
    }

    public String setUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtitle() {
        return utitle;
    }

    public void setUtitle(String utitle) {
        this.utitle = utitle;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    @Override                                                                                                           //
    public String toString() {                                                                                          //
        return  "uname='" + uname + '\'' +                                                                              //  Шаблон заполнения массива
                ", utitle='" + utitle + '\'' +                                                                          //
                ", ucode='" + ucode + '\'';                                                                             //
    }
}