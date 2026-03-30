import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "СПБ"), 500);
        costPerAddress.put(new Address("Россия", "Казань"), 600);
        costPerAddress.put(new Address("Беларусь", "Минск"), 700);
        costPerAddress.put(new Address("Казахстан", "Алматы"), 900);

        newOrder(costPerAddress);
    }


    public static void newOrder(Map<Address, Integer> costPerAddress) {
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;
        Set<String> uniqueCountries = new HashSet<>();

        while (true) {
            System.out.println();
            System.out.print("Заполнение нового заказа.\nВведите страну или ''end'' для выхода: ");
            String country = scanner.nextLine();
            if (country.equals("end")) break;
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            Address searchAddress = new Address(country, city);
            if (costPerAddress.containsKey(searchAddress)) {
                int basePrice = costPerAddress.get(searchAddress);
                int currentOrderCost = basePrice * weight;
                totalSum += currentOrderCost;
                uniqueCountries.add(country);

                System.out.printf("Стоимость доставки составит: %d руб.\n", currentOrderCost);
                System.out.printf("Общая стоимость всех доставок: %d руб.\n", totalSum);
                System.out.printf("Количество уникальных стран доставки: %d \n", uniqueCountries.size());
            } else {
                System.out.println("Доставка по этому адресу не осуществляется");
            }
        }
    }
}
