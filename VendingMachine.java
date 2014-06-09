
public class VendingMachine {

private int numslots;
private int maxperslots;
private double cash;
private int [] quantities; 
private String [] slotnames;
private double [] prices;




public VendingMachine(int numslots, int maxperslots, double cash){
	this.numslots = numslots;
	this.maxperslots = maxperslots;
	this.cash = cash;
	this.quantities = new int [numslots];
	this.slotnames= new String [numslots];
	this.prices = new double [numslots];
}
	
	

public void setProduct (int slot, String product, double price){
	slotnames[slot] = product;
	prices[slot] = price;
	
}

public void restockProduct(String product, int quantity)
{
	for (int i = 0; i< slotnames.length; i++){
		if (slotnames[i]!=null) {
		if (slotnames[i].equalsIgnoreCase(product)){	
			quantities[i] += quantity;
			quantity = quantities[i] - maxperslots;
			if (quantities[i]>maxperslots){
				quantities[i] = maxperslots;
				if (quantity > 0){
					continue;
				}
			}
			else if (quantities[i]<maxperslots){
				break;}
		}		
	}
		
		else {
			continue;
		}
	}
		
}

	
public double getCashOnHand()
{
	return cash;
}

public int getQuantity(int slot)
{
	if (slot<numslots){
	return quantities[slot];}
	else{
		return -1;
	}
}

public int getQuantity(String product)
{ int x = 0;
	for (int i = 0; i<slotnames.length; i++){
		if (slotnames[i]!=null){   
			if (!slotnames[i].equalsIgnoreCase(product)){
			  
		   		continue;}
		   else{
			   x += quantities[i];
			   continue;
		   }
		}
		else{
			continue;
		}
	}
	
	return x;}


public boolean buyItem(int slot)
{
if (slot<numslots){
if (quantities[slot]!=0){
	quantities[slot]-=1;
	cash += prices[slot];
	return true;
}
else{
	return false;
}
}
else{
	return false;
}
}

}
	

