import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame {
    private JButton btnAddCustomer;
    private JButton btnCancel;
    private String tempId = ContactDBConnection.getInstance().getContactList().generateID();
    private JTextField txtName;
    private JTextField txtMobile;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthday;

    AddContactForm() {
        setSize(400, 300);
        // setTitle("Add Customer Form");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel title = new JPanel();
        JPanel n = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("Add Contact");
        title.setBackground(new Color(153, 205, 253));
        n.setBackground(new Color(153, 205, 253));
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        title.add(titleLabel);
        n.add(title);

        JPanel idcontainer = new JPanel(new BorderLayout());
        JLabel idlabel = new JLabel(tempId);
        idlabel.setFont(new Font("", Font.BOLD, 20));
        idlabel.setHorizontalAlignment(JLabel.LEFT);
        idcontainer.add(idlabel);
        n.add(idcontainer);
        add("North", n);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("", 1, 20));
        btnAddCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // String id = txtId.getText();
                tempId = ContactDBConnection.getInstance().getContactList().generateID();
                String id = tempId;
                String name = txtName.getText();
                String mobile = txtMobile.getText();
                String Company = txtCompany.getText();
                double salary = Double.parseDouble(txtSalary.getText());
                String birthday = txtBirthday.getText();
                Contact contact = new Contact(id, name, mobile, Company, salary, birthday);
                // ContactMainForm.customerList.add(contact);
                ContactController.addContact(contact);
                idlabel.setText(ContactDBConnection.getInstance().getContactList().generateID());

            }
        });

        buttonPanel.add(btnAddCustomer);

        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", 1, 20));
        buttonPanel.add(btnCancel);

        // btnCancel.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent evt) {
        // System.out.println("hi");
        // }
        // });

        add("South", buttonPanel);

        JPanel labelPanel = new JPanel(new GridLayout(5, 1, 3, 3));
        JLabel lblId = new JLabel("Name");
        lblId.setFont(new Font("", 1, 20));
        labelPanel.add(lblId);

        JLabel lblName = new JLabel("Conatct Number");
        lblName.setFont(new Font("", 1, 20));
        labelPanel.add(lblName);

        JLabel lblAddress = new JLabel("Company");
        lblAddress.setFont(new Font("", 1, 20));
        labelPanel.add(lblAddress);

        JLabel lblSalary = new JLabel("Salary");
        lblSalary.setFont(new Font("", 1, 20));
        labelPanel.add(lblSalary);

        JLabel lblbirthday = new JLabel("Birthday");
        lblbirthday.setFont(new Font("", 1, 20));
        labelPanel.add(lblbirthday);

        add("West", labelPanel);

        JPanel textPanel = new JPanel(new GridLayout(5, 1, 3, 3));

        txtName = new JTextField(15);
        txtName.setFont(new Font("", 1, 20));
        JPanel nameTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameTextPanel.add(txtName);
        textPanel.add(nameTextPanel);

        txtMobile = new JTextField(15);
        txtMobile.setFont(new Font("", 1, 20));
        JPanel mobileTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mobileTextPanel.add(txtMobile);
        textPanel.add(mobileTextPanel);

        txtCompany = new JTextField(15);
        txtCompany.setFont(new Font("", 1, 20));
        JPanel companyTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        companyTextPanel.add(txtCompany);
        textPanel.add(companyTextPanel);

        txtSalary = new JTextField(10);
        txtSalary.setFont(new Font("", 1, 20));
        JPanel salaryTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        salaryTextPanel.add(txtSalary);
        textPanel.add(salaryTextPanel);

        txtBirthday = new JTextField(10);
        txtBirthday.setFont(new Font("", 1, 20));
        JPanel birthdayTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        birthdayTextPanel.add(txtBirthday);
        textPanel.add(birthdayTextPanel);

        add("East", textPanel);

        pack();

    }
}
