import javax.imageio.ImageTranscoder;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        double r = Math.abs(radius);
        double s = Math.pow(r, 2) * Math.PI;
        return s;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        double r = Math.abs(radius);
        double v = Math.pow(r, 3) * Math.PI * 4 / 3;
        return v;
    }

    public static boolean isTriangleRightAngled(double a, double b, double c)
    {
        if (isTriangleExist(a, b, c))
        {
            if ((a == Math.sqrt((c * c) + (b * b))) || (b == Math.sqrt((a * a) + (c * c))) || (c == Math.sqrt((a * a) + (b * b))))
            {
                return true;
            }
            else return false;
        }
        else return false;
    }

    public static boolean isTriangleExist(double a, double b, double c)
    {
        if (a + b > c && a + c > b && b + c > a) return true;
        else
        {
            System.out.println("Triangle does not exist");
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        if (isTriangleExist(a, b, c))
        {
            double p = (a + b + c) / 2;
            double  s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        }
        return (-1.0);
    }
}
