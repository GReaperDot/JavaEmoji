import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static String separateVar1;
    private static String separateVar2;
    private static String charMenu;
    private static String found;
    private static String searchFileLine;
    private static String compensator;
    private static String filePath = "Emoji.txt";
    private static int count;
    private static int linesCount;
    private static int randomEmoji;

    public static void main(String[] args) throws Exception {
        separateVar2 = " ";
        separateVar1 = "=";

        Parser parser = new Parser(); parser.Start();
        Scanner scanner = new Scanner(System.in);

        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Random random = new Random();

        System.out.println("+" + separateVar1.repeat(50) + "+\n" +
                "=" + separateVar2.repeat(9) + "░░░░░██╗░█████╗░██╗░░░██╗░█████╗░" + separateVar2.repeat(8) + "=\n" +
                "=" + separateVar2.repeat(9) + "░░░░░██║██╔══██╗██║░░░██║██╔══██╗" + separateVar2.repeat(8) + "=\n" +
                "=" + separateVar2.repeat(9) + "░░░░░██║███████║╚██╗░██╔╝███████║" + separateVar2.repeat(8) + "=\n" +
                "=" + separateVar2.repeat(9) + "██╗░░██║██╔══██║░╚████╔╝░██╔══██║" + separateVar2.repeat(8) + "=\n" +
                "=" + separateVar2.repeat(9) + "╚█████╔╝██║░░██║░░╚██╔╝░░██║░░██║" + separateVar2.repeat(8) + "=\n" +
                "=" + separateVar2.repeat(9) + "░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝" + separateVar2.repeat(8) + "=\n" +
                "+" + separateVar1.repeat(50) + "+\n" +
                "=" + " Practical Work : Java Emoji : Bielietskiy Radion " + "=\n" +
                "+" + separateVar1.repeat(50) + "+\n");

        System.out.println("Available actions:\n" +
                separateVar2.repeat(17) + "a." + separateVar2.repeat(3) + "Codename Emoji\n" +
                separateVar2.repeat(17) + "b." + separateVar2.repeat(3) + "Randome Emoji\n" +
                separateVar2.repeat(17) + "q." + separateVar2.repeat(3) + "Exit.\n");

        do {
            System.out.print("Enter you choices: ");
            charMenu = scanner.nextLine();
            switch (charMenu) {
                case "a":
                    System.out.print("Enter Codename Emoji for search: ");

                    found = scanner.nextLine();
                    searchFileLine = bufferedReader.readLine();

                    while (!searchFileLine.equals(found)){
                        searchFileLine = bufferedReader.readLine();
                        count++;
                    } System.out.println(bufferedReader.readLine());
                    break;

                case "b":
                    System.out.print("Randome Emoji: ");

                    Stream<String> linesC = Files.lines(Paths.get(filePath));
                    linesCount = (int) linesC.count();

                    randomEmoji = random.nextInt(linesCount);

                    for(int i = 1; i <= randomEmoji; i = i + 2) {
                        compensator = bufferedReader.readLine();
                    } System.out.println(bufferedReader.readLine());
                    break;

                case "q":
                    fileReader.close();
                    return;
            }
        } while (!charMenu.equals("q"));
    }
}