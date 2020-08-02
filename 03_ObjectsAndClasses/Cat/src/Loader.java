
public class Loader
{

    private static Cat getKitten()
    {
        return new Cat(1100.0);
    }

    public static void main(String[] args)
    {
        Cat murka = new Cat();
        System.out.println(murka.getWeight());
        Cat murka2 = getKitten();
        Cat murka3 = getKitten();
        Cat murka4 = getKitten();
        System.out.println(murka2.getWeight());
        System.out.println(murka3.getWeight());
        System.out.println(murka4.getWeight());


    }
}