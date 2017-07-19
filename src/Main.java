import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String userWord; //Initial user input
        String lcUserWord; //User input converted to lowercase
        String userAns; //Accepts user's response to continue


        System.out.println("Welcome to the Pig Latin Translator!");

        System.out.println();

        //USER INPUT
        do
        {
            //Gets input from user
            System.out.print("Enter a word to be translated: ");
            userWord = scan.nextLine();

            //Converts user's answer to lowercase
            lcUserWord = userWord.toLowerCase();

            pigLatinGen(lcUserWord);


            //Asks the user if they would like to enter another word so the program either loops or exits
            System.out.println("Would you like to enter another word (Yes/No)?");
            userAns = scan.nextLine();
        } while(userAns.equalsIgnoreCase("Yes"));

    }

    //pigLatinGen METHOD

    public static void pigLatinGen(String pigLatin)
    {
        //Passes lcUserWord from main to pigLatin varible & then restores it back into lcUserWord
        String lcUserWord = pigLatin;

        //Loops through each letter of the word
        for(int i = 0; i < lcUserWord.length(); i++)
        {
            //Declare a new char variable to hold the first char of the string
            char firstChar = lcUserWord.charAt(i);

            //Check to see if the first char is a vowel
            if((firstChar == 'a') || (firstChar == 'e') || (firstChar == 'i') || (firstChar == 'o') || (firstChar == 'u'))
            {

                //Checks to see if the first char  really is a vowel. If so, adds "way"
                if (i == 0)
                {
                    lcUserWord = lcUserWord.concat("way");
                    System.out.println("The pig latin word for " + lcUserWord);
                    break;
                }

            } //END OF FIRST IF
            else
            {
                //takes the userword & stores all the letters from the first vowel to the end of the word in a new variable
                String withVowel = lcUserWord.substring(i);
                System.out.println("With Vowel: " +withVowel);


                //Takes all the letters from before the first vowel & store them into a new variable
                String beforeVowel = lcUserWord.substring(0,i);
                System.out.println("Before vowel: " + beforeVowel);

                //Concatenates the new string
                pigLatin = pigLatin.concat(withVowel + beforeVowel + "ay");

                //Prints results
                System.out.println(pigLatin);
                System.out.println();
                break;
            }

        }
    }

} //END OF MAIN
