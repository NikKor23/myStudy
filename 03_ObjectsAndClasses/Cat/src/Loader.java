
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();
        Cat murka2 = new Cat();
        Cat murka3 = new Cat();
        Cat murka4 = new Cat();
        Cat murka5 = new Cat();
        System.out.println(Cat.getCount() + " cats");
        System.out.println("Murka weight " + murka.getWeight());
        System.out.println("Murka2 weight " + murka2.getWeight());
        while (murka.getWeight() > 1000)
        {
            murka.meow();
        }
        while (murka2.getWeight() < 9000)
        {
            murka2.feed(10.0);
        }
        System.out.println("Murka weight " + murka.getWeight());
        System.out.println("Murka2 weight " + murka2.getWeight());
        System.out.println(Cat.getCount()+ " cats");
        murka.meow();
        murka.feed(10.0);
        murka2.pee();
    }
}