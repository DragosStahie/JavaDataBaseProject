package baza_date_barci;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BarciController {

	
    private BarciModel b_model;
    private BarciView  b_view;
    
    BarciController(BarciModel model, BarciView view) {
        b_model = model;
        b_view  = view;
        
        //... Add listeners to the view.
        view.addBackListener(new BackListener());
        view.addGoListener(new GoListener());
        
        view.addInterogare_3Listener(new Interogare_3Listener());
        view.addInterogare_4Listener(new Interogare_4Listener());
        view.addInterogare_5Listener(new Interogare_5Listener());
        view.addInterogare_6Listener(new Interogare_6Listener());

        
        view.addInterogare_aListener(new Interogare_aListener());
        view.addInterogare_bListener(new Interogare_bListener());
    }
    
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	b_view.goBack();
        }
    }
    
    class GoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	        	
            String userInput = "";
            userInput = b_view.getUserInput();
            if(BarciView.getInterogareCurenta() == ViewState.INTEROGARE3_SUBP_A ||
            		BarciView.getInterogareCurenta() == ViewState.INTEROGARE4_SUBP_A ||
            		BarciView.getInterogareCurenta() == ViewState.INTEROGARE6_SUBP_A) {
            	
            	b_model.interogareA(userInput, BarciView.getInterogareCurenta());
            }
            
            if(BarciView.getInterogareCurenta() == ViewState.INTEROGARE3_SUBP_B ||
            		BarciView.getInterogareCurenta() == ViewState.INTEROGARE5_SUBP_B) {
            	
            	b_model.interogareB(userInput, BarciView.getInterogareCurenta());
            }

        }
    }
    
    class Interogare_3Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	b_view.setInterogare3();
        }
    }
    
    class Interogare_4Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	b_view.setInterogare4();
        }
    }

    class Interogare_5Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	b_view.setInterogare5();
        }
    }
    
    class Interogare_6Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	b_view.setInterogare6();
        }
    }

    
    class Interogare_aListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
            	b_view.showFieldsA();
                userInput = b_view.getUserInput();
                if(BarciView.getInterogareCurenta() == ViewState.INTEROGARE5_SUBP_A) {
                	
                	b_model.interogareA(userInput, BarciView.getInterogareCurenta());
                	//BarciView.updateState(ViewState.RESULTS);
                }
                
            } catch (NumberFormatException nfex) {
                nfex.printStackTrace();
            }
        }
    }
    
    class Interogare_bListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
            	b_view.showFieldsB();
            	userInput = b_view.getUserInput();
            	 if(BarciView.getInterogareCurenta() == ViewState.INTEROGARE4_SUBP_B ||
            			 BarciView.getInterogareCurenta() == ViewState.INTEROGARE6_SUBP_B) {
            		 
            		b_model.interogareB(userInput, BarciView.getInterogareCurenta());
                 	BarciView.updateState(ViewState.RESULTS);
            	 }
                
            } catch (NumberFormatException nfex) {
                nfex.printStackTrace();
            }
        }
    }
    
}
