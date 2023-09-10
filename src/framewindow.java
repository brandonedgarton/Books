import java.awt.BorderLayout;
import java.awt.GridLayout; // Import GridLayout
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class framewindow implements ActionListener {
	JButton leftButton;
	JButton rightButton;
	static JLabel bookInfo;
	static JLabel topInfo;
	static int bookID = 1;
	static JLabel imgLabel;
	JMenuItem topten;
	JMenuItem mntmNewMenuItem_1;
	JMenuItem mntmNewMenuItem;
	JButton submitButton;
	JFrame searchFrame;
	JTextField textField;
	JRadioButton isbnButton;
	JRadioButton bookidButton;
	ButtonGroup group;
	JPanel searchpanel;
	static boolean linked = false;
    framewindow() throws IOException {

        JFrame frame = new JFrame();
        frame.setSize(600, 500);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        mntmNewMenuItem = new JMenuItem("Search");
        mntmNewMenuItem.addActionListener(this);
        mnNewMenu.add(mntmNewMenuItem);

        mntmNewMenuItem_1 = new JMenuItem("Swap Views");
        mntmNewMenuItem_1.addActionListener(this);
        mnNewMenu.add(mntmNewMenuItem_1);
        

        topten = new JMenuItem("Top Ten");
        topten.addActionListener(this);
        mnNewMenu.add(topten);

        JPanel bookOverView = new JPanel();
        frame.getContentPane().add(bookOverView, BorderLayout.NORTH);
        topInfo = new JLabel();
        topInfo.setVisible(true);
        topInfo.setHorizontalAlignment(JLabel.CENTER);
        bookOverView.add(topInfo);
        
        
        
        JPanel bookIMG = new JPanel();
        frame.getContentPane().add(bookIMG, BorderLayout.CENTER); //picture
        imgLabel = new JLabel();
        imgLabel.setVisible(true);
        bookIMG.add(imgLabel);
        
        
        

        JPanel southPanel = new JPanel(new GridLayout(1, 3)); //using gridlayout for this one
        leftButton = new JButton();
        leftButton.setText("<-");
        leftButton.setFocusable(false);
        leftButton.addActionListener(this);
        rightButton = new JButton();
        rightButton.setText("->");
        rightButton.setFocusable(false);
        rightButton.addActionListener(this);
        southPanel.add(leftButton);
        bookInfo = new JLabel();
        bookInfo.setVisible(true);
        bookInfo.setHorizontalAlignment(JLabel.CENTER);
        southPanel.add(bookInfo);
        southPanel.add(rightButton);
        

        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
		searchFrame = new JFrame("Text Box Example");
		searchFrame.setSize(300, 150);
		searchpanel = new JPanel();
    }


    public static void populateFields(int bookidnew) throws IOException {
    	bookID = bookidnew;
    	Book currBook = csv.getBooks(bookID);
    	int booknum = currBook.getBookid();
    	String authors = currBook.getAuthor();
    	String isbn = currBook.getIsbn();
    	int year = currBook.getYear();
    	String title = currBook.getTitle();
    	String lang = currBook.getLanguage();
    	double rating = currBook.getRating();
    	int totalRating = currBook.getTotalRating();
    	String img = currBook.getImgurl();
    	String topText = "<html>Title: " + title + "<br>Author/s: " + authors + "<br>Rating: " + rating + "<br>Total Ratings: " + totalRating + "<br>Year: " + year + "<br>Language: " + lang + "</html>";
    	String bottomText = "<html>ISBN: " + isbn + "<br>GoodReads: " + booknum + "</html>";
    	bookInfo.setText(bottomText);
    	topInfo.setText(topText);
    	
    	 try {
    
    	        URL newImageUrl = new URL(img);

    	    
    	        Image originalImage = ImageIO.read(newImageUrl);

    	    
    	        int desiredWidth = 150;
    	        int desiredHeight = 200;

 
    	        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

    	  
    	        ImageIcon newIcon = new ImageIcon(resizedImage);

    	     
    	        imgLabel.setIcon(newIcon);
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rightButton) {
            if (bookID < 9999) {
                bookID += 1;
                try {
                    populateFields(bookID);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == leftButton) {
            if (bookID > 0) {
                bookID -= 1;
                try {
                    populateFields(bookID);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == mntmNewMenuItem_1) {
            System.out.println("k");
        } else if (e.getSource() == mntmNewMenuItem) {
          
        	searchpanel.removeAll();
            searchpanel.add(new JLabel("Enter ISBN/BookID: "));
            searchpanel.add(textField);
            searchpanel.add(submitButton);
            isbnButton = new JRadioButton("ISBN");
            isbnButton.setActionCommand("ISBN");
            bookidButton = new JRadioButton("Book ID");
            bookidButton.setActionCommand("BookID");
            group = new ButtonGroup();
            group.add(isbnButton);
            group.add(bookidButton);
            searchpanel.add(bookidButton);
            searchpanel.add(isbnButton);
            searchFrame.getContentPane().add(searchpanel);

            searchFrame.pack();

            searchFrame.setVisible(true);
        } else if (e.getSource() == submitButton) {
            String userInput = textField.getText();
            System.out.println(userInput);

            try {
                String selectedOption = group.getSelection().getActionCommand();
                if (selectedOption != null) {
                    System.out.println(selectedOption);
                    if ("BookID".equals(selectedOption)) {
                        int search = Integer.parseInt(userInput);
                        try {
                            SearchandSort.searchbyID(search);
                            searchFrame.dispose();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else if ("ISBN".equals(selectedOption)) {
                        int index = SearchandSort.searchbyISBN(userInput);
                        if (index != -1) {
                            populateFields(index);
                      
                            searchFrame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(searchFrame, "ISBN not found",
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(searchFrame, "Enter a valid input",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }  else if (e.getSource() == topten) {
        	ArrayList<Integer> top = SearchandSort.top10();
        	System.out.println(top);
        	String topBooks = "<html>";
        	for (int i=0; i <= 9; i++) {
        	int currnum = top.get(i);
       
        	System.out.println(currnum);
        	Book currBook = csv.getBooks(currnum);
        	String authors = currBook.getAuthor();
        	String isbn = currBook.getIsbn();   
        	String title = currBook.getTitle();
        	int booknum = currBook.getBooknum();
        	double rating = currBook.getRating();
        	topBooks += i+1 + "         " +  booknum + ".<br>Title: " + title + "<br>Author/s: " + authors + "<br>Rating: " + rating + "<br>ISBN: " + isbn + "<br>"; 
      
        	
        }
        	topBooks += "</html>";

            JFrame topBooksFrame = new JFrame("Top 10 Books");
            JLabel topBooksLabel = new JLabel(topBooks);

      
            topBooksFrame.getContentPane().add(topBooksLabel);
            topBooksFrame.setSize(400, 1100);
            topBooksFrame.setVisible(true);
        

        // Make the main frame visible
        }
        
    }
}