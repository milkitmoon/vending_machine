package com.milkit.app.vending.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;

import com.milkit.app.util.NumberUtil;
import com.milkit.app.vending.exception.ServiceException;
import com.milkit.app.vending.exception.SystemException;
import com.milkit.app.vending.machine.VandingMachine;


public class VendingMain {

	public static void main(String[] args) throws Exception  {
		new VendingMain().run();
	}
	
	private void run() throws Exception {
        Properties properties = getResources("vending.cnf");
        VandingMachine vandingMachine = VandingMachine.build(properties);
		
		while(true) {
			System.out.println(vandingMachine.showMain());
			
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();
			
			switch(userInput) {
				case "y":
					System.out.println(vandingMachine.showComplete());
					
					vandingMachine.cancel();
					
					Thread.sleep(2000);
					break;
				case "c":
					System.out.println(vandingMachine.showCancel());
					
					vandingMachine.cancel();
					break;
				case "x":
					System.out.println(vandingMachine.showTerminate());
					
					System.exit(0);
					break;
				default:
					if( NumberUtil.isNumeric(userInput) ) {
						try {
							System.out.println( vandingMachine.putCurrency( Integer.parseInt(userInput) ) );
						} catch(ServiceException ex) {
							System.out.println(ex.getMessage());
						}
					} else {
						try {
							System.out.println( vandingMachine.purchaseProduct(userInput) );
						} catch(ServiceException ex) {
							System.out.println(ex.getMessage());
						}
					}
			}
			
			Thread.sleep(1200);			//사용자에게 메시지를 표시하는 시간동안 잠시 대기하기 위해.. 
		}
	}

	private static Properties getResources(String filePath) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
       	FileReader resources= new FileReader(filePath);
        properties.load(resources);
        
		return properties;
	}

}
