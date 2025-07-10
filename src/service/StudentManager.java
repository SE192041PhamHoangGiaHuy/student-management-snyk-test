package service;



public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner sc) {
        if (students.size() >= 100) {
            System.out.println("❌ Student list is full (maximum 100).");
            return;
        }

        try {
            System.out.print("Enter student ID (integer): ");
            int id = Integer.parseInt(sc.nextLine());
            if (getStudentById(id) != null) {
                System.out.println("❌ ID already exists.");
                return;
            }

            System.out.print("Enter full name (max 50 characters): ");
            String name = sc.nextLine();
            if (name.length() > 50) {
                System.out.println("❌ Name is too long.");
                return;
            }

            System.out.print("Enter GPA (0.0–4.0): ");
            double gpa = Double.parseDouble(sc.nextLine());
            if (gpa < 0.0 || gpa > 4.0) {
                System.out.println("❌ Invalid GPA.");
                return;
            }

            students.add(new Student(id, name, gpa));
            System.out.println("✅ Student added successfully!");

        } catch (NumberFormatException e) {
//            System.out.println("❌ Invalid number format.");
        }
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        Student s = getStudentById(id);
        if (s != null) {
            students.remove(s);
            System.out.println("✅ Student deleted successfully.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void searchStudent(Scanner sc) {
        System.out.print("Enter name to search (partial or full): ");
        String keyword = sc.nextLine().toLowerCase(Locale.ROOT);
        boolean found = false;

        for (Student s : students) {
            if (s.getFullName().toLowerCase(Locale.ROOT).contains(keyword)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No matching student found.");
        }
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }

        System.out.println("ID    | Full Name                     | GPA");
        System.out.println("-----------------------------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}
