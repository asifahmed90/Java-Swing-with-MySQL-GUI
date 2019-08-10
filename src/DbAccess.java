
/*
UML DIAGRAM

DbAccess
----------

+DbAccess():void
+firstColumn(): ArrayList<Double>
+secondColumn(): ArrayList<Double>
+thirdColumn(): ArrayList<Double>

 */



import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class DbAccess extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = getContentPane();
    JTable jtbl = new JTable(model);

    public DbAccess() throws HeadlessException  {

        model.addColumn("OilGal");
        model.addColumn("Temperature");
        model.addColumn("Insulation");
        jtbl.setFont(new Font("Serif", Font.PLAIN, 18));
        jtbl.setRowHeight(20);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://131.193.209.69:3306/f17x321", "f17x321", "f17x321TS");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM f17x321.energy");
            ResultSet rs = pstm.executeQuery();

            while(rs.next())
            {
                String d = rs.getString("OilGal");
                String e = rs.getString("Temperature");
                String f = rs.getString("Insulation");
                model.addRow(new Object[]{d, e, f});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();

    }

    public ArrayList<Double> firstColumn(){
        ArrayList<Double> list = new ArrayList<>();

        for(int i = 0; i < jtbl.getRowCount(); i++){
            String num = ((String) jtbl.getValueAt(i,0));
            Double input = Double.parseDouble(num);
            list.add(input);

        }

        return list;

    }

    public ArrayList<Double> secondColumn(){
        ArrayList<Double> list = new ArrayList<>();

        for(int i = 0; i < jtbl.getRowCount(); i++){
            String num = ((String) jtbl.getValueAt(i,1));
            Double input = Double.parseDouble(num);
            list.add(input);

        }

        return list;

    }

    public ArrayList<Double> thirdColumn(){
        ArrayList<Double> list = new ArrayList<>();

        for(int i = 0; i < jtbl.getRowCount(); i++){
            String num = ((String) jtbl.getValueAt(i,2));
            Double input = Double.parseDouble(num);
            list.add(input);

        }

        return list;

    }
}