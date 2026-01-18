import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1) Add Book");
            System.out.println("2) Remove Book");
            System.out.println("3) List Books");
            System.out.println("4) Add Member (Student)");
            System.out.println("5) Add Member (Teacher)");
            System.out.println("6) Remove Member");
            System.out.println("7) List Members");
            System.out.println("8) Borrow Book");
            System.out.println("9) Return Book");
            System.out.println("0) Exit");
            System.out.println("Borrow limit depends on member type (Student: 3, Teacher: 5)");
            System.out.print("Please enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try{
                switch (choice){

                    case 1:{
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());

                        Book book = new Book(isbn, title, author, stock);
                        library.addBook(book);
                        System.out.println("Book added successfully.");
                        break;
                    }

                    case 2:{
                        System.out.print("Enter the ISBN to remove: ");
                        String isbn = scanner.nextLine();
                        library.removeBook(isbn);
                        System.out.println("Book removed successfully.");
                        break;
                    }

                    case 3:{
                        library.listBooks();
                        break;
                    }

                    case 4:{
                        System.out.print("Student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Student Name: ");
                        String name = scanner.nextLine();

                        Student student = new Student(id, name);
                        library.addMember(student);
                        System.out.println("Student added successfully.");
                        break;
                    }

                    case 5:{
                        System.out.print("Teacher ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Teacher Name: ");
                        String name = scanner.nextLine();

                        Teacher teacher = new Teacher(id, name);
                        library.addMember(teacher);
                        System.out.println("Teacher added successfully.");
                        break;
                    }

                    case 6:{
                        System.out.print("Enter the Member ID to remove: ");
                        String id = scanner.nextLine();
                        library.removeMember(id);
                        System.out.println("Member removed successfully.");
                        break;
                    }

                    case 7:{
                        library.listMembers();
                        break;
                    }

                    case 8: {
                        System.out.print("Member ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Book ISBN: ");
                        String isbn = scanner.nextLine();

                        library.borrowBook(id, isbn);
                        System.out.println("Book borrowed.");
                        break;
                    }

                    case 9: {
                        System.out.print("Member ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Book ISBN: ");
                        String isbn = scanner.nextLine();

                        library.returnBook(id, isbn);
                        System.out.println("Book returned.");
                        break;
                    }

                    case 0: {
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    }

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
