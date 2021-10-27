// Manjesh Prasad
// 421 Final Project


import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.Random;
public class Main {

    public static void main(String[] args) throws IOException {


        Entity a = new Entity();

        int option = 1;
        int temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like: ");
        System.out.println("1. Create a new file system from scratch: ");
        System.out.println("2. Use the defualt file system: ");
        System.out.println("Please choose your option: ");
        int i = input.nextInt();

        if (i == 2) {


            Random rand = new Random();

            String file = "src/testing.txt";
           Scanner scanner = new Scanner ( new File(file));
            scanner.useDelimiter(" ");

            while(scanner.hasNext()){
                int randInt = rand.nextInt(4);
                //System.out.println(randInt);
                String next = scanner.next();
                //System.out.println(next);

                int num = scanner.nextInt();
                //System.out.println(num + "\n\n");
                a.defultFile(next, num, randInt);

            }
            scanner.close();

        }

        a.print();                       // print the existing file within the entire file system
        System.out.println(" You have 4directories, which would you like to access ");     // Enter the directory you would like to enter
        temp = input.nextInt();


        while (a.doesExist(option)) {
            System.out.println(" On Directory  " + temp + " Please enter an option ");
            System.out.println("1. create a new file ");                             // create a new file
            System.out.println("2. Access new Directory ");                         // Access new directory
            System.out.println("3. Deleting file in a directory");                                 // Access a file
            System.out.println("4. Print all the file within directory: ");
            System.out.println("5. Quit ");
            option = input.nextInt();


            switch (option) {
                case 1:                         // Creating a new File
                    a.newFile(temp);
                    break;
                case 2:                         // Access new directory
                    a.print();                       // print the existing file within the entire file system
                    System.out.println(" You have 10 directories, which would you like to access ");     // Enter the directory you would like to enter
                    temp = input.nextInt();
                    break;
                case 3:                         // deleting a file
                    a.deletingFile(temp);
                    break;
                case 4:
                    a.openDirectory(temp);      // openning up the file
                    break;
                case 5:                         // QUIT
                    option = 11;
                    break;
                default:
                    continue;


            } // End of the switch statement
        } // End of the while loop
    }
} // End of the entire main class

