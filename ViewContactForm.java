import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ViewContactForm extends JFrame {
    private JButton btnReload;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    public void reload() {
        dtm.setRowCount(0);
        list contacList = ContactDBConnection.getInstance().getContactList();
        for (int i = 0; i < contacList.size(); i++) {
            Contact contact = contacList.get(i);
            Object[] rowData = { contact.getId(), contact.getName(), contact.getMobile(),
                    contact.getCompany(),
                    contact.getSalary(), contact.getBirthday() };
            dtm.addRow(rowData);
        }
    }

    ViewContactForm(String title, int x) {
        if (x == 0) {
            ContactController.sortName();
            System.out.println("nme");
        } else if (x == 1) {
            ContactController.sortSalary();
        } else if (x == 2) {
            ContactController.sortBirthday();
        }
        setSize(600, 300);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // JLabel titleLabel = new JLabel(title);
        // titleLabel.setFont(new Font("", 1, 30));
        // titleLabel.setHorizontalAlignment(JLabel.CENTER);
        // add("North", titleLabel);

        JPanel container = new JPanel();
        JPanel n = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel(title);
        container.setBackground(new Color(153, 205, 253));
        n.setBackground(new Color(153, 205, 253));
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(titleLabel);
        add("North", container);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnReload = new JButton("Reload");
        btnReload.setFont(new Font("", 1, 20));
        buttonPanel.add(btnReload);
        btnReload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (x == 0) {
                    ContactController.sortName();
                    System.out.println("nme");
                } else if (x == 1) {
                    ContactController.sortSalary();
                } else if (x == 2) {
                    ContactController.sortBirthday();
                }
                dtm.setRowCount(0);
                list contacList = ContactDBConnection.getInstance().getContactList();
                for (int i = 0; i < contacList.size(); i++) {
                    Contact contact = contacList.get(i);
                    Object[] rowData = { contact.getId(), contact.getName(), contact.getMobile(),
                            contact.getCompany(),
                            contact.getSalary(), contact.getBirthday() };
                    dtm.addRow(rowData);
                }
            }
        });
        add("South", buttonPanel);

        // ----------------------------------------------
        String[] columnName = { "Contact ID", "Name", "Mobile", "Company", "Salary", "Birthday" };
        dtm = new DefaultTableModel(columnName, ContactMainForm.customerList.size());
        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        add("Center", tablePane);
    }

    ViewContactForm() {

        setSize(600, 300);
        setTitle("title");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // JLabel titleLabel = new JLabel("View Customer Form");
        // titleLabel.setFont(new Font("", 1, 30));
        // titleLabel.setHorizontalAlignment(JLabel.CENTER);
        // add("North", titleLabel);

        JPanel title = new JPanel();
        JPanel n = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("UPDATE CONTACT");
        title.setBackground(new Color(153, 205, 253));
        n.setBackground(new Color(153, 205, 253));
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.add(titleLabel);
        add("North", title);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnReload = new JButton("Reload");
        btnReload.setFont(new Font("", 1, 20));
        buttonPanel.add(btnReload);
        btnReload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dtm.setRowCount(0);
                list contacList = ContactDBConnection.getInstance().getContactList();
                for (int i = 0; i < contacList.size(); i++) {
                    Contact contact = contacList.get(i);
                    Object[] rowData = { contact.getId(), contact.getName(), contact.getMobile(),
                            contact.getCompany(),
                            contact.getSalary(), contact.getBirthday() };
                    dtm.addRow(rowData);
                }
            }
        });
        add("South", buttonPanel);

        // ----------------------------------------------
        String[] columnName = { "Contact ID", "Name", "Mobile", "Company", "Salary", "Birthday" };
        dtm = new DefaultTableModel(columnName, ContactMainForm.customerList.size());
        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        add("Center", tablePane);
    }
}
