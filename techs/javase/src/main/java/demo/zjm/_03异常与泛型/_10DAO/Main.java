package demo.zjm._03异常与泛型._10DAO;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student());
    }
}
