package eip.mvc.model.util;
/*
 * DB 연동을 위한 로드, 연결, 닫기 기능 클래스
 * 
 * */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
   private static Properties proFile = new Properties();
   /**
    * 로드
    * */
   static {
      try{
            //2개의 properties파일 로딩하기!
            proFile.load(new FileInputStream("properties/dbInfo.properties"));
            proFile.load(new FileInputStream("properties/project.properties"));
            
            Class.forName(proFile.getProperty("driverName"));
         } catch (Exception e){
            e.printStackTrace();
         }
   }
   public static Properties getProFile() {
      return proFile;
   }
   /**
    * 연결
    * */
   public static Connection getConnection() throws SQLException{ 
      //어차피 try catch 해주는거면 여기서 한꺼번에 해주는게 낫다
      return DriverManager.getConnection(
            proFile.getProperty("url"),
            proFile.getProperty("userName"),
            proFile.getProperty("userPass"));
   }
   
   /**
    * 닫기 (insert, update, delete인 경우)
    * */
   public static void dbClose(Statement st, Connection con) {
      try {
      if(st!=null) st.close();
      if(con!=null) con.close();
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }
   /**
    * 닫기 (select인 경우)
    * */
   public static void dbClose(ResultSet rs, Statement st, Connection con) {
      if(rs!=null)
         try {
            rs.close();
            dbClose(st, con);
         } catch (SQLException e) {
            e.printStackTrace();
         }
   }
   public static void main(String[] args) {
      System.out.println(1111);
   }
}