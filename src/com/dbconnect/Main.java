package com.dbconnect;

import java.sql.Connection;

public class Main {
    public static void main(String args[]){
     DBFUNCTION db=new DBFUNCTION();
     Connection conn=db.connect_to_db("tourdb","postgres","aswin93");
    // db.createTable(conn,"employee");
    //db.insert(conn,"employee","Guru","Santhosh");
        db.update(conn,"employee","Ashwin","Aswin");
        db.display(conn,"employee");
    }
}
