import com.google.gson.Gson;
import org.example.MainNew;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainNewTest {
    String query = "https://raw.githubusercontent.com/thewhitesoft/student-2023-assignment/main/data.json";
    HttpURLConnection connection = null;
    MainNew mainNew;
    String[] arr;
    StringBuilder sb;
    String[] replStr;
    String[] newreplStr;
    int i;
    @Before
    public void prepareData() {
        mainNew = new MainNew();
        arr = new String[29];
        sb = new StringBuilder();
        replStr = new String[arr.length];
        newreplStr = new String[arr.length];
        i = 0;
    }
    @Before
    public void Connect() throws Exception{
        connection = (HttpURLConnection) new URL(query).openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.connect();
    }

    @Test
    public void TestWritingLines() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        mainNew.WritingLines(null, sb, in, arr, 0);
        Assert.assertEquals(arr[1], "  \"Two roads diverged in a yellow d12324344rgg6f5g6gdf2ddjf,\",");
    }
    @Test
    public void TestReplaceRowsNew() throws Exception{
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        mainNew.WritingLines(null, sb, in, arr, 0);

        mainNew.ReplaceRowsNew(replStr, arr, i, gson, newreplStr);
        Assert.assertEquals(replStr[2], "  \"Robert Frost poetAnd sorry I could not travel both\",");
        Assert.assertEquals(replStr[4], "  \"And be one traveler, long I stood\",");

    }
    @Test
    public void TestReplaceRows() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        mainNew.WritingLines(null, sb, in, arr, 0);

        mainNew.ReplaceRows(replStr, arr, i);
        Assert.assertEquals(replStr[2], "  \"Robert Frost poetAnd sorry I could not travel both\",");
        Assert.assertEquals(replStr[4], "  \"And be one traveler, long I stood\",");

    }
    @Test
    public void TestReplaceRowsNewIsEmpty() throws Exception{
        Gson gson = new Gson();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        mainNew.WritingLines(null, sb, in, arr, 0);

        mainNew.ReplaceRowsNew(replStr, arr, i, gson, newreplStr);
        Assert.assertEquals(replStr[3], "  \"null\",");

    }
    @Test
    public void TestReplaceRowsIsEmpty() throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        mainNew.WritingLines(null, sb, in, arr, 0);

        mainNew.ReplaceRows(replStr, arr, i);
        Assert.assertEquals(replStr[3], "  \"\",");

    }
}
