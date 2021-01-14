package baza_date_barci;

public class TestClass {

	public static void main(String[] args) {
        
		BarciModel 		model 		= new BarciModel(); 
        BarciView 		view 		= new BarciView();
        BarciController controller 	= new BarciController(model, view);
        
        view.setVisible(true);
	}

}
