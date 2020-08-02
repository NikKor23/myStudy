
public class Loader
{

    private static Cat getKitten()
    {
        return new Cat(1100.0);
    }

    public static void main(String[] args)
    {
        Cat murka = new Cat();
        murka.setColor(Color.BLACK);
        System.out.println(murka.getColor());


    }
}