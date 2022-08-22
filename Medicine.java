import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashSet;

public class Medicine {

    public static void main(String[] args) throws FileNotFoundException {

        File medicines = new File("C:\\Users\\Jacoe\\Desktop" +
                "\\ITJVA2 Project_2_Jaco_Ellis_4l6yww7b8_Tyger_Valley_Campus_BSc_IT" +
                "\\Project2Question1\\medicines.txt");

        Scanner scan = new Scanner(medicines);

        String Drug1 = "";
        String Drug2 = "";
        String Drug3 = "";
        String Drug4 = "";
        String Drug5 = "";

        Drug1 = scan.nextLine();
        Drug1 = Drug1.replaceAll(","," ");

        Drug2 = scan.nextLine();
        Drug2 = Drug2.replaceAll(","," ");

        Drug3 = scan.nextLine();
        Drug3 = Drug3.replaceAll(","," ");

        Drug4 = scan.nextLine();
        Drug4 = Drug4.replaceAll(","," ");

        Drug5 = scan.nextLine();
        Drug5 = Drug5.replaceAll(","," ");

        HashSet<String> Drugs = new HashSet<String>();
        Drugs.add(Drug1);
        Drugs.add(Drug2);
        Drugs.add(Drug3);
        Drugs.add(Drug4);
        Drugs.add(Drug5);

        System.out.println();
        System.out.println("Medirite Medicines:");
        System.out.println("ID Name Type Manufacturer Price");
        Iterator<String> Herbs = Drugs.iterator();
        while (Herbs.hasNext()){
            System.out.println(Herbs.next());
        }
    }
}
