package dresshubconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import org.osgi.util.tracker.ServiceTracker;
import dresshub.DressHubBillingService;
import dresshub.DressHubBillingServiceImpl;

public class Activator implements BundleActivator {

	
	private static BundleContext context = null;
	ServiceReference serviceReference;
	private ServiceTracker serviceTracker = null;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceTracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+DressHubBillingService.class.getName()+")"+"(Language=*))"),null);
		serviceTracker.open();

		System.out.println("------------- Dress Hub Billing Consumer Started Successfully -------------");
		
try {
	    	
	    	int dressCode;
	    	int qty = 0;
	    	double amount = 0;
	    	double discount = 0.10;
	    	double tot = 0;
	    	int quantity = 30;
	    	char choice;
	    	
	    	ArrayList<String> dress = new ArrayList<String>();
	    	ArrayList<Float> dressPrice = new ArrayList<Float>();
	    	
	    	dress.add("Frok");
	    	dressPrice.add((float) 800.00);
			
			dress.add("Short");
			dressPrice.add((float) 450.00);
			
			dress.add("Mens T-Shirt");
			dressPrice.add((float) 720.00);
			
			dress.add("Womens T-Shirt");
			dressPrice.add((float) 600.00);
			
			dress.add("Mens Denim");
			dressPrice.add((float) 3200.00);
			
			dress.add("Womwns Denim");
			dressPrice.add((float) 3130.00);
			
			dress.add("Kids Short");
			dressPrice.add((float) 300.00);
			
			dress.add("Night Wear");
			dressPrice.add((float) 700.00);
			
			dress.add("Cotton Saree");
			dressPrice.add((float) 3200.00);
			
			dress.add("Womens purse");
			dressPrice.add((float) 500.00);
			
			dress.add("Mens purse");
			dressPrice.add((float) 540.00);
			
			
			for (int i = 0; i < dressPrice.size(); i++)
			  {
		        System.out.println(i+1 + "  " +dress.get(i) +"  Rs:"+dressPrice.get(i));
		      }
			
			Scanner myScanner = new Scanner(System.in);
			DressHubBillingService dressBill = new DressHubBillingServiceImpl();
			
			System.out.println();
			do {
				System.out.println("Enter Dress Code : ");
				dressCode = myScanner.nextInt();
				
				System.out.println("Enter Quantity : ");
				qty = (int) myScanner.nextFloat();
				if(qty > quantity) {
					System.out.println("Store limit Exceeded!");
				}
				else {	
					//quantity = quantity - qty;
				}
			    	
				amount = dressBill.BillingService(dress, dressPrice,qty, dressCode);
				
			    System.out.print("Want to add more item? (y or n): ");
			    choice = myScanner.next().charAt(0);	
			
			    System.out.println("");
			
			}while(choice == 'y' || choice == 'Y');
			
			System.out.println("-----------------------------------------------------------------------");
			
			if(amount >= 5000) {
				tot = amount - (amount * discount);
				System.out.println("Discount Total :" + amount * discount);
			}
			else {
				
				tot = amount;
				System.out.println("Discount Total : 0.00");
			}
				System.out.println("Gross Total :" + amount);
				
				System.out.println("Total :"+ tot);
				
			System.out.println("-----------------------------------------------------------------------");	
	    }
	    
	    catch (Exception e)
	    {
	    	
	    }
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("------------- Dress Hub Billing  Consumer Service stoped successfully -------------");
	}

}
