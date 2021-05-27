package dataProviderTestNG_my;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * grub data from getData func instead of xml file
 * wil grub data by order of list
 */

public class Provider_1 {

    @Test(dataProvider = "getData")
    void setData(String uName, String uPass) {
        System.out.println("uName: " + uName);
        System.out.println("uPass: " + uPass + "\n");
    }

    @DataProvider
    Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][1] = "pass";
        data[0][0] = "name";

        data[1][1] = "first";
        data[1][0] = "second";

        data[2][0] = "first";
        data[2][1] = "second";
        return data;
    }
}

