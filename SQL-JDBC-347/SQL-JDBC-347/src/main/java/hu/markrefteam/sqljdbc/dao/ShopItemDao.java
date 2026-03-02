package hu.markrefteam.sqljdbc.dao;

import hu.markrefteam.sqljdbc.model.ShopItem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShopItemDao {

    private final Connection connection;

    public ShopItemDao(Connection connection) {
        this.connection = connection;
    }

    //1-2:

    private static final String SQL_INSERT_DEFAULT_DATE = """
            INSERT INTO shop_item (item_name, item_price, quantity)
            VALUES (?, ?, ?)
            """;

    private static final String SQL_INSERT_CUSTOM_DATE = """
            INSERT INTO shop_item (item_name, item_price, quantity, date_added)
            VALUES (?, ?, ?, ?)
            """;

    //3-4:

    private static final String SQL_DELETE_BY_NAME = """
            DELETE FROM shop_item
            WHERE item_name = ?
            """;

    private static final String SQL_UPDATE_NAME_BY_ID = """
            UPDATE shop_item
            SET item_name = ?
            WHERE id = ?
            """;

    //5:

    private static final String SQL_EXISTS_BY_NAME = """
            SELECT COUNT(*) AS cnt
            FROM shop_item
            WHERE item_name = ?
            """;

    //1-2:

    public List<ShopItem> findAll() {
        List<ShopItem> items = new ArrayList<>();

        String sql = """
                SELECT id, item_name, item_price, quantity, date_added
                FROM shop_item
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ShopItem item = new ShopItem(
                        rs.getLong("id"),
                        rs.getString("item_name"),
                        rs.getInt("item_price"),
                        rs.getInt("quantity"),
                        rs.getDate("date_added").toLocalDate()
                );
                items.add(item);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching shop items", e);
        }

        return items;
    }

    public List<ShopItem> findAvailableItems() {
        List<ShopItem> items = new ArrayList<>();

        String sql = """
                SELECT id, item_name, item_price, quantity, date_added
                FROM shop_item
                WHERE quantity > 0
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                items.add(new ShopItem(
                        rs.getLong("id"),
                        rs.getString("item_name"),
                        rs.getInt("item_price"),
                        rs.getInt("quantity"),
                        rs.getDate("date_added").toLocalDate()
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching available items", e);
        }

        return items;
    }

    public List<ShopItem> findByNameLike(String part) {
        List<ShopItem> items = new ArrayList<>();

        String sql = """
                SELECT id, item_name, item_price, quantity, date_added
                FROM shop_item
                WHERE item_name LIKE ?
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + part + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    items.add(new ShopItem(
                            rs.getLong("id"),
                            rs.getString("item_name"),
                            rs.getInt("item_price"),
                            rs.getInt("quantity"),
                            rs.getDate("date_added").toLocalDate()
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while searching by name: " + part, e);
        }

        return items;
    }

    public long saveWithDefaultDate(ShopItem item) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_DEFAULT_DATE, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, item.getItemName());
            stmt.setInt(2, item.getItemPrice());
            stmt.setInt(3, item.getQuantity());

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Insert failed, affected rows: " + affected);
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    long id = keys.getLong(1);
                    item.setId(id);
                    return id;
                }
                throw new RuntimeException("Insert succeeded but no ID returned.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while inserting shop item (default date)", e);
        }
    }


    public long saveWithCustomDate(ShopItem item) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT_CUSTOM_DATE, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, item.getItemName());
            stmt.setInt(2, item.getItemPrice());
            stmt.setInt(3, item.getQuantity());
            stmt.setDate(4, Date.valueOf(item.getDateAdded()));

            int affected = stmt.executeUpdate();
            if (affected != 1) {
                throw new RuntimeException("Insert failed, affected rows: " + affected);
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    long id = keys.getLong(1);
                    item.setId(id);
                    return id;
                }
                throw new RuntimeException("Insert succeeded but no ID returned.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while inserting shop item (custom date)", e);
        }
    }

    //3-4:

    public int deleteByName(String name) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_BY_NAME)) {
            stmt.setString(1, name);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting by name: " + name, e);
        }
    }

    public int updateNameById(long id, String newName) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE_NAME_BY_ID)) {
            stmt.setString(1, newName);
            stmt.setLong(2, id);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating name for id: " + id, e);
        }
    }

    //5:

    public boolean existsByName(String name) {
        try (PreparedStatement stmt = connection.prepareStatement(SQL_EXISTS_BY_NAME)) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                int count = rs.getInt("cnt");
                return count > 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while checking existence by name: " + name, e);
        }
    }

    //Extra for delete:

    public int deleteByNameSafe(String name) {
        if (!existsByName(name)) {
            return 0;
        }
        return deleteByName(name);
    }
}