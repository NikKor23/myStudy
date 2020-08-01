
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();
        System.out.println("Murka weight " + murka.getWeight());
        murka.feed(148.0);
        System.out.println("Murka weight " + murka.getWeight());
        murka.pee();
        murka.pee();
        murka.pee();
        System.out.println("Murka weight " + murka.getWeight());
        System.out.println(murka.foodAmount());
    }
}