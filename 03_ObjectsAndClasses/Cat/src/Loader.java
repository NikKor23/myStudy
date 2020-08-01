
public class Loader
{
    public static void main(String[] args)
    {
        Cat murka = new Cat();
        Cat vasya = new Cat();
        Cat eva = new Cat();
        Cat kuzya = new Cat();
        Cat rizhik = new Cat();

        System.out.println("Ева весит " + eva.getWeight());
        eva.feed(10.0);
        System.out.println("Ева поела и весит " + eva.getWeight());

        System.out.println("Кузя весит " + kuzya.getWeight());
        kuzya.feed(24.5);
        System.out.println("Кузя поел и весит " + kuzya.getWeight());

        System.out.println("Мурка весит " + murka.getWeight());
        while (murka.getWeight() > 1000) {
            murka.meow();
        }

        System.out.println("Васька весит " + vasya.getWeight());
        while (vasya.getWeight() < 9000) {
            vasya.feed(300.0);
        }
        System.out.println("Мурка много мяукала, она весит " + murka.getWeight() + " и " + murka.getStatus());
        System.out.println("Вася много кушал, он весит " + vasya.getWeight() + " и " + vasya.getStatus());
    }
}