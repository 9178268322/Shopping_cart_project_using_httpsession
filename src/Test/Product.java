package Test;

public class Product {
	
			     String code;
			     String name;
			     float price;
			     int qty;
			     
			     public String getCode() {
			     
			    	 return code;
			     }
			     public void setCode(String code) {
			     
			    	 this.code = code;
			     }
			     public String getName() {
			     
			    	 return name;
			     }
			     public void setName(String name) {
			     
			    	 this.name = name;
			     }
			     public int getQty() {
			     
			    	 return qty;
			     }
			     public void setQty(int qty) {
			     
			    	 this.qty = qty;
			     }
			     public void setPrice(float price) {
			     
			    	 this.price = price;
			     }
			     public float getPrice() {
			     
			    	 return price;
			     }
			     
			     public boolean equals(Object o) {
			     
			    	 if(o instanceof Product)
			    	     return ((Product)o).code.equals(code);
			    	 else
			    		 return false;
			     }
}
