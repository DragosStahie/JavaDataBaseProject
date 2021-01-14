package baza_date_barci;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class BarciView extends JFrame{

    private static JTextField 	b_userInputTf = new JTextField();
    private static JPanel	    input 		  = new JPanel();
    private static JButton 		backButton    = new JButton("BACK");
    private static JButton 		goButton      = new JButton("GO");
    private static JButton		interog_a 	  = new JButton("Interogare a");
    private static JButton		interog_b 	  = new JButton("Interogare b");
    private static JButton		interog_3 	  = new JButton("Interogari 3");
    private static JButton		interog_4	  = new JButton("Interogari 4");
    private static JButton		interog_5	  = new JButton("Interogari 5");
    private static JButton		interog_6	  = new JButton("Interogari 6");
    

    private static WrapperPanel content 		 	   = new WrapperPanel();
    private static JLabel	    padd				   = new JLabel();
    
    private static JTextArea 	results = new JTextArea(15, 38);
    private static JScrollPane  scroll;
    
    private static JLabel cerintaA  = new JLabel ("Lipseste cerinta");
    private static JLabel cerintaB  = new JLabel("Lipseste cerinta");
    private static JLabel titlu		= new JLabel("Lipseste cerinta");
    private static JLabel titlu3	= new JLabel("Lipseste cerinta");
    private static JLabel titlu4	= new JLabel("Lipseste cerinta");
    private static JLabel titlu5	= new JLabel("Lipseste cerinta");
    private static JLabel titlu6	= new JLabel("Lipseste cerinta");
    private static JLabel inputText = new JLabel("Input");
    private static JLabel errorMsg  = new JLabel();
    private static JLabel padd2 	= new JLabel();
    
    private static Image  bg;

    
    private static ViewState status 	= ViewState.MENIU_INTEROGARI;
    private static ViewState backStatus = ViewState.MENIU_INTEROGARI;

    
	
	BarciView() {
		
		try {
			
			bg = ImageIO.read(new File("barci.jpg"));
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
        //image.setPreferredSize(new Dimension(800, 600));
        content.repaint();
				
        this.setContentPane(content);
        content.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        
        //... Layout the components.      
        //content.setLayout(new FlowLayout());
        backButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        backButton.setPreferredSize(new Dimension(200, 50));

        goButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        goButton.setPreferredSize(new Dimension(200, 50));
        
        //input.setPreferredSize(new Dimension(600, 450));
        //input.setLayout(new FlowLayout());
        inputText.setFont(new Font("Helvetica",Font.BOLD, 20));
        inputText.setPreferredSize(new Dimension(600, 200));
        //inputText.setPreferredSize(new Dimension(200, 50));
        b_userInputTf.setPreferredSize(new Dimension(600, 50));
        b_userInputTf.setFont(new Font("Helvetica",Font.BOLD, 15));
        errorMsg.setFont(new Font("Helvetica",Font.BOLD, 20));
        errorMsg.setBorder(new EmptyBorder(40, 120, 40, 20));
        errorMsg.setForeground(Color.red);
        errorMsg.setPreferredSize(new Dimension(600, 80));
        content.add(inputText);
        content.add(b_userInputTf);
        inputText.setVisible(false);
        b_userInputTf.setVisible(false);
        padd2.setPreferredSize(new Dimension(600, 30));
        content.add(padd2);
        content.add(goButton);
        content.add(errorMsg);
        //content.add(input);
        content.add(results);
        padd.setPreferredSize(new Dimension(600, 80));
        content.add(padd);
        padd.setVisible(false);
        backButton.setVisible(false);
        input.setVisible(false);
        results.setVisible(false);
        scroll = new JScrollPane(results);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setVisible(false);
        
        goButton.setVisible(false);
        padd2.setVisible(false);
        errorMsg.setVisible(false);
        
        content.add(scroll);
        
        interog_a.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_a.setPreferredSize(new Dimension(200, 50));
        interog_b.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_b.setPreferredSize(new Dimension(200, 50));

        content.add(interog_a);
        //cerintaA = new JLabel("");
        cerintaA.setFont(new Font("Helvetica", Font.BOLD, 16));
        cerintaA.setBorder(new EmptyBorder(0, 50, 0, 0));
        cerintaA.setPreferredSize(new Dimension (380, 200));
        content.add(cerintaA);
        
        content.add(interog_b);
        //cerintaB = new JLabel("");
        cerintaB.setFont(new Font("Helvetica", Font.BOLD, 16));
        cerintaB.setBorder(new EmptyBorder(0, 50, 0, 0));
        cerintaB.setPreferredSize(new Dimension (380, 200));
        content.add(cerintaB);
        
        interog_a.setVisible(false);
        interog_b.setVisible(false);
        cerintaA.setVisible(false);
        cerintaB.setVisible(false);
        //content.add(buttonPanel_Subpuncte);
        //buttonPanel_Subpuncte.setPreferredSize(new Dimension(600, 450));
        //buttonPanel_Subpuncte.setBorder(new EmptyBorder(20, 0, 20, 0));
        //buttonPanel_Subpuncte.setVisible(false);
        
        //buttonPanel_Interogari.setLayout(new GridLayout(0, 1));
        titlu.setText("Selectati interogarea dorita");
        titlu.setFont(new Font("Helvetica", Font.BOLD, 30));
        
        interog_3.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_3.setPreferredSize(new Dimension(200, 50));
        interog_4.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_4.setPreferredSize(new Dimension(200, 50));
        interog_5.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_5.setPreferredSize(new Dimension(200, 50));
        interog_6.setFont(new Font("Helvetica", Font.BOLD, 20));
        interog_6.setPreferredSize(new Dimension(200, 50));
                
        titlu.setBorder(new EmptyBorder(25, 150, 25, 150));
        content.add(titlu);
        content.add(interog_3);
        titlu3.setText("<html>Denumirea clasei si tara\nNumele navelor si anul lansarii</html>");
        titlu3.setFont(new Font("Helvetica", Font.BOLD, 16));
        titlu3.setBorder(new EmptyBorder(0, 50, 0, 90));
        titlu3.setPreferredSize(new Dimension (380, 100));
        content.add(titlu3);
		/*
		 * titlu = new JLabel("Numele navelor si anul lansarii"); titlu.setFont(new
		 * Font("Helvetica", Font.BOLD, 16)); titlu.setBorder(new EmptyBorder(0, 10, 10,
		 * 10)); buttonPanel_Interogari.add(titlu);
		 */
        
        content.add(interog_4);
        titlu4.setText("<html>Nume, deplasament si numar arme\nPerechi de clase</html>");
        titlu4.setFont(new Font("Helvetica", Font.BOLD, 16));
        titlu4.setBorder(new EmptyBorder(0, 50, 0, 30));
        titlu4.setPreferredSize(new Dimension (380, 100));
        content.add(titlu4);
		/*
		 * titlu = new JLabel("Perechi de clase"); titlu.setFont(new Font("Helvetica",
		 * Font.BOLD, 16)); titlu.setBorder(new EmptyBorder(0, 10, 10, 10));
		 * buttonPanel_Interogari.add(titlu);
		 */
        
        content.add(interog_5);
        titlu5.setText("<html>Clasele cu cele mai putine arme\nDetaliile bataliilor</html>");
        titlu5.setFont(new Font("Helvetica", Font.BOLD, 16));
        titlu5.setBorder(new EmptyBorder(0, 50, 0, 40));
        titlu5.setPreferredSize(new Dimension (380, 100));
        content.add(titlu5);
		/*
		 * titlu = new JLabel("Detaliile bataliilor"); titlu.setFont(new
		 * Font("Helvetica", Font.BOLD, 16)); titlu.setBorder(new EmptyBorder(0, 10, 10,
		 * 10)); buttonPanel_Interogari.add(titlu);
		 */
        
        content.add(interog_6);
        titlu6.setText("<html> Clasa cu maximul dimensiunii tunurilor\nNumarul navelor pentru fiecare rezultat</html>");
        titlu6.setFont(new Font("Helvetica", Font.BOLD, 16));
        titlu6.setBorder(new EmptyBorder(0, 50, 0, 10));
        titlu6.setPreferredSize(new Dimension (380, 100));
        content.add(titlu6);
        
        titlu.setVisible(true);
        
        interog_3.setVisible(true);
        titlu3.setVisible(true);
        
        interog_4.setVisible(true);
        titlu4.setVisible(true);
        
        interog_5.setVisible(true);
        titlu5.setVisible(true);
        
        interog_6.setVisible(true);
        titlu6.setVisible(true);

        results.setFont(new Font("Helvetica",Font.BOLD, 20));
        
        content.add(backButton);
        
        
        cerintaA.setForeground(new Color(251, 105, 44));
        cerintaB.setForeground(new Color(251, 105, 44));
        titlu.setForeground(new Color(251, 105, 44));
        titlu3.setForeground(new Color(251, 105, 44));
        titlu4.setForeground(new Color(251, 105, 44));
        titlu5.setForeground(new Color(251, 105, 44));
        titlu6.setForeground(new Color(251, 105, 44));
        inputText.setForeground(new Color(251, 105, 44));

        results.setEditable(false);

        
        //... finalize layout
        this.pack();
        
        this.setTitle("Barci Test");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	        
	}
	
	static class WrapperPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.drawImage(bg, 0, 0, 800, 600, this);
			g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(0, 0, 800, 600);

		}
	}
	
    String getUserInput() {
        return b_userInputTf.getText();
    }
    
    void addBackListener(ActionListener mal) {
        backButton.addActionListener(mal);
    }
    
    void addGoListener(ActionListener mal) {
        goButton.addActionListener(mal);
    }
    
    void addInterogare_3Listener(ActionListener mal) {
        interog_3.addActionListener(mal);
    }

    void addInterogare_4Listener(ActionListener mal) {
        interog_4.addActionListener(mal);
    }
    
    void addInterogare_5Listener(ActionListener mal) {
        interog_5.addActionListener(mal);
    }
    
    void addInterogare_6Listener(ActionListener mal) {
        interog_6.addActionListener(mal);
    }
    
    void addInterogare_aListener(ActionListener mal) {
        interog_a.addActionListener(mal);
    }

    void addInterogare_bListener(ActionListener mal) {
        interog_b.addActionListener(mal);
    }
    
    public void setInterogare3() {

    	backStatus = status;
    	status = ViewState.INTEROGARE3;
    	updateView();
    }
    
    public void setInterogare4() {

    	backStatus = status;
    	status = ViewState.INTEROGARE4;
    	updateView();
    }
    
    public void setInterogare5() {

    	backStatus = status;
    	status = ViewState.INTEROGARE5;
    	updateView();
    }
    
    public void setInterogare6() {

    	backStatus = status;
    	status = ViewState.INTEROGARE6;
    	updateView();
    }
    
    public void goBack() {
    	
    	//System.out.println(backStatus + "");
    	status = backStatus;
    	backStatus = ViewState.MENIU_INTEROGARI;
    	updateView();
    }
    
    @SuppressWarnings("incomplete-switch")
	public void showFieldsA() {
    	
    	String text = "";
    	backStatus = status;
    	
    	switch (status) {
    	
    	case INTEROGARE3 :
    		status = ViewState.INTEROGARE3_SUBP_A;
    		break;
    		
    	case INTEROGARE4 :
    		status = ViewState.INTEROGARE4_SUBP_A;
    		break;
    		
    	case INTEROGARE5 :
    		status = ViewState.INTEROGARE5_SUBP_A;
    		break;
    		
    	case INTEROGARE6 :
    		status = ViewState.INTEROGARE6_SUBP_A;
    		break;
    	
    	}
    	
    	interog_a.setToolTipText(text);
    	updateView();
    }
    
    @SuppressWarnings("incomplete-switch")
	public void showFieldsB() {

    	backStatus = status;
    	String text = "";
    	
    	switch (status) {
    	
    	case INTEROGARE3 :
    		status = ViewState.INTEROGARE3_SUBP_B;
    		break;
    		
    	case INTEROGARE4 :
    		status = ViewState.INTEROGARE4_SUBP_B;
    		break;
    		
    	case INTEROGARE5 :
    		status = ViewState.INTEROGARE5_SUBP_B;
    		break;
    		
    	case INTEROGARE6 :
    		status = ViewState.INTEROGARE6_SUBP_B;
    		break;
    	
    	}
    	
    	interog_b.setToolTipText(text);
    	updateView();
    }
    
    public static void updateView() {
    	
    	String textA = "";
    	String textB = "";
    	
    	switch (status) {
    	
    	case MENIU_INTEROGARI:
    		titlu.setVisible(true);
    		
            interog_3.setVisible(true);
            titlu3.setVisible(true);
            
            interog_4.setVisible(true);
            titlu4.setVisible(true);
            
            interog_5.setVisible(true);
            titlu5.setVisible(true);
            
            interog_6.setVisible(true);
            titlu6.setVisible(true);
            
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(false);
    		//input.setVisible(false);
    		results.setVisible(false);
            scroll.setVisible(false);
            errorMsg.setVisible(false);
            padd.setVisible(false);
            
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		break;
    		
    	case INTEROGARE3:
    		titlu.setVisible(false);
            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);

            interog_a.setVisible(true);
            interog_b.setVisible(true);
            cerintaA.setVisible(true);
            cerintaB.setVisible(true);
            
    		backButton.setVisible(true);
    		//input.setVisible(false);
    		results.setVisible(false);
            scroll.setVisible(false);
            errorMsg.setVisible(false);
            padd.setVisible(false);
            
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
            
    		textA = "<html>Sa se gaseasca denumirea clasei si tara pentru clasele de tip crucisator cu deplasament intre valorile introduse.</html>";
    		textB = "<html>Sa se gaseasca numele navelor si anul lansarii pentru navele lansate dupa anul introdus, ordonate descrescator dupa anul lansarii.</html>";

    		break;
    		
    	case INTEROGARE4:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
            
            interog_a.setVisible(true);
            interog_b.setVisible(true);
            cerintaA.setVisible(true);
            cerintaB.setVisible(true);
            
    		backButton.setVisible(true);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		
    		textA = "<html>Sa se afiseze numele, deplasamentul si numarul de arme pentru navele angrenate in batalia introdusa.</html>";
    		textB = "<html>Sa se gaseasca perechi de calase ce apartin aceleeasi tari dar sunt de tipuri diferite.</html>";

    		break;
    		
    	case INTEROGARE5:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
            
            interog_a.setVisible(true);
            interog_b.setVisible(true);
            cerintaA.setVisible(true);
            cerintaB.setVisible(true);
            
    		backButton.setVisible(true);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		
    		textA = "<html>Sa se gaseasca detaliile claselor ce au cele mai putine arme.</html>";
    		textB = "<html>Sa se gaseasca detaliile bataliilor la care au participat navele clasei introduse</html>";

    		break;
    		
    	case INTEROGARE6:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(true);
            interog_b.setVisible(true);
            cerintaA.setVisible(true);
            cerintaB.setVisible(true);
            
    		backButton.setVisible(true);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		
    		textA = "<html>Sa se gaseasca tara ce detine clasa cu maximul dimensiunii tunurilor navelor de tipul introdus</html>";
    		textB = "<html>Sa se gaseasca pentru fiecare batalie numarul navelor din fiecare categorie rezultat.</html>";

    		break;
    		
    	case INTEROGARE3_SUBP_A:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(true);
    		//input.setVisible(true);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(true);
    		
            inputText.setVisible(true);
            b_userInputTf.setVisible(true);
            goButton.setVisible(true);
            padd2.setVisible(true);
    		
    		inputText.setText("<html>Introduceti valorile deplasamentului minim si maxim, separate printr-un spatiu!</html>");    	
    		break;
    		
    	case INTEROGARE3_SUBP_B:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
            backButton.setVisible(true);
    		//input.setVisible(true);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(true);
    		
            inputText.setVisible(true);
            b_userInputTf.setVisible(true);
            goButton.setVisible(true);
            padd2.setVisible(true);
    		
    		inputText.setText("<html>Introduceti anul minim de lansare!</html>");    	

    		break;
    		
    	case INTEROGARE4_SUBP_A:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(true);
    		//input.setVisible(true);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(true);
    		
            inputText.setVisible(true);
            b_userInputTf.setVisible(true);
            goButton.setVisible(true);
            padd2.setVisible(true);
    		
    		inputText.setText("<html>Introduceti numele bataliei!</html>");    	

    		break;
    		
    	case INTEROGARE4_SUBP_B:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(false);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		break;
    		
    	case INTEROGARE5_SUBP_A:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(false);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		break;
    		
    	case INTEROGARE5_SUBP_B:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(true);
    		//input.setVisible(true);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(true);
    		
            inputText.setVisible(true);
            b_userInputTf.setVisible(true);
            goButton.setVisible(true);
            padd2.setVisible(true);
    		
    		inputText.setText("<html>Introduceti clasa!</html>");    	

    		break;
    		
    	case INTEROGARE6_SUBP_A:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(true);
    		//input.setVisible(true);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(true);
    		
            inputText.setVisible(true);
            b_userInputTf.setVisible(true);
            goButton.setVisible(true);
            padd2.setVisible(true);
    		
    		inputText.setText("<html>Introduceti tipul cautat!</html>");    	

    		break;
    		
    	case INTEROGARE6_SUBP_B:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(false);
    		//input.setVisible(false);
    		results.setVisible(false);
    		scroll.setVisible(false);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(false);
    		break;
    		
    	case RESULTS:
    		titlu.setVisible(false);

            interog_3.setVisible(false);
            titlu3.setVisible(false);
            
            interog_4.setVisible(false);
            titlu4.setVisible(false);
            
            interog_5.setVisible(false);
            titlu5.setVisible(false);
            
            interog_6.setVisible(false);
            titlu6.setVisible(false);
           
            interog_a.setVisible(false);
            interog_b.setVisible(false);
            cerintaA.setVisible(false);
            cerintaB.setVisible(false);
            
    		backButton.setVisible(true);
    		//input.setVisible(false);
    		results.setVisible(true);
    		scroll.setVisible(true);
    		errorMsg.setVisible(false);
    		padd.setVisible(false);
    		
            inputText.setVisible(false);
            b_userInputTf.setVisible(false);
            goButton.setVisible(false);
            padd2.setVisible(true);
    		break;

    	}
    	
		interog_a.setToolTipText(textA);
		cerintaA.setText(textA);
		interog_b.setToolTipText(textB);
		cerintaB.setText(textB);
    }
        
    public static ViewState getInterogareCurenta() {
    	
    	return status;
    }
    
    public static void updateState(ViewState state) {
    	
    	//backStatus = status;
    	status = state;
    	updateView();
    }
    
    public static  void showResults(String result) {

    	if(result == "") {
    		
        	results.setText("Interogarea nu a returnat niciun rand!");
    	}
    	else {
    		
    		results.setText(result);
    	}
    	results.setBorder(new EmptyBorder(20, 20, 20, 20));
    }
    
    public static void printError(String msg) {
    	
    	errorMsg.setText(msg);
    	errorMsg.setVisible(true);
    	padd.setVisible(false);
    }

}
