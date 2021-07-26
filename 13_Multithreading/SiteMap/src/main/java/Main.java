import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

    static final String SITEPATH = "https://www.youtube.com/";
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();

        List<String> workedLink = new ArrayList<>();
        workedLink.add(SITEPATH);
        LinksGetter processor = new LinksGetter(SITEPATH,0, workedLink);
        pool.execute(processor);
        pool.shutdown();

        processor.join();

        processor.getSiteMap().forEach(System.out::println);


        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));


    }
}


