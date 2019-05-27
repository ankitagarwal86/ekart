package com.tcs.learn.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Item getTotalPricePerItem(Item item) {
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = " + item.getId(),
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(final ResultSet rs, final int i) throws SQLException {
                        return new Product(
                                rs.getString("id"),
                                rs.getString("name"),
                                rs.getInt("stock"),
                                rs.getDouble("pricePerUnit"),
                                rs.getBigDecimal("weightInGrams")
                        );
                    }
                });

        if (product.getStock() > item.getQuantity()) {
            return new Item(item.getId(), item.getQuantity(), product.getPricePerUnit() * item.getQuantity());
        }

        return new Item(item.getId(), item.getQuantity(), ERROR.OUT_OF_STOCK);
    }

    public DeliveryDetails getDeliveryDetails(String toPostalCode) {
        return jdbcTemplate.queryForObject("SELECT C.deliveryDays, D.eligiblityForFreeDelivery, D.deliveryCharges FROM COVERAGE  C, DELIVERYCHARGES D where C.FROMPOSTALCODE = '12121' AND C.toPostalCode = ? AND C.MAtrix_id = D.id",
                new Object[]{toPostalCode}, new RowMapper<DeliveryDetails>() {
                    @Override
                    public DeliveryDetails mapRow(final ResultSet rs, final int i) throws SQLException {
                        return new DeliveryDetails(
                                rs.getDouble("deliveryDays"),
                                rs.getDouble("eligiblityForFreeDelivery"),
                                rs.getInt("deliveryCharges")
                        );
                    }
                });
    }
}
