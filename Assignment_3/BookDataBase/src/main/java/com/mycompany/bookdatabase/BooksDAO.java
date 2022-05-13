/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookdatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rahuludhayakumar
 */
public class BooksDAO {
    
            public static int addbooks(List<Books> list,int count) throws SQLException {
             
                ArrayList<Books> ls= new ArrayList<Books>();
        Connection connection = null;
        int result = 0;
        PreparedStatement statement = null;
        try {
            JdbcConnection dao = new JdbcConnection();
            connection = dao.getConnection();
           for (int i = 0; i < list.size(); i++) {
               ls.add(list.get(i));
                String isbn = ls.get(i).getIsbn();
                String name = ls.get(i).getName();
                String authors = ls.get(i).getAuthors();
                String price = ls.get(i).getPrice();
             
                String query = "insert into Booksdb (isbn, name, authors, price) value (?,?,?,?)";
                statement = connection.prepareStatement(query);
                statement.setString(1, isbn);
                statement.setString(2, name);
                statement.setString(3, authors);
                statement.setString(4, price);
                result = statement.executeUpdate();
          }
        
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally{
            connection.close();
        return result;
        }
    }
    
}
