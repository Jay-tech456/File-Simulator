// Manjesh Prasasd
//

import java.util.Scanner;

public class Entity {

    private final int SIZE = 10;                // We are going to start off with 1000 files

    Scanner input = new Scanner(System.in);
    directory root;                              // The root directory

    //************* Directory Class **********************************
    static class directory                       // The actual struct for the file
    {
        int a;
        directory back;
        directory forward;

        int availableSpace = 504;
        int count = 0;
        File f;

        directory() {                         // Default constructor for the stuct
            this.a = 0;
            this.back = null;
            this.forward = null;
            this.f = new File();
        }

    }



    /* Entity Class constructor for building directories */
    Entity() {
        this.root = null;
        // As soon as the program is run, we sould start off with 1000 directory
        for (int temp = 0; temp < SIZE; temp++) {
            create(temp);
        }

    }

    /* The primal focus on this is to create the original file system */
    public void create(int temp) {

        directory newFile = new directory();
        newFile.a = temp;

        directory FilePtr;


        if (root == null) {
            root = newFile;
            root.forward = null;
            root.back = null;
            return;
        }

        FilePtr = root;

        while (FilePtr.forward != null) {
            FilePtr = FilePtr.forward;
        }
        FilePtr.forward = newFile;
        FilePtr = FilePtr.forward;
        FilePtr.forward = null;

        return;

    }



    // **************  Print out the entire list ************************************
    public void print() {

        if (root == null)                        // If the root does not exist, then we cannot print anything
        {
            System.out.println("The head does not exist ");
            return;
        }

        directory Fileptr = root;
        while (Fileptr != null) {
            System.out.print(Fileptr.a);
            System.out.print(" ( Available Space " + Fileptr.availableSpace + " ) " + " ----> ");
            Fileptr = Fileptr.forward;
        }
        System.out.print(" NULL \n");
    }

    // *************** Observer *********************************
    public boolean doesExist(int temp) {
            if ( root == null) {
                System.out.println("The entire file system does not exist ");
                return false;
            } else if (temp > SIZE) {
                return false;
            }

            directory nodeptr = root;
            for(int count = 0; count < temp; count++ ) {
                    nodeptr = nodeptr.forward;
            }
            return true;


    }

    //******************* Creating a new file ************************ //
    public void newFile(int temp) {
            if(!doesExist(temp)){
                System.out.println("The Directory does not exist ");
                return;
            }

            directory nodeptr = root;
            for(int count = 0; count < temp; count++) {
                nodeptr = nodeptr.forward;
            }
            int space = nodeptr.f.createFile(nodeptr.count);
            nodeptr.count++;
            nodeptr.availableSpace = 512 - space;

    }

    public void openDirectory(int temp) {

        if (!doesExist(temp)) {
            System.out.println("The file does not exist ");
            return;
        }



        directory nodeptr = root;
        for (int count = 0; count < temp; count++) {
            nodeptr = nodeptr.forward;
        }

        nodeptr.f.accessFile();
    }

    public void defultFile(String name, int size, int directoryNum) {
        if(!doesExist(directoryNum)) {
            System.out.println("The directory does not exist!!!! ");
            return;
        }

        directory nodeptr = root;
        for(int count = 0; count < directoryNum; count++) {
            nodeptr = nodeptr.forward;
        }
        if(nodeptr.availableSpace < nodeptr.f.spaceUsed && nodeptr.availableSpace < size){
            System.out.println("The size of this file cannot fit in " + nodeptr.count + " directory, moving to another directory");
            nodeptr = nodeptr.forward;
        }
        nodeptr.f.createDefultFile(name, size, nodeptr.count);
        nodeptr.count++;
        nodeptr.availableSpace = 512 - nodeptr.f.spaceUsed;
        return;

    }

    public void deletingFile(int directoryNum)
    {
        if(!doesExist(directoryNum)) {
            System.out.println("The directory does not exist ");
            return;
        }
        else if(root == null){
            System.out.println("There is nothing inside the file system ");
            return;
        }

        directory nodeptr = root;

        for(int i = 0; i < directoryNum; i++){
            nodeptr = nodeptr.forward;
        }

        nodeptr.f.printFile();

        System.out.println("Please enter the file number, and we will delete it: ");
        int fileNum = input.nextInt();

        int space = nodeptr.f.deleteExistingFile(fileNum);;

        System.out.println("Deleting successful ");
        nodeptr.f.printFile();
        nodeptr.availableSpace = 512 - space;



    }

}



