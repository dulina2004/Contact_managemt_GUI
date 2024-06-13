import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateContactForm extends JFrame {
    private int index;
    private JButton btnCancel;
    private JButton btnSearch;
    private JButton btnUpdate;
    private JTextField txtsearch;
    private JLabel txtId;
    private JTextField txtName;
    private JTextField txtMobile;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthday;
    private String tempMobile = "";

    UpdateContactForm() {
        setSize(600, 500);
        // setTitle("Add Customer Form");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel title = new JPanel();
        JPanel n = new JPanel(new GridLayout(2, 1));
        JLabel titleLabel = new JLabel("UPDATE CONTACT");
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
                index = ContactController.searchContacts(nameOrMobile);
                if (index != -1) {
                    Contact contact = ContactDBConnection.getInstance().getContactList().get(index);
                    txtId.setText(contact.getId());
                    txtName.setText(contact.getName());
                    txtMobile.setText(contact.getMobile());
                    txtCompany.setText(contact.getCompany());
                    txtSalary.setText(contact.getSalary() + "");
                    txtBirthday.setText(contact.getBirthday());

                    try {
                        tempMobile = contact.getMobile();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
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

        btnCancel = new JButton("Back To HomePage");
        btnCancel.setFont(new Font("", 1, 20));

        btnUpdate = new JButton("Update Customer");
        btnUpdate.setFont(new Font("", 1, 20));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // String id = txtId.getText();
                String name = txtName.getText();
                String mobile = txtMobile.getText();
                String Company = txtCompany.getText();
                double salary = Double.parseDouble(txtSalary.getText());
                String birthday = txtBirthday.getText();

                if (mobile.equals(tempMobile)) {
                    if (!ContactController.isValidMobile(mobile, index)) {
                        int option = JOptionPane.showConfirmDialog(null,
                                "Invalid mobile Number... Do you want to input number again ?");
                        if (option == JOptionPane.YES_OPTION) {
                            txtMobile.setText("");
                            txtMobile.requestFocus();
                        } else if (option == JOptionPane.NO_OPTION) {
                            txtMobile.setText("");
                            txtName.setText("");
                            txtCompany.setText("");
                            txtSalary.setText("");
                            txtBirthday.setText("");
                            dispose();
                        }
                        return;
                    }
                } else {
                    if (!ContactController.isValidMobile(mobile)) {
                        int option = JOptionPane.showConfirmDialog(null,
                                "Invalid mobile Number... Do you want to input number again ?");
                        if (option == JOptionPane.YES_OPTION) {
                            txtMobile.setText("");
                            txtMobile.requestFocus();
                        } else if (option == JOptionPane.NO_OPTION) {
                            txtMobile.setText("");
                            txtName.setText("");
                            txtCompany.setText("");
                            txtSalary.setText("");
                            txtBirthday.setText("");
                            dispose();
                        }
                        return;
                    }
                }

                if (!ContactController.isValidSalary(salary)) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Invalid salary... Do you want to input salary again ?");
                    if (option == JOptionPane.YES_OPTION) {
                        txtSalary.setText("");
                        txtSalary.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtMobile.setText("");
                        txtName.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthday.setText("");
                        dispose();
                    }
                    return;
                }

                if (!ContactController.isValidBirthday(birthday)) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "Invalid birthday... Do you want to input birthday again ?");
                    if (option == JOptionPane.YES_OPTION) {
                        txtBirthday.setText("");
                        txtBirthday.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtMobile.setText("");
                        txtName.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthday.setText("");
                        dispose();
                    }
                    return;
                }

                // ContactMainForm.customerList.add(contact);
                ContactController.updateContacts(name, mobile, Company, salary, birthday, index);
                JOptionPane.showMessageDialog(null, "Contact updated successfully", "Success", JOptionPane.NO_OPTION);
                txtMobile.setText("");
                txtName.setText("");
                txtCompany.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                txtId.setText("");
                txtsearch.setText("");

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtName.setText("");
                txtMobile.setText("");
                txtCompany.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                txtsearch.setText("");
                dispose();
            }
        });

        buttonPanel.add(btnUpdate);
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

        // pack();

    }
}
