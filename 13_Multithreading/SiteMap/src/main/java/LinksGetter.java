import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class LinksGetter extends RecursiveTask<LinkedHashSet<String>> {

    private String path;
    private int lvl;
    private List<String> linkList;
    private static List<String> checker = new ArrayList<>();

    public LinksGetter(String path, int lvl, List<String> linkList) {
        this.path = path;
        this.lvl = lvl;
        this.linkList = linkList;
    }

    public List<String> getSiteMap() {
        return linkList;
    }

    public LinkedHashSet<String> compute() {
        ArrayList<String> list = new ArrayList<>();
        List<LinksGetter> linksGetterList = new ArrayList<>();

        List<String> links = linksGetter(this.path);

        for(String link : links) {
            if (!checker.contains(link)) {
                checker.add(link);
                String correctLink = tabAdder(link);
                if (!linkList.contains(correctLink) && !list.contains(correctLink)) {
                    linkList.add(correctLink);
                    list.add(correctLink);
                    LinksGetter task = new LinksGetter(link, lvl + 1, linkList);
                    task.invoke();
                    linksGetterList.add(task);
                }
            }
        }
        return new LinkedHashSet<>(list);
    }

    private List<String> linksGetter(String path) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        Document siteDoc = null;
        try {
            Thread.sleep(150);
            siteDoc = Jsoup.connect(path).ignoreContentType(true).get();
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
        if (siteDoc != null) {
            siteDoc.select("a").forEach(a -> {
                String link = a.absUrl("href");
                if (link.matches(path + ".+") && !link.contains("#"))
                    set.add(link);
            });
        }
        return new ArrayList<>(set);
    }

    private String tabAdder(String link) {
        String tabulation = "\t";
        for (int i = 0; i < lvl; i++) {
            tabulation += "\t";
        }
        return tabulation + link;
    }
}
