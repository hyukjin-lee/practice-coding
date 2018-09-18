package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class kakao_6 {
    private static List<Page> pageList = new ArrayList<>();
    private static int minIndex = 0;

    public static void main(String[] args) {
        solution("man", new String[]{"\"<html lang=\\\"ko\\\" xml:lang=\\\"ko\\\" xmlns=\\\"http://www.w3.org/1999/xhtml\\\">\\n<head>\\n  <meta charset=\\\"utf-8\\\">\\n  <meta property=\\\"og:url\\\" content=\\\"https://a.com\\\"/>\\n</head>  \\n<body>\\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \\n<a href=\\\"https://b.com\\\"> Link to b </a>\\n</body>\\n</html>\"", "\"<html lang=\\\"ko\\\" xml:lang=\\\"ko\\\" xmlns=\\\"http://www.w3.org/1999/xhtml\\\">\\n<head>\\n  <meta charset=\\\"utf-8\\\">\\n  <meta property=\\\"og:url\\\" content=\\\"https://b.com\\\"/>\\n</head>  \\n<body>\\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \\n<a href=\\\"https://a.com\\\"> Link to a </a>\\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\\n<a href=\\\"https://c.com\\\"> Link to c </a>\\n</body>\\n</html>\"", "\"<html lang=\\\"ko\\\" xml:lang=\\\"ko\\\" xmlns=\\\"http://www.w3.org/1999/xhtml\\\">\\n<head>\\n  <meta charset=\\\"utf-8\\\">\\n  <meta property=\\\"og:url\\\" content=\\\"https://c.com\\\"/>\\n</head>  \\n<body>\\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\\n<a href=\\\"https://a.com\\\"> Link to a </a>\\n</body>\\n</html>\""});
    }

    public static int solution(String word, String[] pages) {

        for (int i = 0; i < pages.length; i++) {
            pageList.add(new Page(pages[i], word));
        }

        for (Page page : pageList) {
            for (Page otherPage : pageList) {
                if (page != otherPage) {
                    if (otherPage.externalLinks.contains(page.myLink)) {
                        page.calculateOtherResultPoint += otherPage.resultPoint;
                    }
                }
            }
        }

        for (int i = 0; i < pageList.size(); i++) {
            for (int j = 0; j < pageList.size(); j++) {
                if (i != j) {
                    if (pageList.get(i).calculateOtherResultPoint > pageList.get(j).calculateOtherResultPoint) {
                        minIndex = i + 1;
                    }
                }
            }
        }

        for (Page page :
                pageList) {
            System.out.println(page);

        }

        return minIndex;
    }

    public static class Page {

        private double calculateOtherResultPoint = 0;
        private String searchWord;
        private String page;
        private int searchPoint = 0;
        private int externalLinkNumber = 0;
        private List<String> externalLinks = new ArrayList<>();
        private String myLink;
        private double resultPoint;

        public Page(String page, String searchWord) {
            this.searchWord = searchWord.toLowerCase();
            this.page = page;
            substractMyLink();
            substractExternalLinks();
            calculateSearchPoint();
            this.resultPoint = (double) searchPoint / externalLinkNumber;
        }

        public void substractMyLink() {
            Pattern infoPattern = Pattern.compile("content=[\"'](https://([a-z-A-Z-\\s0-500]*).([a-z-A-Z-\\s0-500]*))");
            Matcher infoMatcher = infoPattern.matcher(page);
            if (infoMatcher.find()) {
                myLink = infoMatcher.group(1);
            }
        }

        public void substractExternalLinks() {
            Pattern infoPattern = Pattern.compile("href=[\"'](https://([a-z-A-Z-\\s0-500]*).([a-z-A-Z-\\s0-500]*))");
            Matcher infoMatcher = infoPattern.matcher(page);
            while (infoMatcher.find()) {
                externalLinks.add(infoMatcher.group(1));
                externalLinkNumber++;
            }
        }

        public void calculateSearchPoint() {
            String lowerCasePage = page.toLowerCase();
            Pattern infoPattern = Pattern.compile("[^A-Za-z0-9가-힣]" + searchWord + "[^A-Za-z0-9가-힣]");
            Matcher infoMatcher = infoPattern.matcher(lowerCasePage);
            while (infoMatcher.find()) {
                searchPoint++;
            }
        }

        @Override
        public String toString() {
            return "Page{" +
                    "calculateOtherResultPoint=" + calculateOtherResultPoint +
                    ", searchWord='" + searchWord + '\'' +
                    ", page='" + page + '\'' +
                    ", searchPoint=" + searchPoint +
                    ", externalLinkNumber=" + externalLinkNumber +
                    ", externalLinks=" + externalLinks +
                    ", myLink='" + myLink + '\'' +
                    ", resultPoint=" + resultPoint +
                    '}';
        }
    }


}
