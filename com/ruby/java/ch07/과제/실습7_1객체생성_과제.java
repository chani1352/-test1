package com.ruby.java.ch07.과제;

class Item { // 제품
    private String name; // 제품명
    private double price; // 제품 가격
    private int stockQuantity; // 재고량

    // 생성자
    public Item(String name, double price, int stockQuantity) {
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
    	this.stockQuantity += quantity;
    }

    // 정보 출력 메소드
    public void show() {
    	System.out.print(toString());
    }

	
	  @Override public String toString() {
		  return "name = " + name + ", price = " + price;
	  }
	  
	  // 접근자 메소드 public String getName() {
	  
    public double getPrice() {
    	return price;
    }
    
    public int getStockQuantity() {
    	return stockQuantity;
    }
}

class Customer {
    private String cname;
    private String city;
    private int age;

    // 생성자
    public Customer(String cname, String city, int age) {
    	this.cname = cname;
    	this.city = city;
    	this.age = age;
    }

    // 정보 출력 메소드
    public void show() {
    	System.out.println(toString());
    }

	
	  @Override public String toString() {
		  return "name = " + cname + ". city = " + city + ", age = " + age;
	  }
	 


}

class Order {
    private Customer customer; // 고객
    private Item[] items; // 주문 제품들
    private int[] quantities; // 주문 제품 수량들
    private String []orderDates;
    private int count = 0; // 아이템 개수

    // 생성자
    public Order(Customer customer, int maxItems) {
    	this.customer = customer;
    	items = new Item[maxItems];
    	quantities = new int[maxItems];
    	this.orderDates = new String[maxItems];
    }

    // 아이템 추가 메소드
    public void addItem(Item item, int orderQuantity, String orderDates) {
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
    }
}

public class 실습7_1객체생성_과제 {
    public static void main(String[] args) {
        // 아이템 생성
        Item laptop = new Item("노트북", 1200.00, 10);
        Item tshirt = new Item("티셔츠", 20.00, 50);
        Item phone = new Item("휴대폰", 800.00, 30);
        Item headphones = new Item("헤드폰", 150.00, 20);
        Item mouse = new Item("마우스", 30.00, 15);

        // 고객 생성
        Customer boy = new Customer("홍길동", "부산", 21);
        Customer girl = new Customer("계백", "양산", 22);

        // 주문 생성
        Order order1 = new Order(boy, 5); // 최대 5개 아이템
        order1.addItem(laptop, 1, "2024-08-29");
        order1.addItem(tshirt, 2, "2024-08-29");
        order1.addItem(phone, 1, "2024-08-29");
        order1.addItem(headphones, 1, "2024-08-29");
        order1.addItem(mouse, 1, "2024-08-29");
        


        Order order2 = new Order(girl, 5); // 최대 5개 아이템
        order2.addItem(laptop, 1, "2024-08-29");
        order2.addItem(tshirt, 1, "2024-08-29");
        order2.addItem(phone, 1, "2024-08-29");
        order2.addItem(headphones, 1, "2024-08-29");
        order2.addItem(mouse, 1, "2024-08-29");

        // 주문 요약 출력
        order1.printOrderSummary();
        order2.printOrderSummary();
        
    }
}