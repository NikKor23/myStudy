import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

    static final String SITEPATH = "https://www.youtube.com/";
    static final String SITEMAPFILE = "src/main/resources/site_map.txt";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();

        List<String> workedLink = new ArrayList<>();
        workedLink.add(SITEPATH);
        LinksGetter processor = new LinksGetter(SITEPATH,0, workedLink);
        pool.execute(processor);
        pool.shutdown();

        processor.join();

        File siteMapFile = new File(SITEMAPFILE);
        try {
            siteMapFile.createNewFile();
            PrintWriter writer = new PrintWriter(SITEMAPFILE, "UTF-8");
            processor.getSiteMap().forEach(writer::println);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));


    }
}


