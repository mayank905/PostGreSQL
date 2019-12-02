import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Readcsv2
{

    public List<String[]> parseMatchesCsvfile(String csvFile) {

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<String[]> eachRow =new ArrayList<>();


        try {
            br = new BufferedReader(new FileReader(csvFile));
            line =  br.readLine();
            //String[] heading = line.split(cvsSplitBy);
            while ((line = br.readLine()) != null)
            {
                // use comma as separator
                String[] match = line.split(cvsSplitBy);
                eachRow.add(match);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return eachRow;

    }

}
