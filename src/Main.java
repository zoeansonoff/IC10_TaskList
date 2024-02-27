import java.io.*;
import java.util.Scanner;
// To Serialize a class (write to binary file, must make the class serializable)
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner keyboard = new Scanner(System.in);

        int priority = 1;
        int count = 0, choice;
        Task[] Task = new Task[0];
        String deadline, dueDate, name;


        File BINARY_FILE = new File("Task.dat");


        System.out.println("Loading Task Information from Database...");
        Task[] myTasks;
        if(BINARY_FILE.exists()) {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
                myTasks = (Task[]) fileReader.readObject();
                fileReader.close();
                for (int i = 0; i < myTasks.length; i++) {
                    if (myTasks[i] == null)
                        break;

                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
        // TODO: Load contacts from binary file
        System.out.println("Done! contacts loaded");

        do {
            System.out.print(
                    "\n********************************************************************\n"
                            + "**                                                                **\n"
                            + "**                       ZOE'S TASK LIST                    **\n"
                            + "**                                                                **\n"
                            + "********************************************************************\n"
                            + "1) Add New Deadline...\n"
                            + "2) View due date\n"
                            + "3) View task name\n"
                            + "4) Task priority 1-3\n"
                            + "5) Exit Task list\n"
                            + "********************************************************************\n"
                            + ">> ");
            choice = keyboard.nextInt();

            switch (choice)
            {
                case 1:  // Add New Contact...
                    // Clear out \n from keyboard
                    keyboard.nextLine();
                    System.out.print("Deadline: ");
                    deadline = keyboard.nextLine();
                    System.out.print("due date: ");
                    dueDate = keyboard.nextLine();
                    System.out.print("name: ");
                    name = keyboard.nextLine();
                    System.out.print("priority (1-3): ");
                    priority = Integer.parseInt(keyboard.nextLine());
                    System.out.println("To exit, press 5.");


                    // TODO: Instantiate new Contact, add it to the array;
                    new Task(deadline, dueDate, name, priority);

                    break;

                case 2:  // View Contact Names
                    System.out.println("\n********************************************************************");
                    System.out.println("                        Task List                                    ");
                    System.out.println("********************************************************************");
                    // TODO: Print contact names (only)
                    
                    for (int i = 0; i < count; i++) {
                        System.out.println(Task[i].getDueDate());

                    }
                    break;

                case 3:  // View Contact Details
                    System.out.println("\n********************************************************************");
                    System.out.println("                        Task List");
                    System.out.println("********************************************************************");
                    // TODO: Print contact details
                    for (int i = 0; i < count; i++) {
                        System.out.println(Task[i].getDeadline());

                    }
                    break;

                case 4:  // Exit
                    System.out.println("Saving Task Information to Database...");
                    try {
                        ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
                        fileWriter.writeObject(Task);
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:  // Error - Invalid input
                    System.err.println("Invalid choice. Please select (1-4)");
                    Thread.sleep(500); // To pause a bit of time (e.g. 0.5 second) before restarting loop

            }

        }
        while (choice != 5);

        // TODO: Save contacts to binary file
        System.out.println("Done! Tasks saved");

        keyboard.close();
    }

}