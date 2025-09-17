package com.cucumber.pages;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API {
    public String getWindData(String fieldName, String designLoads, String riskCategory, String siteClass, double lat, double lng) {
        String windValue = null;
        try {
            //Open API so just pass content type in Given()
            Response response =
                    given().
                            contentType("application/json").
                            when().
                            get("https://api-hazards.atcouncil.org/" + fieldName + ".json?group=" + designLoads + "&subgroup=" + riskCategory + "&siteclass=" + siteClass + "&lat=" + lat + "&lng=" + lng).
                            then().
                            extract().response();
            //convert response to string then create object of jsonpath
            System.out.println("testApi response: " + response.asPrettyString());

            JsonPath jsonPath = new JsonPath(response.asPrettyString());
            List<String> slugs = jsonPath.getList("datasets.slug");
            System.out.println("Slugs: " + slugs);
            List<String> names = jsonPath.getList("datasets.name");
            System.out.println("names: " + names);
            List<String> groups = jsonPath.getList("datasets.group");
            System.out.println("groups: " + groups);
            List<Object> values = jsonPath.getList("datasets.data.value");
            System.out.println("values: " + values);

//            LinkedHashMap<String, String> json1 = new LinkedHashMap<>();
//            for (int i = 0; i < slugs.size(); i++) {
//                json1.put(slugs.get(i), names.get(i));
//            }
//            System.out.println("json1: " + json1);

//            LinkedHashMap<String, String> json2 = new LinkedHashMap<>();
//            for (int i = 0; i < slugs.size(); i++) {
//                json2.put(slugs.get(i), groups.get(i));
//            }
//            System.out.println("json2: " + json2);
//
//            LinkedHashMap<String, Object> json3 = new LinkedHashMap<>();
//            for (int i = 0; i < slugs.size(); i++) {
//                json3.put(slugs.get(i), values.get(i));
//            }
//            System.out.println("json3: " + json3);
//
//            for (Map.Entry<String, String> entry : json2.entrySet()) {
//                if (entry.getValue().equalsIgnoreCase(designLoads)) {
//                    String slug = entry.getKey();
//                    for (Map.Entry<String, String> entry1 : json1.entrySet()) {
//                        if (entry1.getKey().equalsIgnoreCase(slug)) {
//                            String getValue = entry1.getValue();
//                            if (getValue.equalsIgnoreCase(riskCategory)) {
//                                String riskCat1 = entry1.getKey();
//                                System.out.println(riskCategory + " slug is: " + riskCat1);
//                                for (Map.Entry<String, Object> entry2 : json3.entrySet()) {
//                                    if (entry2.getKey().equalsIgnoreCase(riskCat1)) {
//                                        Object getVal = entry2.getValue();
//                                        System.out.println(riskCategory + " value is: " + getVal);
//                                        windValue = getVal.toString();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
        } catch (AssertionError | Exception e) {
            ExtentCucumberAdapter.getCurrentStep().fail(e.getMessage());
            e.printStackTrace();
        }
        return windValue;
    }
}
