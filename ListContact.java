import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListContact extends JFrame {

    public static final ArrayList<Contact> customerList = new ArrayList<>();

    private JButton listByName;
    private JButton listBySalary;
    private JButton listByBirthday;
    private JButton btnExit;

    private AddContactForm addContactForm;
    private UpdateContactForm updateContactForm;
    private DeleteContactForm deleteContactForm;
    private SearchContactForm searchContactForm;
    private ListContact listContact;
    private ViewContactForm viewByName;
    private ViewContactForm viewBySalary;
    private ViewContactForm viewByBirthday;

    public ListContact() {
        // Set JFrame properties
        // setTitle("Main Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Create right panel with GridBagLayout and set custom background color
        JPanel right = new JPanel(new GridBagLayout());
        right.setBackground(new Color(153, 205, 253));
        right.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Add a label to the right panel
        JLabel home = new JLabel("CONTACT LIST");
        home.setHorizontalAlignment(JLabel.CENTER);
        home.setFont(new Font("", Font.BOLD, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        right.add(home, gbc);

        // Add a horizontal line (separator) after the "Home Page" label
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        right.add(separator, gbc);

        // Add buttons to the right panel
        listByName = new JButton("List by Name");
        listByName.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        listByName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (viewByName == null) {
                    viewByName = new ViewContactForm("LIST CONTACTS BY NAME", 0);
                }
                viewByName.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        right.add(listByName, gbc);

        listBySalary = new JButton("List by Salary");
        listBySalary.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        listBySalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (viewBySalary == null) {
                    viewBySalary = new ViewContactForm("LIST CONTACTS BY SALARY", 1);
                }
                viewBySalary.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        right.add(listBySalary, gbc);

        listByBirthday = new JButton("List by Birthday");
        listByBirthday.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        listByBirthday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (viewByBirthday == null) {
                    viewByBirthday = new ViewContactForm("LIST CONTACTS BY Birthday", 2);
                }
                viewByBirthday.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        right.add(listByBirthday, gbc);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Align the button to the right
        right.add(btnExit, gbc);

        // Add the right panel to the frame
        add(right, BorderLayout.CENTER);

        // Pack the frame to fit the components
        pack();
    }
}
