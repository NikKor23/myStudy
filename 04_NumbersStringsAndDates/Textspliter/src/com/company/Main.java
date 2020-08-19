package com.company;

public class Main {

    public static void main(String[] args) {
	    String text = "A new report on the state of American youth says teenagers are very concerned about the direction their nation is taking." +
                " They feel the upcoming presidential election will have as big impact on their lives, as the presidential election in 2004. " +
                "The survey released by the Horatio Alger Association of Distinguished Americans looked at the views of more than 1000 young people aged 13 to l9." +
                " According to that study, 62 percent of the U.S. teens believed the Kerry-Bush election in 2004 would make a large difference in the direction of the country and 70 percent said they cared who would win.";
	     textSpliter(text);
    }

    public static void textSpliter (String text) {
        String[]  splitText = text.split("\\s+");
        for (int i = 0; i < splitText.length; i++) {
            splitText[i] = splitText[i].replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(splitText[i]);
        }
    }
}
