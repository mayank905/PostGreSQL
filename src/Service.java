import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static Constants.Constant.*;

public class Service
{

    public HashMap<Integer,Integer> question1(Connection c) throws SQLException {
        HashMap<Integer,Integer> m=new HashMap<>();
        String sql = SQL1;

        PreparedStatement preparedStatement =
                c.prepareStatement(sql);
        ResultSet r=preparedStatement.executeQuery();
        //System.out.println(r);
        while (r.next()) {
            int season = r.getInt(YEAR);
            int count = r.getInt(TOTAL_MATCHES);
            m.put(season,count);
        }
    return m;

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public HashMap<String,HashMap> question2(Connection c) throws SQLException {
        HashMap<String,HashMap>noOfWinPerYear = new HashMap<>();
        String sql1= "SELECT winner from match group by winner";
        PreparedStatement preparedStatement1 =
                c.prepareStatement(sql1);
        ResultSet r1=preparedStatement1.executeQuery();

        while (r1.next()) {
            String team = r1.getString(WINER);

            String sql3 = SQL2;

            PreparedStatement preparedStatement3 =
                    c.prepareStatement(sql3);
            preparedStatement3.setString(1, team);


            ResultSet r3=preparedStatement3.executeQuery();
            HashMap<Integer,Integer>m=new HashMap<>();
            while(r3.next())
            {
                int season=r3.getInt(YEAR);
                int count =r3.getInt(COUNT);
                m.put(season,count);
            }

            noOfWinPerYear.put(team,m);


        }

        return noOfWinPerYear;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap<String,Integer> question3(Connection c)throws SQLException
    {
        HashMap<String,Integer> extraRunConceed = new HashMap<>();

        String sql1= SQL3;
        PreparedStatement preparedStatement1 =
                c.prepareStatement(sql1);
        ResultSet r1=preparedStatement1.executeQuery();

        //Set<String> matchId =new HashSet<>();
        while(r1.next())
        {
            String team = r1.getString(BOWLIN_TEAM);
            int run =r1.getInt(TOTA_RUN);
            extraRunConceed.put(team,run);
        }


        return extraRunConceed;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap<String, Float> question4(Connection c) throws SQLException
    {
        HashMap<String,Float> economyOfBowler = new HashMap<>();

        String sql1= SQL4;
        PreparedStatement preparedStatement1 =
                c.prepareStatement(sql1);
        ResultSet r1=preparedStatement1.executeQuery();

        //Set<String> matchId =new HashSet<>();
        while(r1.next())
        {
            String team = r1.getString(BOULER);
            float run =r1.getFloat(ECONOMY);
            economyOfBowler.put(team,run);
        }
        return economyOfBowler;
    }
}
