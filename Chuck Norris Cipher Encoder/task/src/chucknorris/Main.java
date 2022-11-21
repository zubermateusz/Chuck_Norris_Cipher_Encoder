package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input string:");
        // wczytanie tekstu od uzytkownika
        StringBuilder text = new StringBuilder(new Scanner(System.in).nextLine());
        StringBuilder textOutput = new StringBuilder();
        // sprawdzenie czy cos zostalo wpisane
        //if (text.length() > 0) { //usuniete dla Stage 2/5
            //wyswietlenie tekstu w formie binarnej STAGE 2/5
            //System.out.println(" ");

            textOutput.append("The result:\n");
            for (int i = 0; i < text.length(); i++) {
                // pobiera char, rzutuje na int, przerabia na binary i parsuje na int, dodaje zera przez liczba do 7 cyfr
                textOutput.append(text.charAt(i) + " = " + String.format("%07d", Integer.parseInt(Integer.toBinaryString(text.charAt(i)))) + "\n");
            }
/*            // wstawienie spacji po kazdym znaku STAGE 1/5
            for (int i = 0; i < text.length(); i++) {
                textOutput.append(text.charAt(i)).append(' ');
            }
            // usuniecie spacji na koncu napisu
            textOutput.deleteCharAt(textOutput.length() - 1);
            // wyswietlenie tekstu
            //System.out.println(textOutput);

 */
        //}
        System.out.println(textOutput);
    }
}