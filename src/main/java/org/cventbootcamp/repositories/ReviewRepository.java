package org.cventbootcamp.repositories;

import org.cventbootcamp.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import java.sql.*;
import javax.sql.DataSource;
import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Override
    public Review findById(int imdbId) {
        String sql = "SELECT * FROM reviews WHERE imdbId = ?";
        Review review = new Review();
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, imdbId);
            ResultSet row = ps.executeQuery();

            if (row.next()) {
                review = mapRow(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return review;
    }
    private Review mapRow(ResultSet row) throws SQLException {
        String imdbId = row.getString("imdb_id");
        Long id = row.getLong("id");
        String reviewerName = row.getString("reviewer_name");
        String reviewText = row.getString("review_text");
        int rating = row.getInt("rating");

        return new Review(id, reviewerName, rating, imdbId, reviewText);
    }
}