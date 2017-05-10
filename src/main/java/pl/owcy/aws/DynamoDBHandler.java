package pl.owcy.aws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class DynamoDBHandler {

    private static final String TEST_TABLE = "TEST_TABLE";

    public String handleRequest(List<String> input) {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.DEFAULT_REGION)
                .build();

        input.forEach(e -> client.putItem(TEST_TABLE, newItem(e)));

        return "ok";
    }

    private Map<String, AttributeValue> newItem(String value) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("value", new AttributeValue(value));

        return item;
    }
}
