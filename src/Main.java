import org.postgresql.util.PSQLException;

import static Constants.Constant.*;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = makeConnection(URL, USER, PASSWORD);

        Readcsv2 match_file =new Readcsv2();
        List<String[]> matchesStringList = match_file.parseMatchesCsvfile(MATCHES_CSV);
        Statement statement = connection.createStatement();
        //statement.executeQuery("drop table IF EXISTS match;");
        Statement statement1 = connection.createStatement();
       // statement1.executeQuery("drop table IF EXISTS delivery;");

        //createMatchTable(connection);

        //insertMatchRows(connection,matchesStringList);


        Readcsv2 deliveryFile =new Readcsv2();
        List<String[]> deliveryStringList = deliveryFile.parseMatchesCsvfile(DELIVERIES_CSV);
        //createDeliveryTable(connection);
        //insertDeliveryRows(connection,deliveryStringList);





        Service service1=new Service();//create service class object


        HashMap<Integer,Integer> noOfMatchPerYear=service1.question1(connection);
        printF(Q1_ANS,noOfMatchPerYear);


        HashMap<String,HashMap>  noOfWinPerYear=service1.question2(connection);
        printF(Q2_ANS,noOfWinPerYear);


        HashMap<String,Integer> extraRunConceed=service1.question3(connection);
        printF(Q3_ANS,extraRunConceed);


        HashMap<String,Float> economyOfBowler=service1.question4(connection);
        printF(Q4_ANS,economyOfBowler);


    }

    private static void insertDeliveryRows(Connection connection, List<String[]> deliveryStringList) throws SQLException {
        String sql =INSER_DELIVERY_ROWS;
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);
        for (String[] y : deliveryStringList) {
            preparedStatement.setInt(1, Integer.parseInt(y[MATCH_ID]));
            preparedStatement.setString(2, y[BOWLING_TEAM]);
            preparedStatement.setString(3, y[BOWLER]);
            preparedStatement.setInt(4, Integer.parseInt(y[EXTRA_RUNS]));
            preparedStatement.setInt(5, Integer.parseInt(y[WIDE_RUNS]));
            preparedStatement.setInt(6, Integer.parseInt(y[NO_BALL]));
            preparedStatement.setFloat(7, Float.parseFloat(y[TOTAL_RUNS]));
            preparedStatement.execute();
        }
    }

    private static void createDeliveryTable(Connection connection) throws SQLException {
        String sql = CREATE_DELIVERY_TABLE;

        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

        preparedStatement.execute();
    }

    private static void insertMatchRows(Connection connection, List<String[]> matchesStringList) throws SQLException {
        String sql =INSERT_MATCH_ROWS;
        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);
        for (String[] y : matchesStringList) {
            try{
            preparedStatement.setInt(1, Integer.parseInt(y[ID]));
            preparedStatement.setInt(2, Integer.parseInt(y[SEASON]));
            preparedStatement.setString(3, y[WINNER]);
            preparedStatement.execute();
        }catch (PSQLException e){continue;}

        }

    }

    private static void createMatchTable(Connection connection) throws SQLException
    {
        String sql = CREATE_MATCH_TABLE;

        PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

         preparedStatement.execute();
    }


    private static Connection makeConnection(String url, String user, String password) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void printF(String s, Map m)
    {
        System.out.println(s);
        System.out.println(m);System.out.println();System.out.println();
    }


}

