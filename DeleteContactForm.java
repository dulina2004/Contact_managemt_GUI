import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteContactForm extends JFrame {
    private int index;
    private JButton btnCancel;
    private JButton btnSearch;
    private JButton btnDelete;
    private JTextField txtsearch;
    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtMobile;
    private JLabel txtCompany;
    private JLabel txtSalary;
    private JLabel txtBirthday;

    DeleteContactForm() {
        setSize(600, 500);
        // setTitle("Add Customer Form");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel title = new JPanel();
        JPanel n = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("DELETE CONTACT");
        title.setBackground(new Color(153, 205, 253));
        n.setBackground(new Color(153, 205, 253));
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.add(titleLabel);
        n.add(title);

        JPanel searchPanel = new JPanel();
        txtsearch = new JTextField(15);
        txtsearch.setFont(new Font("", 1, 20));
        searchPanel.add(txtsearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", 1, 20));

        searchPanel.add(btnSearch);
        n.add(searchPanel);
        add("North", n);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String nameOrMobile = txtsearch.getText();
                int index = ContactController.searchContacts(nameOrMobile);
                if (index != -1) {
                    Contact contact = ContactDBConnection.getInstance().getContactList().get(index);
                    txtId.setText(contact.getId());
                    txtName.setText(contact.getName());
                    txtMobile.setText(contact.getMobile());
                    txtCompany.setText(contact.getCompany());
                    txtSalary.setText(contact.getSalary() + "");
                    txtBirthday.setText(contact.getBirthday());
                } else {
                    txtId.setText("");
                    txtName.setText("");
                    txtMobile.setText("");
                    txtCompany.setText("");
                    txtSalary.setText("");
                    txtBirthday.setText("");
                }

            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", 1, 20));

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("", 1, 20));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ContactController.deleteContact(index);
            }
        });

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnCancel);

        add("South", buttonPanel);

        JPanel labelPanel = new JPanel(new GridLayout(6, 1, 3, 3));
        JLabel lblId = new JLabel("Contact ID");
        lblId.setFont(new Font("", 1, 20));
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("", 1, 20));
        labelPanel.add(lblName);

        JLabel lblMobile = new JLabel("Conatct Number");
        lblMobile.setFont(new Font("", 1, 20));
        labelPanel.add(lblMobile);

        JLabel lblCompany = new JLabel("Company");
        lblCompany.setFont(new Font("", 1, 20));
        labelPanel.add(lblCompany);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", 1, 20));
        labelPanel.add(lblSalary);

        JLabel lblbirthday = new JLabel("Birthday");
        lblbirthday.setFont(new Font("", 1, 20));
        labelPanel.add(lblbirthday);

        add("West", labelPanel);

        JPanel textPanel = new JPanel(new GridLayout(6, 1, 3, 3));

        txtId = new JLabel();
        txtId.setFont(new Font("", 1, 20));
        JPanel idTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTextPanel.add(txtId);
        textPanel.add(idTextPanel);

        txtName = new JLabel();
        txtName.setFont(new Font("", 1, 20));
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtMobile = new JLabel();
        txtMobile.setFont(new Font("", 1, 20));
        JPanel mobileTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mobileTextPanel.add(txtMobile);
        textPanel.add(mobileTextPanel);

        txtCompany = new JLabel();
        txtCompany.setFont(new Font("", 1, 20));
        JPanel companyTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        companyTextPanel.add(txtCompany);
        textPanel.add(companyTextPanel);

        txtSalary = new JLabel();
        txtSalary.setFont(new Font("", 1, 20));
        JPanel salaryTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirthday = new JLabel();
        txtBirthday.setFont(new Font("", 1, 20));
        JPanel birthdayTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthdayTextPanel.add(txtBirthday);
        textPanel.add(birthdayTextPanel);

        add("East", textPanel);

        // pack();

    }
}
