import java.sql.*;
import java.util.Scanner;


public class Student {
    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException, SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "admin");

            boolean cases = true;
            while (cases) {
                System.out.println("Choose the Option: \n");
                System.out.println("1- Insert a record\n" +
                        "2- Update a record\n" +
                        "3- Retrieve the record\n" +
                        "4- Delete the record\n" +
                        "other - Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        insertRecord();
                        break;
                    case 2:
                        updateRecord();
                        break;
                    case 3:
                        retrieveRecord();
                        break;
                    case 4:
                        deleteRecorrd();
                        break;

                    default:
                        cases = false;
                        break;
                }
            }
        } catch (Exception ex) {

        } finally {
            con.close();
        }

    }

    private static void deleteRecorrd() throws SQLException {
        System.out.println("---------------------------------------------------------------------------------------------");
        Statement st = (Statement) con.createStatement();
        ResultSet rs = null;
        retrieveRecord();
        System.out.println("Which regdno do you want to delete : ");
        int record = sc.nextInt();
        try {
            rs = st.executeQuery("delete from student where regdno=" + record + ";");
            System.out.println("Record Deleted !!");
        } catch (Exception ignored) {
            System.out.println("Record Not found and not deleted !!, please try again...");
        }

        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void retrieveRecord() throws SQLException {
        System.out.println("---------------------------------------------------------------------------------------------");
        Statement st = (Statement) con.createStatement();
        ResultSet rs = null;
        rs = st.executeQuery("select * from student");
        while (rs.next())
            System.out.println(rs.getInt("regdno") + ", " + rs.getString("stdname") + ", " + rs.getString("branch") + ", " + rs.getInt("mark"));
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void updateRecord() throws SQLException {
        System.out.println("---------------------------------------------------------------------------------------------");
        Statement st = (Statement) con.createStatement();
        ResultSet rs = null;
        retrieveRecord();
        System.out.println("which id do you want to update : ");
        int regid = sc.nextInt();
        System.out.println("Please update below details - ");
        System.out.println("Name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Branch : ");
        String branch = sc.nextLine();
        System.out.println("Mark : ");
        int mark = sc.nextInt();
        String qry = "update student set stdname='" + name + "', branch='" + branch + "', mark = " + mark + " where regdno=" + regid + "";
        System.out.println(qry);
        int z = st.executeUpdate(qry);
        if (z > 0)
            System.out.println("Data Inserted Successfully !!");

        System.out.println("Record updated !!");

        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void insertRecord() throws SQLException {
        System.out.println("---------------------------------------------------------------------------------------------");
        Statement st = (Statement) con.createStatement();
        System.out.println("Enter below details to insert record - ");
        System.out.println("Reg ID : ");
        int id = sc.nextInt();
        System.out.println("Name : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Branch : ");
        String branch = sc.nextLine();
        System.out.println("Mark : ");
        int mark = sc.nextInt();
        String qry = "insert into student  values(" + id + ", '" + name + "', '" + branch + "', " + mark + ")";
        System.out.println(qry);
        try {
            int z = st.executeUpdate(qry);
            if (z > 0)
                System.out.println("Data Inserted Successfully !!");
        } catch (Exception ex) {
            System.out.println("Duplicate Data !!,  please enter unique id..");
        }
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
