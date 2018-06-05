package webapp;

import org.apache.commons.io.FileUtils;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Random;

public class Account {

    private int id;
    private String name;
    private String password;
    private String nameHash;
    private String passHash;
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/siberteam";
    private static final String user = "postgres";
    private static final String pass = "213202";


    public Account(String name, String password){
        this.id = new Random().nextInt(100000);
        this.setName(name);
        this.setPassword(password);
        try{
            this.setNameHash(md5Hash(name));
            this.setPassHash(md5Hash(password));
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void setData(Account acc) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            String query = "INSERT INTO siberteam.public.account"
                    + "(id,login,password,login_hash,password_hash) VALUES"
                    + "(?,?,?,?,?)";
            PGSimpleDataSource source = new PGSimpleDataSource() ;
            source.setServerName("localhost");
            source.setDatabaseName("siberteam");
            source.setUser(user);
            source.setPassword(pass);

            DataSource dataSource = source ;
            conn = dataSource.getConnection();
            System.out.println("Connection successful!!!");

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, acc.id);
            preparedStatement.setString(2, acc.name);
            preparedStatement.setString(3, acc.password);
            preparedStatement.setString(4, acc.nameHash);
            preparedStatement.setString(5, acc.passHash);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {

            try { conn.close(); } catch(SQLException se) { /*can't do anything */ }
        }


    }


    private String md5Hash(String msg) throws NoSuchAlgorithmException {

        String string = String.valueOf(msg);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(StandardCharsets.UTF_8.encode(string));
        String result = String.format("%032x", new BigInteger(1, md5.digest()));
        return result;
    }

    public void logEvent(String msg) {
        File file = new File("/home/player1/Documents/cache.txt");
        try{
            FileUtils.writeStringToFile(file, msg, true);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameHash() {
        return nameHash;
    }

    public void setNameHash(String nameHash) {
        this.nameHash = nameHash;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}