package dresshub;

import java.util.ArrayList;

public class DressHubBillingServiceImpl implements DressHubBillingService {

	double totAmount = 0;
	int quantity = 30;
	@Override
	public double BillingService(ArrayList dress, ArrayList price, int qty, int dressCode) {
		// TODO Auto-generated method stub
		double dressPrice = (float) price.get(dressCode-1);
		System.out.println(dress.get(dressCode-1) + "    X  "+ qty+"=  "+(dressPrice * qty));
		totAmount = totAmount + (dressPrice * qty);
		//quantity = quantity - qty;
		
		return totAmount;
	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return quantity;
	}
	

	
}
