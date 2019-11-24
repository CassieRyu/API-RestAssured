package com.rest.assured;

import org.testng.annotations.DataProvider;


public class TestData {

    @DataProvider(name = "filmsTitle", parallel = true)
    public Object[][] createSearchSpecificTestData() {
        return new String[][]{
                {"2baf70d1-42bb-4437-b551-e5fed5a87abe", "Castle in the Sky"},
                {"12cfb892-aac0-4c5b-94af-521852e46d6a", "Grave of the Fireflies"},
                {"58611129-2dbc-4a81-a72f-77ddfc1b1b49", "My Neighbor Totoro"}
        };
    }
}
