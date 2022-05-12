public class Main {
    public static void main(String[] args) throws Exception {
        //Parser parser = new Parser();
        //parser.Start();

        String separateVar1 = "=";
        String separateVar2 = " ";
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
                separateVar2.repeat(17) + "1." + separateVar2.repeat(3) + "Codename Emoji\n" +
                separateVar2.repeat(17) + "2." + separateVar2.repeat(3) + "Randome Emoji\n" +
                separateVar2.repeat(17) + "0." + separateVar2.repeat(3) + "Exit.\n");
        System.out.print("Enter you choise:");

    }
}