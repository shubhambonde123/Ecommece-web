package Ecom.mini;



public class Product {
		 private String productName;
	 	 private String productId;
	 	 private int price;
	 	 private int quantity;
	 	 private String description;
	 	 private String adminid;
	 	 
	 	 
	 	 public String getAdminid() {
			return adminid;
		}

		public void setAdminid(String adminid) {
			this.adminid = adminid;
		}

		public Product() {
	 		 //System.out.println("Default product Constructor ");
		}
	 	 
		public Product(String productName, String productId, int price, int quantity, String description) {
			super();
			this.productName = productName;
			this.productId = productId;
			this.price = price;
			this.quantity = quantity;
			this.description = description;
		}
		
		
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	 	 
	 	 
}
