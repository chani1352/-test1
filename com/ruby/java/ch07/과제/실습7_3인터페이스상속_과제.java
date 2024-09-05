package com.ruby.java.ch07.과제;

interface Discountable{
	double getDiscountedPrice(double price);
}

class SeasonalDiscount implements Discountable {
	private double discountRate;


	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public double getDiscountedPrice(double price) {
		return price * (1-discountRate);
	}
}

abstract class Item3 {
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량
	
	public Item3(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
		
	public double getPrice() {
		return price;
	}
	public abstract void aaa();

}


class Electronics3 extends Item3 {
	int madeYear;
	
	public Electronics3(String name, double price, int stockQuantity, int madeYear) {
		super(name,price,stockQuantity);
		this.madeYear = madeYear;
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

}

class Clothing3 extends Item3 {
	int size;
	
	public Clothing3(String name, double price, int stockQuantity, int size) {
		super(name,price,stockQuantity);
		this.size = size;
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

}

abstract class Customer3 {
	private String name;
	abstract double applyDiscount(double totalAmount);
	
	public Customer3(String name) {
		this.name = name;
	}
}


class RegularCustomer3 extends Customer3 {
	
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	public RegularCustomer3(String name) {
		super(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount * (1- REGULARDISCOUNT_RATE);
	}
	

}


class PremiumCustomer3 extends Customer3 {
	
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	public PremiumCustomer3(String name) {
		super(name);
	}

	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount * (1- PREMIUMDISCOUNT_RATE);
	}

}


class Order3 extends SeasonalDiscount{
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private static int count = 0;


	public Order3(Customer3 customer, double discountRate)  {
		super(discountRate);
		this.customer = customer;
		items = new Item3[N];
		quantities = new int[N];
		orderDates = new String[N];
	}

	public void addItem(Item3 item, int quantity, String date) {
		items[count] = item;
		quantities[count] = quantity;
		orderDates[count] = date;
		count++;
	}

	public double calculateTotal() {
		double total = 0;
		for (int i = 0 ; i < count ; i++) {
			total += getDiscountedPrice(items[i].getPrice()) * quantities[i];
		}
		count = 0;
		return total;
	}

	public void printOrderSummary() {
		System.out.println(calculateTotal());
	}
	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		System.out.println(customer.applyDiscount(calculateTotal()));

	}
}

class 실습7_3인터페이스상속_과제 {
	public static void main(String[] args) {
		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성 
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order3 regularOrder = new Order3(regularCustomer, 0.01);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails();  // 할인된 내역 출력
		
		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer, 0.01);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails();  // 할인된 내역 출력
	}
}