
public class Loader
{
    public static void main(String[] args)
    {
        String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String text2 = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        symbol(text);
        symbol(text2);
    }

    public static void symbol(String string)
    {
        String str = string;
        str.trim();
        System.out.println(str);
        for (int i = 0; i <= str.length() - 1; i++)
        {
            int sym = str.charAt(i);
             System.out.println(str.charAt(i) + " " + sym);
        }

    }
}