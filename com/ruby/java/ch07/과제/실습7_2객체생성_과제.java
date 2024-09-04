package com.ruby.java.ch07.과제;

class Item2 { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    // 생성자
    public Item2(String name, double price, int stockQuantity) {
    	this.name = name;
    	this.price = price;
    	this.stockQuantity = stockQuantity;
    }

    // 재고 감소 메소드
    public void reduceStock(int quantity) {
    	this.stockQuantity -= quantity;
    }

    // 재고 증가 메소드
    public void increaseStock(int quantity) {

    }

    public void show() {
    	System.out.println(toString());
    }

	
	  @Override public String toString() {
		  return "name = " + name + ", price = " + price;
		   
	  }


    public double getPrice() {
    	return price;
    }
    
    public int getStockQuantity() {
    	return stockQuantity;
    }
}

class Electronics extends Item2 {
	
	private int warranty;

	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}
	
	public void show() {
		System.out.print(toString());
	} 
	public String toString() {
		return super.toString() + " , warranty = " + (warranty/12);
	}


}

class Clothing extends Item2 {
	private String size;
	private String color;

	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}
	
	public void show() {
		System.out.print(toString());
	} // name = ***, price=*** 등으로 출력
	public String toString() {
		return super.toString() + " , size = " + size + ", color = " + color;
	}

	
	
	
}

abstract class Customer2 {
    private String cname;
    private String city;
    private int age;
    
    abstract double applyDiscount(double totalAmount);

    // 생성자
    public Customer2(String cname, String city, int age) {
    	this.cname = cname;
    	this.city = city;
    	this.age = age;
    }

    public void show() {
    	System.out.println(toString());
    }

	  @Override public String toString() {
		  return "name = " + cname + ". city = " + city + ", age = " + age;
	  }
	 
}

class RegularCustomer extends Customer2 {

	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer(String cname, String city, int age) {
		super(cname, city, age);
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount * (1-REGULARDISCOUNT_RATE) ;
	}	
	
	public void show() {
		System.out.println(toString());
	} // name = ***, price=*** 등으로 출력
	public String toString() {
		return super.toString() + ", RATE = " + REGULARDISCOUNT_RATE;
	}

}

class PremiumCustomer extends Customer2 {
	
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer(String cname, String city, int age) {
		super(cname, city, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount * (1-PREMIUMDISCOUNT_RATE) ;
	}
	
	public void show() {
		System.out.println(toString());
	} // name = ***, price=*** 등으로 출력
	public String toString() {
		return super.toString() + ", RATE = " + PREMIUMDISCOUNT_RATE;
	}

	
}

class Order2 {
    private Customer2 customer; // 고객
    private Item2[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private String []orderDates;
    private int count = 0; // 아이템 개수

    // 생성자
    public Order2(Customer2 customer, int maxItems) {
    	this.customer = customer;
    	items = new Item2[maxItems];
    	quantities = new int[maxItems];
    	this.orderDates = new String[maxItems];
    }

    // 아이템 추가 메소드
    public void addItem(Item2 item, int orderQuantity, String orderDates) {
    		this.items[count] = item;
    		this.quantities[count] = orderQuantity;
    		this.orderDates[count] = orderDates;
    		this.items[count].reduceStock(orderQuantity);
    		count++;	
    }

    // 총액 계산 메소드
    public double calculateTotal() {
    	double total = 0;
    	for (int i =0 ; i < items.length ; i++) {
    		total += quantities[i] * items[i].getPrice();
    	}
    	return total;
    }

    // 주문 요약 출력 메소드
    public void printOrderSummary() {
    	customer.show();
    	for (int i = 0 ; i < count ; i++) {
    		items[i].show();
    		System.out.println(", quantity = " + quantities[i] + ", orderDate = " + orderDates[i] + ", stockQuantity = " + items[i].getStockQuantity());
    	}
    	System.out.println("Total = " + calculateTotal());
    	System.out.println("\t =>" + customer.applyDiscount(calculateTotal()) + " [Discount]");
    }
}

public class 실습7_2객체생성_과제 {
    public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Electronics laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 2);
		order1.addItem(laptop, 1, "2024-08-29");
		order1.addItem(tshirt, 2, "2024-08-29");

		Order2 order2 = new Order2(regularCustomer, 2);
		order2.addItem(phone, 1, "2024-08-29");
		order2.addItem(jacket, 1, "2024-08-29");

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
        
    }
}