
public class Cat
{
    private double originWeight;
    private double weight;

    private double food;
    public static int count;

    private static final int EYES = 2;
    private static final int LEGS = 4;
    private static final int EARS = 2;
    private static final int TAIL = 1;
    private static final double MINWEIGHT = 1000;
    private static final double MAXWEIGHT = 9000;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;

    }

    public static int getCount()
    {
        return count;
    }

    public void pee()
    {
        if (weight < MINWEIGHT || weight > MAXWEIGHT) {
            System.out.println("This cat is dead");
            return;
        }
        weight = weight - (80 + 10 * Math.random());
        System.out.println("Clean up after the cat");
    }

    public double foodAmount()
    {
        if (food != 0)
        {
            System.out.print("Cat have eaten ");
            return food;
        }
        else
        {
            System.out.println("Cat did not eat");
            return 0;
        }

    }

    public void meow()
    {
        if (weight < MINWEIGHT || weight > MAXWEIGHT) {
            System.out.println("This cat is dead");
            return;
        }
        weight = weight - 1;
        if (weight < MINWEIGHT) --count;
        //System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        if (weight < MINWEIGHT || weight > MAXWEIGHT) {
            System.out.println("This cat is dead");
            return;
        }
        food = food + amount;
        weight = weight + amount;
        if (weight > MAXWEIGHT) --count;

    }

    public void drink(Double amount)
    {
        if (weight < MINWEIGHT || weight > MAXWEIGHT) {
            System.out.println("This cat is dead");
            return;
        }
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MINWEIGHT) {
            return "Dead";
        }
        else if(weight > MAXWEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}