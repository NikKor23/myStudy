
public class Cat
{
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double food;
    public static int count;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

    }

    public static int getCount()
    {
        return count;
    }

    public void pee()
    {
        if (weight < minWeight || weight > maxWeight) {
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
        if (weight < minWeight || weight > maxWeight) {
            System.out.println("This cat is dead");
            return;
        }
        weight = weight - 1;
        if (weight < minWeight) --count;
        //System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        if (weight < minWeight || weight > maxWeight) {
            System.out.println("This cat is dead");
            return;
        }
        food = food + amount;
        weight = weight + amount;
        if (weight > maxWeight) --count;
    }

    public void drink(Double amount)
    {
        if (weight < minWeight || weight > maxWeight) {
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
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
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