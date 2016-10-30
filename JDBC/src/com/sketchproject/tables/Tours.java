package com.sketchproject.tables;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

/**
 * JDBC
 * Created by Angga on 29/07/2016.
 */
@SuppressWarnings("Duplicates")
public class Tours {

    public static void displayData(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            StringBuilder buffer = new StringBuilder();

            int tourId = resultSet.getObject("tourId", Integer.class);
            String tourName = resultSet.getObject("tourName", String.class);
            BigDecimal price = resultSet.getObject("price", BigDecimal.class);

            buffer.append("Tour ").append(tourId).append(": ").append(tourName);

            NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
            String formattedPrice = numberFormat.format(price);

            buffer.append(" (").append(formattedPrice).append(")");
            System.out.println(buffer.toString());
        }
    }

    public static void displayData(ResultSet resultSet, int nRows) throws SQLException {
        if (nRows == 0) {
            System.out.println("No tours were found");
        } else {
            System.out.println("Number of rows : " + nRows);
            while (resultSet.next()) {
                StringBuffer buffer = new StringBuffer();

                int tourId = resultSet.getObject("tourId", Integer.class);
                String tourName = resultSet.getObject("tourName", String.class);
                BigDecimal price = resultSet.getObject("price", BigDecimal.class);

                buffer.append("Tour ").append(tourId).append(": ").append(tourName);

                NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                String formattedPrice = numberFormat.format(price);

                buffer.append(" (").append(formattedPrice).append(")");
                System.out.println(buffer.toString());
            }
        }
    }
}
