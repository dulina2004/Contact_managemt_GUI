import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactMainForm extends JFrame {

    public static final ArrayList<Contact> customerList = new ArrayList<>();

    private JButton btnAddContact;
    private JButton btnUpdateContact;
    private JButton btnSearchContact;
    private JButton btnDeleteContact;
    private JButton btnViewContact;
    private JButton btnExit;

    private AddContactForm addContactForm;
    private UpdateContactForm updateContactForm;
    private DeleteContactForm deleteContactForm;
    private SearchContactForm searchContactForm;
    private ListContact listContact;
    private ViewContactForm viewContactForm;

    public ContactMainForm() {
        // Set JFrame properties
        // setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Set window icon
        ImageIcon image = new ImageIcon("icon.png");
        setIconImage(image.getImage());

        // Load the main image and resize it
        ImageIcon main_img = new ImageIcon("i.jpg");
        Image scaledImage = main_img.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);

        // Create left panel and its subpanels
        JPanel left = new JPanel(new BorderLayout());
        JPanel left_title = new JPanel(new GridLayout(2, 1));

        // Create and configure labels
        JLabel ifriend = new JLabel("iFRIEND");
        ifriend.setHorizontalAlignment(JLabel.CENTER);
        ifriend.setFont(new Font("", Font.BOLD, 30));

        JLabel manager = new JLabel("Contact Manager");
        manager.setFont(new Font("", Font.BOLD, 30));
        manager.setHorizontalAlignment(JLabel.CENTER);

        // Create a container panel for the image
        JPanel imgPanel = new JPanel();
        JLabel img_container = new JLabel();
        img_container.setIcon(resizedImageIcon); // Set the resized image
        imgPanel.add(img_container);

        // Add components to the panels
        left_title.add(ifriend);
        left_title.add(manager);
        left.add(left_title, BorderLayout.NORTH);
        left.add(imgPanel, BorderLayout.CENTER);

        // Add the left panel to the frame
        add(left, BorderLayout.WEST);

        // Create right panel with GridBagLayout and set custom background color
        JPanel right = new JPanel(new GridBagLayout());
        right.setBackground(new Color(153, 205, 253));
        right.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Add a label to the right panel
        JLabel home = new JLabel("Home Page");
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
        btnAddContact = new JButton("Add New Contact");
        btnAddContact.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnAddContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (addContactForm == null) {
                    addContactForm = new AddContactForm();
                }
                addContactForm.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        right.add(btnAddContact, gbc);

        btnUpdateContact = new JButton("Update Contact");
        btnUpdateContact.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnUpdateContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (updateContactForm == null) {
                    updateContactForm = new UpdateContactForm();
                }
                updateContactForm.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        right.add(btnUpdateContact, gbc);

        btnSearchContact = new JButton("Search Contact");
        btnSearchContact.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnSearchContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (searchContactForm == null) {
                    searchContactForm = new SearchContactForm();
                }
                searchContactForm.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        right.add(btnSearchContact, gbc);

        btnDeleteContact = new JButton("Delete Contact");
        btnDeleteContact.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnDeleteContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (deleteContactForm == null) {
                    deleteContactForm = new DeleteContactForm();
                }
                deleteContactForm.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        right.add(btnDeleteContact, gbc);

        btnViewContact = new JButton("View Contact Form");
        btnViewContact.setFont(new Font("", Font.ROMAN_BASELINE, 15));
        btnViewContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (listContact == null) {
                    listContact = new ListContact();
                }
                listContact.setVisible(true);

            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        right.add(btnViewContact, gbc);

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
