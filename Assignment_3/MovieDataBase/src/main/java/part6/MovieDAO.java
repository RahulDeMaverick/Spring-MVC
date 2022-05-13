/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part6;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author rahuludhayakumar
 */
public class MovieDAO {
    
        public int addMovie(String title, String actor, String actress, String genre, String year) {
        Connection connection = null;
        int result = 0;
        try {
            JdbcConnection dao = new JdbcConnection();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            String query = "insert into movies (title, actor, actress, genre, year) values (?, ?, ?, ?, ?)";
            result = queryRunner.update(connection, query, title, actor, actress, genre, year);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }
        
        public List<Movie> get(String type, String keyword) {
        Connection connection = null;
        List<Movie> result = null;
        try {
             JdbcConnection dao = new JdbcConnection();
            connection = dao.getConnection();
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<List<Movie>> handler = new BeanListHandler<Movie>(Movie.class);
            String query = "";
            if (type.equals("title")) {
                query = "select * from movies where title = ?";
            } else if (type.equals("actor")) {
                query = "select * from movies where actor = ?";
            } else if (type.equals("actress")) {
                query = "select * from movies where actress = ?";
            }
            result = queryRunner.query(connection, query, handler, keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
    
}
