import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortedListGUI {
    private SortedList sortedList;
    private JTextArea displayArea;
    private JTextField inputField;
    private JTextField searchField;

    public SortedListGUI() {
        sortedList = new SortedList();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Sorted List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel inputLabel = new JLabel("Add String:");
        inputField = new JTextField(15);
        JButton addButton = new JButton("Add");
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        JPanel searchPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Search String:");
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(searchPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (!input.isEmpty()) {
                    sortedList.add(input);
                    displayArea.append("Added: " + input + "\n");
                    displayArea.append("List: " + sortedList.getListAsString() + "\n");
                    inputField.setText("");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = searchField.getText().trim();
                if (!search.isEmpty()) {
                    String result = sortedList.search(search);
                    displayArea.append("Search: " + search + "\n");
                    displayArea.append(result + "\n");
                    searchField.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SortedListGUI::new);
    }
}