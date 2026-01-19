package hu.markrefteam.sqljdbc;

import hu.markrefteam.sqljdbc.dao.ShopItemDao;
import hu.markrefteam.sqljdbc.db.ConnectionFactory;
import hu.markrefteam.sqljdbc.model.ShopItem;

import java.sql.Connection;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {

            ShopItemDao dao = new ShopItemDao(connection);

            //1-2:

            ShopItem new1 = new ShopItem("chocolate", 899, 4);
            dao.saveWithDefaultDate(new1);
            System.out.println("Inserted default date -> " + new1);

            ShopItem new2 = new ShopItem("honey", 1999, 2, LocalDate.of(2025, 12, 24));
            dao.saveWithCustomDate(new2);
            System.out.println("Inserted custom date -> " + new2);

            System.out.println("\n--- ALL ITEMS ---");
            dao.findAll().forEach(System.out::println);

            System.out.println("\n--- AVAILABLE ITEMS ---");
            dao.findAvailableItems().forEach(System.out::println);

            System.out.println("\n--- SEARCH: choco ---");
            dao.findByNameLike("choco").forEach(System.out::println);


            //3-4:

            System.out.println("Updated rows: " + dao.updateNameById(10, "dark_chocolate"));
            System.out.println("Deleted rows: " + dao.deleteByName("honey"));
            dao.findAll().forEach(System.out::println);

            //5:

            System.out.println("Exists honey? " + dao.existsByName("honey"));
            System.out.println("Safe delete honey -> deleted rows: " + dao.deleteByNameSafe("honey"));
            System.out.println("Exists honey after? " + dao.existsByName("honey"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
