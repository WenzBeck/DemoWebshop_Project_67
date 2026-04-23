package demowebshop.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDataProviders {

    @DataProvider(name = "loginDataFromCsv")
    public Object[][] loginDataFromCsv() throws IOException {

        List<Object[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/data1234.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");

                if (split.length >= 3) {
                    data.add(new Object[]{
                            split[0], // email
                            split[1], // password
                            split[2]  // expected result
                    });
                }
            }
        }

        return data.toArray(new Object[0][]);
    }
}
