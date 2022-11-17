import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.io.*;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String args[]) throws ParseException {

        try {

            MyFrame frame = new MyFrame();

            String url = "jdbc:sqlanywhere:UserID=dba;Password=sql;Host=localhost:2638;ServerName=d4wstas;DatabaseName=d4w";

            Connection con = DriverManager.getConnection(url);

            int x = 2;

            while (x > 1) {
                Thread.sleep(1000);
                x = frame.getX();
                System.out.println(x);
            }

            Statement stmt = con.createStatement();
            String sql = frame.final4;
            System.out.println(sql+ "test");

            stmt.executeUpdate(sql);

            JFrame frame2 = new JFrame();
            JLabel label = new JLabel();
            frame2.add(label);

        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog (null, "Connection error!", "Title", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}