import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        String srcFolder = "lib/src";
        String dstFolder = "lib/dst";

        int newWidth = 500;
        int cores = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();

        File[] files = new File(srcFolder).listFiles();
        int imagesStep = files.length / cores;

        for (int i = 0; i < cores; i++)
        {
            File[] fileStep = new File[imagesStep];
            System.arraycopy(files, i * imagesStep, fileStep, 0, imagesStep);
            Arrays.stream(fileStep).forEach(f -> System.out.println(f.getName()));
            new Thread(new ImageResizer(files, newWidth, dstFolder)).start();
        }
        if (cores*imagesStep < files.length)
        {
            File[] fileStep = new File[files.length - imagesStep*cores];
            System.arraycopy(files, cores * imagesStep, fileStep, 0, files.length - imagesStep * cores);
            Arrays.stream(fileStep).forEach(f -> System.out.println(f.getName()));
            new Thread(new ImageResizer(files, newWidth, dstFolder)).start();

        }
        System.out.println("Duration: " + (System.currentTimeMillis() - start));
        System.out.println(Thread.getAllStackTraces());
    }
}
