import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ten program, pozwala na dodanie dostępnych produktów, a sztuczna inteligencja " +
                "stworzy dla ciebie przepis z podanych produktów");
        while (true) {
            System.out.println("1. Wyświetl produkty");
            System.out.println("2. Dodaj produkt");
            System.out.println("3. Usuń produkt");
            System.out.println("4. Z podanych produktów daj mi 3 przepisy na śniadanie");
            System.out.println("5. Z podanych produktów daj mi 3 przepisy na obiad");
            System.out.println("6. Z podanych produktów daj mi 3 przepisy na kolację");
            System.out.println("7. Poleć mi zdrowe produkty, które warto kupić do codziennej diety");
            System.out.println("8. Zakończ aplikację");
            System.out.println();
            System.out.println("Wybierz opcję: ");

            int choice = Integer.parseInt(scanner.nextLine());
            ProductManager productManager = new ProductManager();
            ChatGPT chatGPT = new ChatGPT();

            switch (choice) {
                case 1 ->{
                    productManager.getAllProducts().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("Jaki produkt dodać? ");
                    String product = scanner.nextLine();
                    productManager.addProduct(product);
                }
                case 3 -> {
                    System.out.println("Jaki produkt usunąć? ");
                    String product = scanner.nextLine();
                    productManager.deleteProduct(product);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("3 przepisy na śniadanie od ChatGPT: \n" );
                    System.out.println(chatGPT.getBreakfastRecipes(productManager.getAllProducts()));
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("3 przepisy na obiad od ChatGPT: \n");
                    System.out.println(chatGPT.getDinnerRecipes(productManager.getAllProducts()));
                    System.out.println();
                }
                case 6 -> {
                    System.out.println("3 przepisy na kolacje od ChatGPT: \n");
                    System.out.println(chatGPT.getSupperRecipes(productManager.getAllProducts()));
                    System.out.println();
                }
                case 7 -> {
                    System.out.println("Zdrowe produkty, które według ChatGPT warto kupić: \n");
                    System.out.println(chatGPT.getHealthyProducts(productManager.getAllProducts()));
                    System.out.println();
                }
                case 8 -> {
                    System.out.println("Aplikacja została wyłączona. ");
                    System.exit(0);
                    scanner.close();
                }
            }
        }
    }
}