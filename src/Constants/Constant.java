package Constants;
public class Constant
{
    public static final int SEASON=1;
    public static final int WINNER=10;
    public static final int ID=0;
    public static final String YEAR="season";
    public static final String TOTAL_MATCHES="total_matches";
    public static final String WINER="winner";
    public static final String COUNT ="count";
    public static final String BOWLIN_TEAM="bowling_team";
    public static final String TOTA_RUN="tota_run";
    public static final String BOULER ="bowler";
    public static final String ECONOMY="economy";
    public static final int MATCH_ID=0;
    public static final int BOWLING_TEAM=3;
    public static final int EXTRA_RUNS=16;
    public static final int BOWLER=8;
    public static final int TOTAL_RUNS=17;
    public static final int WIDE_RUNS=10;
    public static final int NO_BALL=13;
    public static final String MATCHES_CSV="matches.csv";
    public static final String DELIVERIES_CSV="deliveries.csv";
    public static final String Q1_ANS="Question1 Answer";
    public static final String Q2_ANS="Question2 Answer";
    public static final String Q3_ANS="Question3 Answer";
    public static final String Q4_ANS="Question4 Answer";


    public static final String URL      = "jdbc:postgresql://localhost:5432/mayank";   //database specific url.
    public static final String USER     = "mayank";
    public static final String PASSWORD = "mayank";
    public static final String CREATE_DELIVERY_TABLE="CREATE TABLE IF NOT EXISTS delivery (ID INT REFERENCES match(id) NOT NULL ,BOWLING_TEAM TEXT NOT NULL ,\" +\n" +
            "                \"BOWLER TEXT NOT NULL,EXTRA_RUN INT NOT NULL,WIDE_RUN INT NOT NULL,NO_BALL INT NOT NULL\" +\n" +
            "                \",TOTAL_RUN FLOAT NOT NULL )";
    public static final String INSERT_MATCH_ROWS="INSERT INTO match(ID,SEASON,WINNER) values(?,?,?)";
    public static final String INSER_DELIVERY_ROWS="INSERT INTO delivery(ID,BOWLING_TEAM,BOWLER,EXTRA_RUN,WIDE_RUN,NO_BALL,TOTAL_RUN) values(?,?,?,?,?,?,?)";
    public static final String CREATE_MATCH_TABLE ="CREATE TABLE IF NOT EXISTS match (ID INT PRIMARY KEY NOT NULL ,SEASON INT NOT NULL ,WINNER TEXT NOT NULL)";
    public static final String SQL1="SELECT SEASON,COUNT(ID) as total_matches from match group by SEASON";
    public static final String SQL2="SELECT SEASON,Count(SEASON) from (SELECT SEASON from match where winner=?)as foo group by season";
    public static final String SQL5="SELECT bowling_team,sum(extra_run)as extraRUN from (select * from match join delivery on match.id=delivery.id )as result1 group by bowling_team";
    public static final String SQL3="Select bowling_team,sum(extra_run) as tota_run from  delivery where id in (SELECT id from match) group by bowling_team;";
    public static final String SQL4="Select bowler,CAST((sum(total_run)/(count(total_run)-count(wide_run)+count(no_ball)))*6.0 as FLOAT) as economy from  delivery group by bowler;";







}
