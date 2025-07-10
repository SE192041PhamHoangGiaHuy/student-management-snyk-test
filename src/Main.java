
import service.StudentManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT MENU ====");
            System.out.println("1. Add student");
            System.out.println("2. Delete student by ID");
            System.out.println("3. Search student by name");
            System.out.println("4. Display all students");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            String choice = sc.nextLine();

           switch (choice) {
               case "1":
                   manager.addStudent(sc);
                   break;
               case "2":
                   manager.deleteStudent(sc);
                   break;
               case "3":
                   manager.searchStudent(sc);
                   break;
               case "4":
                   manager.displayAll();
                   break;
               case "0":
                   System.out.println("Exiting program...");
                   return;
               default:
                   System.out.println("❌ Invalid choice. Please try again.");
           }

       }
        //     if (choice == "1") {
        //         manager.addStudent(sc);
        //     } else if (choice == "2") {
        //         manager.deleteStudent(sc);
        //     } else if (choice == "3") {
        //         manager.searchStudent(sc);
        //     } else if (choice == "4") {
        //         manager.displayAll();
        //     } else if (choice == "0") {
        //         System.out.println("Exiting program...");
        //         return;
        //     } else {
        //         System.out.println("❌ Invalid choice. Please try again.");
        //     }
        // }
    }
}
