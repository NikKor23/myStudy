import org.imgscalr.AsyncScalr;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable{

    private File[] files;
    private int newWidth;
    private String dstFolder;

    private volatile boolean isRunning;

    public ImageResizer() {
        isRunning = true;
    }

    public ImageResizer(File[] files,int newWidth, String dstFolder) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        isRunning = true;
    }

    public void run() {
            try {
                for (File file : files) {
                    BufferedImage image = ImageIO.read(file);
                    if (image == null) {
                        continue;
                    }
                    BufferedImage result = Scalr.resize(image, newWidth);
                    File outputFile = new File(dstFolder + "/" + file.getName());
                    ImageIO.write(result, "jpg", outputFile);
                    result.flush();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    public void stop() {
        isRunning = false;
    }

}
