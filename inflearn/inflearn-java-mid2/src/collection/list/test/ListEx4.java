package collection.list.test;

import java.util.ArrayList;
import java.util.List;

public class ListEx4 {
    public static void main(String[] args) {
        ShoppingCart<Item> cart = new ShoppingCart<>();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        cart.add(item1);
        cart.add(item2);
        cart.displayItem();
    }

    static class ShoppingCart<E extends Item> {
        private List<E> items = new ArrayList<>();

        public void add(E item) {
            items.add(item);
        }

        /**
         * 장바구니 상품 출력
         * 상품명:마늘, 합계:4000
         * 상품명:상추, 합계:12000
         * 전체 가격 합: 16000
         */
        public void displayItem() {
            for (E item : items) {
                System.out.println("상품명:" + item.getName() + ", 합계:" + item.getTotalPrice());
            }

            int totalPrice = 0;
            for (E item : items) {
                totalPrice += item.getTotalPrice();
            }

            System.out.println("전체 가격 합:" + totalPrice);


        }
    }

    static class Item {
        private String name;
        private int price;
        private int quantity;

        public Item(String name, int price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public int getTotalPrice() {
            return price * quantity;
        }
    }
}
