package pl.owcy.aws;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ListHandler implements RequestHandler<List<String>, List<String>> {

    @Override
    public List<String> handleRequest(List<String> input, Context context) {
        return Collections.singletonList(input.get(new Random().nextInt(input.size())));
    }
}
