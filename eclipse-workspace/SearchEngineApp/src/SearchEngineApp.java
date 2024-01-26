import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEngineApp {
	
	public class SearchEngineApp extends JFrame {

	    private AutoCompleteTextField searchField;
	    private JTextArea suggestionArea;
	    private Trie trie;

	    public SearchEngineApp(List<String> words) {
	        // Initialize the frame
	        setTitle("Search Engine");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create components
	        trie = new Trie(words);

	        searchField = new AutoCompleteTextField(trie);
	        setupAutoComplete(searchField);

	        JButton searchButton = new JButton("Search");
	        searchButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String query = searchField.getText();
	                // Perform search operation with the entered query
	                suggestionArea.setText("Searching for: " + query);
	            }
	        });

	        suggestionArea = new JTextArea();
	        suggestionArea.setEditable(false);

	        // Create layout
	        setLayout(new BorderLayout());

	        // Create a panel for the search bar and button
	        JPanel searchPanel = new JPanel(new BorderLayout());
	        searchPanel.add(searchField, BorderLayout.CENTER);
	        searchPanel.add(searchButton, BorderLayout.EAST);

	        // Create a panel for the search suggestions
	        JPanel suggestionPanel = new JPanel(new BorderLayout());
	        suggestionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        suggestionPanel.add(new JScrollPane(suggestionArea), BorderLayout.CENTER);

	        // Combine the search and suggestion panels in a split pane
	        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, searchPanel, suggestionPanel);
	        splitPane.setDividerLocation(50); // Set the initial position of the divider

	        // Add the split pane to the frame
	        add(splitPane, BorderLayout.CENTER);

	        // Set frame visibility
	        setVisible(true);
	    }

	    private void setupAutoComplete(JTextField textField) {
	        // This method can be used to set up any additional autocomplete configurations
	        // if needed.
	    }

	    public static void main(String[] args) {
	        List<String> words = List.of("hello", "dog", "hell", "cat", "a", "hel", "help", "helps", "helping");

	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new SearchEngineApp(words);
	            }
	        });
	    }
	}

}
