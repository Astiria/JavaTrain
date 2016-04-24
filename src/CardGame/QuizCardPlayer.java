package CardGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;



public class QuizCardPlayer {
	
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	public void goPlayer(){
		
		frame = new JFrame("Quiz Card Player");
		//create gui
				frame = new JFrame("Quiz Game");
				JPanel mainPanel = new JPanel();
				Font bigFont = new Font("Times New Roman", Font.BOLD, 20);
				
				//question
				
				display = new JTextArea(10,20);
				display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
				display.setLineWrap(true); //перенос строк
				display.setEditable(false);
				display.setFont(bigFont);
				
				JScrollPane quesScroller = new JScrollPane(display);
				quesScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				quesScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
						
				JButton nextButton = new JButton("Show Question");
					
				mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
				mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
				mainPanel.add(quesScroller);
				mainPanel.add(nextButton);
				nextButton.addActionListener(new NextCardListener());
				
				
				//main bar
				JMenuBar menuBar = new JMenuBar();
				JMenu fileMenu = new JMenu("File");
				
				JMenuItem loadMenuItem = new JMenuItem("Load card set");
				loadMenuItem.addActionListener(new OpenMenuListener());
				
				
				fileMenu.add(loadMenuItem);
				menuBar.add(fileMenu);
						
				frame.setJMenuBar(menuBar);
				frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
				frame.setSize(640, 500);;
				frame.setVisible(true);
	}
		public class OpenMenuListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				JFileChooser fileOpen = new JFileChooser();
				fileOpen.showOpenDialog(frame);
				loadFile(fileOpen.getSelectedFile());
			}
		}
			
		private void loadFile(File file){
				cardList = new ArrayList<QuizCard>();
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line = null;
					while((line=reader.readLine())!=null){
						makeCard(line);
					}
					reader.close();
					
				} catch (Exception e) {
					System.out.println("not read card");
					e.printStackTrace();
				}
				showNextCard();
				
			}
		public class NextCardListener implements ActionListener{
			public void actionPerformed(ActionEvent ev){
				if(isShowAnswer){
					display.setText(currentCard.getAnswer());
					nextButton.setText("Next Card");
					isShowAnswer = false;
				}
				else{
					if(currentCardIndex<cardList.size()){
						showNextCard();
					}
					else {
						display.setText("That was last card");
						nextButton.setEnabled(false);
					}
				}
			}
		}
		
		private void showNextCard() {
				currentCard = cardList.get(currentCardIndex);
				currentCardIndex++;
				display.setText(currentCard.getQuestion());
				nextButton.setText("Show answer");
				isShowAnswer = true;
					
				}
	
			private void makeCard(String lineToParse){
				String[] result = lineToParse.split("/");
				QuizCard card = new QuizCard(result[0], result[1]);
				cardList.add(card);
				System.out.println("Made a card");
			}

			
}


