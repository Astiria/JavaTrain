package CardGame;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.activation.MailcapCommandMap;
import javax.swing.*;

public class QuizCardBuilder {
	
	
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardlist;
	private JFrame frame;
	
	
	
	public void goBuilder(){
		
		//create gui
		frame = new JFrame("Quiz Game");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("Times New Roman", Font.BOLD, 20);
		
		//question
		JLabel qLabel = new JLabel("Question: ");
		qLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
		question = new JTextArea(6,20);
		question.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		question.setLineWrap(true); //перенос строк
		question.setWrapStyleWord(true); // перенос по словам
		question.setFont(bigFont);
		
		JScrollPane quesScroller = new JScrollPane(question);
		quesScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		quesScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel answLebel = new JLabel("Answer: ");
		answLebel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
		answer = new JTextArea(6,20);
		answer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true); // перенос по словам
		answer.setFont(bigFont);
		
		JScrollPane answScroller = new JScrollPane(answer);
		answScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		answScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton nextButton = new JButton("Next card");
			
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		mainPanel.add(qLabel);
		mainPanel.add(quesScroller);
		mainPanel.add(answLebel);
		mainPanel.add(answScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NewCardListener());
		
		
		//main bar
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newMenu = new JMenuItem("New");
		newMenu.addActionListener(new NewCardListener());
		JMenuItem saweMenu = new JMenuItem("Save");
		saweMenu.addActionListener(new SaveCardListener());
		
		fileMenu.add(newMenu);
		fileMenu.add(saweMenu);
		menuBar.add(fileMenu);
		
		cardlist = new ArrayList<QuizCard>();
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		frame.setSize(500, 600);;
		frame.setVisible(true);
		
	}
	
	private class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardlist.add(card);
			clearCard();
			}

		
	}
	
	private class SaveCardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardlist.add(card);
			
			//save card
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
			
		}
	}
	private class NewCardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardlist.clear();
			clearCard();
			
		}
	}
	
	private void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}
	
//вызываетс€ обработчиком собитий класса SaveMenuListener
	private void saveFile(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for(QuizCard card : cardlist){
				writer.write(card.getQuestion()+ "/" );
				writer.write(card.getAnswer()+ "\n" );
			}
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
