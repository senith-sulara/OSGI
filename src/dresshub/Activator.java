package dresshub;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private static BundleContext Bcontext;
	//ServiceRegistration producerService;

	static BundleContext getContext() {
		return Bcontext;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.Bcontext = context;
		
		context.registerService(DressHubBillingService.class.getName(),new DressHubBillingServiceImpl(),null);
		System.out.println("-------------Dress Hub Billing System Started Successfully-------------");
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dateTime.format(now));
		
		System.out.println("-----------------------------------------------------------------------"); 
	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.Bcontext = null;
		
		DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		System.out.println("-----------------------------------------------------------------------"); 
		
		System.out.println("Bill Closed Time :  "+ dateTime.format(now));  
		System.out.println("-------------Dress Hub Billing System Stoped Successfully--------------");
		
		System.out.println("                   Thank you for your support");
		System.out.println("                      Software By 2021S1_REG_WE_27");
	}

}
