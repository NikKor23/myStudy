public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        Container container2 = new Container();
        Container container3 = new Container();
        container.count += 12345;
        container2.count += 10;
        container3.count += 5059191;
        System.out.println(sumDigits(container.count));
        System.out.println(sumDigits(container2.count));
        System.out.println(sumDigitsCharacter(container3.count));

    }

    public static int sumDigits(Integer number)
    {
        int s = 0;
        String str = number.toString();
        int l = str.length() - 1;
        for ( int i = 0; i <= l; i++)
        {
            int a = Integer.parseInt(String.valueOf(str.charAt(i)));
            s += a;
        }
        return s;
    }

    public static int sumDigitsCharacter(Integer number)
    {
        int sum = 0;
        String str = number.toString();
        for (char c : str.toCharArray())
        {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }


}
