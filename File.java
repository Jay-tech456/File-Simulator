
import java.util.Scanner;
import java.util.Random;
public class File {

    Scanner input = new Scanner(System.in);


       private int [] SIZE;
       private String [] Name;
       private int [] fileNum;
       private String[] text;
       public int spaceUsed;
       private int numOfFile;

       public String fileArray[] = new String[]{
                "Hello world, this is what I have inside my file ",
                "Luke, I am your father" ,
                "The quick brown fox jumps over the large bush",
                "California is known as the 'Golden State' in the united states ",
                "Why soooooo seroius - Joker (The Dark Knight)"
       };


       File() {                             // Class constructor
           SIZE = new int[20];
           Name = new String[20];
           fileNum = new int[20];
           text  = new String[20];
           spaceUsed = 0;
           numOfFile = 0;

       }

    public int createFile(int count ) {                                  // To create newfiles within the list
        System.out.println("\nPlease enter a string for the file ");

        this.Name[count] = input.next();
        int space = 1000;
        while(space > this.spaceUsed) {
            System.out.println("There is only " + (512 - this.spaceUsed) + " Available in the file ");
            System.out.println("\nPlease enter the size of the file: ");
            this.SIZE[count] = input.nextInt();
            space = this.SIZE[count];
        }


            System.out.println("\nPlease enter the string that you wish to have within the file ");
            this.text[count] = input.next();

        this.spaceUsed = this.spaceUsed + SIZE[count];

        this.fileNum[count] = count;
        this.numOfFile = this.numOfFile + 1;


        return this.spaceUsed;

    }

    public void printFile() {
           for(int i = 0; i < Name.length; i++) {
               if(Name[i] == null) {
                   return;
               }

               System.out.println("File number " + this.fileNum[i]);
               System.out.println("File name " + this.Name[i]);
               System.out.println("File Size: " + this.SIZE[i] + "\n");

           }
    }

    public void accessFile() {
            printFile();

            System.out.println("Which file would you like to access? (enter file number: )");
            int temp = input.nextInt(this.numOfFile);

            System.out.println("File number " + this.fileNum[temp]);
            System.out.println("File Name: " + this.Name[temp]);
            System.out.println("File Size: " + this.SIZE[temp]);
            System.out.println("-------------------------- \n");
            System.out.println("Inside the file: " + this.text[temp]);
             System.out.println("-------------------------- \n");
            return;
    }

    public int deleteExistingFile(int count) {

        /* There are two ways to delete a file
         * Take the last element on the list and then override it with the last element
         * Illstrate the rest of the list to the certain position of the entire array
         *
         *
         * */
        int i = count;
        while(this.Name[i] != null){

//            System.out.println(this.Name[count + 1]);
            this.Name[i] = this.Name[i + 1];
            this.SIZE[i] = this.SIZE[i + 1];
             i++;
        }
        int temp = 0;
        i = 0;
        while(this.Name[i] != null) {
            temp = temp + this.SIZE[i];
            i++;
        }

        System.out.println("The total spaces used is " + i);

          System.out.println("The total space uses is: " + temp);

          return temp;

    }

    public void createDefultFile ( String name, int size, int count){
           this.Name[count] = name;
           this.fileNum[count] = count;
           this.SIZE[count] = size;

            Random random = new Random();
            int randomInt = random.nextInt(4);
            this.text[count] = fileArray[randomInt];
//           System.out.println(this.text[count]);
        this.spaceUsed = this.spaceUsed + SIZE[count];

        return;

    }

}

