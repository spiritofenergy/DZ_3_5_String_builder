package org.example;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println("1.Пользователь вводит стихотворение из четырёх строк. Соберите их в одну переменную, между каждой строкой вставьте символ переноса строки: «\\n»");

        Scanner scanner = new Scanner(System.in);
    /*    String unoString = "Я сразу смазал карту будня,"; //scanner.nextLine();
        String dosString = "плеснувши краску из стакана;"; //scanner.nextLine();
        String tresString = "я показал на блюде студня"; //scanner.nextLine();
        String cuatroString = "косые скулы океана."; //scanner.nextLine();
        String allString = "\n" + unoString + "\n" + dosString + "\n" + tresString + "\n" + cuatroString;
        System.out.println(allString);


        //////////////////
        System.out.println("2.Пользователь вводит три слова, соберите из них строку, где слова будут в обратном порядке ");

        Scanner scanner = new Scanner(System.in);
        String strLine = scanner.nextLine();
        String str = reverseString(strLine);
        System.out.println(str);


        System.out.println("3.Пользователь вводит слово. Добавьте к нему в начало «вы говорите:» ... слово пользователя. И в конец: «.. и что?»");
            Scanner sc = new Scanner(System.in);
            String oneString = "Вы говорите:  ";
            String twoString = sc.nextLine();
            String treeString = " и что?";
        System.out.println(oneString + twoString + treeString);
        System.out.println("4.Пользователь вводит пять слов, соберите из них целую строку, между каждым словом вставьте «, и»");
        StringBuilder builder = new StringBuilder();
         String str1 = scanner.nextLine();
         String str2 = scanner.nextLine();
         String str3 = scanner.nextLine();
         String str4 = scanner.nextLine();
         String str5 = scanner.nextLine();
         builder.append(str1);
         builder.append(" и ");
         builder.append(str2);
         builder.append(" и ");
         builder.append(str3);
         builder.append(" и ");
         builder.append(str4);
         builder.append(" и ");
         builder.append(str5);
         System.out.println(builder);

        System.out.println("5.Пользователь вводит предложение их двух слов (считайте в одну переменную String phrase). Вставьте между этими словами «так сказать» используя StringBuilder.insert. Было: «Учу Java». Станет: «Учу, так сказать, Java»");
        StringBuilder build = new StringBuilder();
        String phrase = "Учу java";
        build.append(phrase);
        build.insert(3, " так сказать ");
        System.out.println(build);

       System.out.println("6.Пользователь вводит число, любое. 237, например. Выведите: 237 программистов, окончание должно зависеть от числа. 1 программист, 2 программиста, и так далее");

                Scanner scanner3 = new Scanner(System.in);
                System.out.print("Введите число: ");
                int number = scanner3.nextInt();
                // Получаем последнюю цифру числа
                int pastNumber = number % 10;
                // Получаем вторую с конца цифру (если она есть)
                int twoNumber = (number / 10) % 10;
                // Если вторая цифра равна 1, то используем форму для чисел оканчивающихся на 11, 12, 13, 14
                if (twoNumber != 1) {
                    switch (pastNumber) {
                        case 1:
                            System.out.println(number + " программист");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            System.out.println(number + " программиста");
                            break;
                        default:
                            System.out.println(number + " программистов");
                    }
                } else {
                    // Если вторая цифра равна 1, то используем форму для чисел оканчивающихся на 11, 12, 13, 14
                    System.out.println(number + " программистов");
                }
                scanner.close();

       ////////////////
       System.out.println("7.Пользователь вводит предложение, удалите все пробелы из него");
       String sb ="";
       String sbString = scanner.nextLine();
       sb = sbString.replace(" ", "");
       System.out.println(sb);
      /////////////////
        System.out.println("8.Вернитесь к программе, которая запрашивает курс валют. " +
                "Напишите генератор даты для запроса к апи, на основе даты, введенной пользователем. " +
                "ИспользуйтеStringBuilder");
            int day = scanner.nextInt();
            StringBuilder sbDay = new StringBuilder();
            sbDay.append(day);
            String strDay = day < 10 ? "0" + sbDay : String.valueOf(sbDay);
            String page1 = downloadWebPage("http://www.cbr.ru/scripts/XML_daily.asp?date_req="+ strDay +"/11/2020");
            int startIndex1 = page1.lastIndexOf("<Value>");
            int endIndex1 = page1.lastIndexOf("</Value>");
            String courseStr1 = page1.substring(startIndex1 + 7, endIndex1);
            System.out.println(courseStr1);
}
*/


     System.out.println("9.Скачайте цитату из breaking bad и замените все плохие слова звёздочками");

        String[] quotes = new String[8];
       for (int i = 0; i < quotes.length; i++) {
             quotes[i] = "";
        }
       //String [] words = new String[]{"bitch", "marijuana", "butts", "fucking", "can go f*ck yourself", "douchebag", "Douchebags", "Shit"};
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            String page = downloadWEbPage("https://api.breakingbadquotes.xyz/v1/quotes");
            int quoteStart = page.lastIndexOf("quote");
            int quoteEnd = page.indexOf("author");
            int author_4 = page.indexOf("\"}]");
            String quote = page.substring(quoteStart + 7, quoteEnd - 2);
            String author = page.substring(quoteEnd + 9, author_4);
           // String strShortQuote = page.substring(quote4 + 7, quote4 + 50);
            String newQuoteWithAuthor = quote;
            // проверка дубликатов
            boolean wordInArray = isWordInArray(quotes, newQuoteWithAuthor);
            // Удаление повторов
            extractedDuplicates(quotes, i, newQuoteWithAuthor, wordInArray);
            //удаление плохих слов
            //запись в файл
            writerFileString(newQuoteWithAuthor);

        }
        for (int y = 0; y < quotes.length; y++) {
            Thread.sleep(500);
            counter++;
           System.out.println(counter + " " + quotes[y]);
       }
     }
    private static String deleteBadWords(String newQuoteWithAuthor) {
        String [] badWords = new String[]{"bitch", "marijuana", "butts", "fucking", "can go f*ck yourself", "douchebag", "Douchebags", "Shit"};
        String str2 = "";
        for(int x = 0; x < badWords.length; x++){
            if(newQuoteWithAuthor.contains(badWords[x])){
                str2 = newQuoteWithAuthor.replace(badWords[x], "***");

            }}
        return str2;
    }

    private static void extractedDuplicates(String[] quotes, int i, String newQuoteWithAuthor, boolean wordInArray) throws IOException {
        String [] badWords = new String[]{"bitch", "marijuana", "butts", "fucking", "can go f*ck yourself", "douchebag", "Douchebags", "Shit"};
        if(wordInArray) {
             System.out.println("Word in array");
            }else {
            quotes[i] = deleteBadWords(newQuoteWithAuthor);
        }
    }
    private static boolean isWordInArray(String[] quotes, String newQuoteWithAuthor) {
        boolean wordInArray = false;
        for (int currentQuoteIndex = 0; currentQuoteIndex < quotes.length; currentQuoteIndex++) {
            String existingQuote = quotes[currentQuoteIndex];
            if (existingQuote.equals(newQuoteWithAuthor)) {
                wordInArray = true;
            }
        }
        return wordInArray;
    }

    private static void writerFileString(String strQuote) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Sinergy\\DZ_3_5_String_builder\\src\\main\\java\\org\\example\\text.txt", true));
        writer.append(strQuote + "\n");
        writer.close();
    }

    private static String downloadWEbPage (String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }


     /*      System.out.println("10.Напишите крестики-нолики, используя StringBuilder");
        System.out.println("11.Пусть пользователь вводит поля класса FileInformation, но в одну строку; формат придумайте сами. Считайте ввод пользователя и из него создайте экземпляр класса");
 */



    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}