package baza_date_barci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BarciModel {

	private static Connection con;
	private static Statement stt;
	private static ResultSet res;
	private static PreparedStatement prep;
	
	BarciModel() {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "1234";

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, user, password);
            stt = con.createStatement();
            stt.execute("USE barci");

            //res.close();
            //stt.close();
            //prep.close();
            //con.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public void interogareA(String input, ViewState interogare) {
		
		try {
			
	        Scanner scanner = new Scanner(input);
	        String result = "";
	        int nr = 0;
			
			switch (interogare) {
			
			case MENIU_INTEROGARI:
				System.out.println("Eroare la selectarea interogarii dorite!");
				break;
				
			case INTEROGARE3_SUBP_A:
				System.out.println("\nInterogare 06.03 - a");
		        
		        prep = con.prepareStatement("SELECT clasa, tara\r\n"
		        		+ "FROM clase\r\n"
		        		+ "WHERE tip = 'cr' AND (deplasament >= ? AND deplasament <= ?);");

		        prep.setInt(1, scanner.nextInt());
		        prep.setInt(2, scanner.nextInt());
		        
		        res = prep.executeQuery();
		        result = "CLASA	|   TARA\n" + 
		        		"---------------------------------------\n";
		        
		        while (res.next())
		        {
		        	result += res.getString(1) + "	|   ";
		        	result += res.getString(2) + "\n";
		        	nr++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        //System.out.println(result);
		        BarciView.showResults(result);
	        	break;
				
			case INTEROGARE4_SUBP_A:
				System.out.println("\nInterogare 06.04 - a");
		        
		        prep = con.prepareStatement("SELECT n.nume, c.deplasament, c.nr_arme\r\n"
		        		+ "FROM nave n JOIN clase c ON n.clasa=c.clasa\r\n"
		        		+ "JOIN consecinte con ON con.nava=n.nume\r\n"
		        		+ "WHERE con.batalie=?;");
		        prep.setString(1, input);
		        
		        res = prep.executeQuery();
		
		        result = "NAVA	|   DEPLASAMENT  |   NUMAR ARME\n" + 
		        		"-------------------------------------------------------------------------\n";
		        
		        while (res.next())
		        {
		        	result += res.getString(1) + "	|   ";
		        	result += res.getString(2) + "	         |   ";
		        	result += res.getString(3) + "\n";
		        	nr++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        //System.out.println(result);
		        BarciView.showResults(result);			
		        break;
				
			case INTEROGARE5_SUBP_A:
				System.out.println("\nInterogare 06.05 - a");
		        
		        prep = con.prepareStatement("SELECT *\r\n"
		        		+ "FROM CLASE\r\n"
		        		+ "WHERE nr_arme <= ALL(SELECT nr_arme FROM clase);");
		        
		        res = prep.executeQuery();
		
		        result = "CLASA	|   TIP	|   TARA		|   NUMAR ARME	|   DIAMETRU TUN	|   DEPLASAMENT\n" + 
		        		"------------------------------------------------------------------------------------------"
		        		+ "-------------------------------------------------------------------"
		        		+ "-------------------------------------\n";
		        
		        while (res.next())
		        {
		        	result += res.getString(1) + "	|   ";
		        	result += res.getString(2) + "	|   ";
		        	if(res.getString(3).length() >= 24) {
		        		
		        		result += res.getString(3) + "  |   ";
		        	}
		        	else {
		        		
		        		result += res.getString(3) + "		|   ";
		        	}
		        	result += res.getString(4) + "		|   ";
		        	result += res.getString(5) + "		|   ";
		        	result += res.getString(6) + "\n";
		        	nr++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        //System.out.println(result);
		        BarciView.showResults(result);				
		        break;
				
			case INTEROGARE6_SUBP_A:
				System.out.println("\nInterogare 06.06 - a");
		        
		        prep = con.prepareStatement("SELECT tara\r\n"
		        		+ "FROM clase\r\n"
		        		+ "WHERE diametru_tun = (SELECT MAX(diametru_tun) FROM clase WHERE tip = ?);");
		        prep.setString(1, input);

		        
		        res = prep.executeQuery();
		
		        result = "TARA\n" + 
		        		"--------------------------------\n";
		        while (res.next())
		        {
		        	result += res.getString(1) + "\n";
		        	nr ++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        //System.out.println(result);
		        BarciView.showResults(result);			
		        break;

			}
			
			BarciView.updateState(ViewState.RESULTS);
			scanner.close();
		    
		}
        catch (InputMismatchException e)
        {
            BarciView.printError("Datele introduse nu corespund cerintei!");
        }
		
        catch (NoSuchElementException e)
        {
            BarciView.printError("Datele introduse nu corespund cerintei!");
        }
		
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
	
	public void interogareB(String input, ViewState interogare) {
		
		try {
	        Scanner scanner = new Scanner(input);
	        String result = "";	
	        int nr = 0;
			
			switch (interogare) {
			
			case MENIU_INTEROGARI:
				System.out.println("Eroare la selectarea interogarii dorite!");
				break;
				
			case INTEROGARE3_SUBP_B:
				System.out.println("\nInterogare 06.03 - b");
		        
		        prep = con.prepareStatement("SELECT nume, anul_lansarii\r\n"
		        		+ "FROM nave\r\n"
		        		+ "WHERE anul_lansarii > ?\r\n"
		        		+ "ORDER BY anul_lansarii DESC;");

		        prep.setInt(1, scanner.nextInt());
		        
		        res = prep.executeQuery();
		
		        result = "NUME		|   ANUL LANSARII\n" + 
		        		"------------------------------------------------------------------\n";
		        while (res.next())
		        {
		        	
		        	result += res.getString(1) + "		|   ";
		        	result += res.getString(2) + "\n";
		        	nr ++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        BarciView.showResults(result);
	        	break;
				
			case INTEROGARE4_SUBP_B:
				System.out.println("\nInterogare 06.04 - b");
		        
		        prep = con.prepareStatement("CALL perechiClase;");
		        
		        res = prep.executeQuery();
		
		        result = "PERECEHE		|   TIP1	|   TIP2\n" + 
		        		"----------------------------------------------------------"
		        		+ "------------------\n";
		        while (res.next())
		        {
		        	
		        	result += res.getString(1) + "	|   ";
		        	result += res.getString(2) + "	|   ";
		        	result += res.getString(3) + "\n";
		        	nr ++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        BarciView.showResults(result);			
		        break;
				
			case INTEROGARE5_SUBP_B:
				System.out.println("\nInterogare 06.05 - b");
		        
		        prep = con.prepareStatement("SELECT *\r\n"
		        		+ "FROM consecinte\r\n"
		        		+ "WHERE nava IN (SELECT nume FROM nave WHERE clasa = ?);");
		        prep.setString(1, input);
		        
		        res = prep.executeQuery();
		
		        result = "NAVA	|   BATALIE		|   REZULTAT\n" + 
		        		"----------------------------------------------------------"
		        		+ "-------------------------\n";
		        while (res.next())
		        {
		        	
		        	result += res.getString(1) + "	|   ";
		        	result += res.getString(2) + "	|   ";
		        	result += res.getString(3) + "\n";
		        	nr ++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        BarciView.showResults(result);			
		        break;
				
			case INTEROGARE6_SUBP_B:
				System.out.println("\nInterogare 06.06 - b");
		        
		        prep = con.prepareStatement("SELECT  COUNT(nava), batalie, rezultat\r\n"
		        		+ "FROM consecinte\r\n"
		        		+ "GROUP BY batalie, rezultat\r\n"
		        		+ "ORDER BY batalie;");
		        
		        res = prep.executeQuery();
		
		        result = "NUMAR NAVE |   BATALIE		|   REZULTAT\n" + 
		        		"----------------------------------------------------------"
		        		+ "-------------------------\n";
		        while (res.next())
		        {
		        	
		        	result += res.getString(1) + "	 |   ";
		        	result += res.getString(2) + "	|   ";
		        	result += res.getString(3) + "\n";
		        	nr ++;
		        }
		        
		        if(nr == 0) {
		        	
		        	result = "";
		        }
		        
		        BarciView.showResults(result);			
		        break;
			}
			
			BarciView.updateState(ViewState.RESULTS);
	        scanner.close();
		}
        catch (InputMismatchException e)
        {
            BarciView.printError("Datele introduse nu corespund cerintei!");
        }
		
        catch (NoSuchElementException e)
        {
            BarciView.printError("Datele introduse nu corespund cerintei!");
        }
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
