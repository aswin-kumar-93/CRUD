package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFUNCTION {
    public Connection connect_to_db(String dbname,String user ,String pass){
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Connection established");
            }
            else{
                System.out.print("Failed");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        return conn;
     }
     public void createTable(Connection conn, String table_name){
         Statement stmt;
         try{
             String query="create table "+table_name+"(firstname varchar(200),lastname varchar(200));";
            stmt=conn.createStatement();
            stmt.executeUpdate(query);
            System.out.print("Table Created");

         }
         catch(Exception e){
             System.out.print(e);
         }
     }
     public void insert(Connection conn,String table_name,String firstname,String lastname){

        try{
            String query=String.format("Insert into %s(firstname,lastname) values('%s','%s');",table_name,firstname,lastname);
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(query);
            System.out.print("Row inserted");
        }
        catch(Exception e){
            System.out.print(e);
        }
     }
     public void display(Connection conn,String table_name){
        try{
            String query=String.format("select * from %s",table_name);
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("firstname")+" ");
                System.out.println(rs.getString("lastname")+" ");
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
     }
     public void update(Connection conn,String table_name,String newname,String oldname){
        try{
            Statement st=conn.createStatement();
            String query=String.format("Update %s set firstname='%s' where firstname='%s'",table_name,newname,oldname );
            st.executeUpdate(query);
            System.out.print("Updated");

        }
        catch(Exception e){
            System.out.print(e);
        }
     }
}
