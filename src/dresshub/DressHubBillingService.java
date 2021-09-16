package dresshub;

import java.util.ArrayList;

public interface DressHubBillingService {

	public double BillingService(ArrayList dress, ArrayList price, int qty, int dressCode) ;
	int getStock();
}
