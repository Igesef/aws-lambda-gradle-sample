package pl.owcy.aws;

import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isOneOf;
import static org.hamcrest.Matchers.notNullValue;

public class ListHandlerTest {

    @Test
    public void not_null_result() {
        //when
        List<String> returnedList = handler.handleRequest(createList(), createTestContext());

        //then
        assertThat(returnedList, notNullValue());
    }

    @Test
    public void single_item_returned() {
        //when
        List<String> returnedList = handler.handleRequest(createList(), createTestContext());

        //then
        assertThat(returnedList, hasSize(1));
    }

    @Test
    public void result_is_item_from_list() {
        //when
        String element = handler.handleRequest(createList(), createTestContext()).get(0);

        //then
        assertThat(element, isOneOf(createList().toArray()));
    }

    private ListHandler handler = new ListHandler();

    private List<String> createList() {
        return Arrays.asList("apples", "oranges", "plums", "strawberries");
    }

    private Context createTestContext() {
        return new Context() {

            @Override
            public String getAwsRequestId() {
                return "";
            }

            @Override
            public String getLogGroupName() {
                return "";
            }

            @Override
            public String getLogStreamName() {
                return "";
            }

            @Override
            public String getFunctionName() {
                return "";
            }

            @Override
            public String getFunctionVersion() {
                return "";
            }

            @Override
            public String getInvokedFunctionArn() {
                return "";
            }

            @Override
            public CognitoIdentity getIdentity() {
                return null;
            }

            @Override
            public ClientContext getClientContext() {
                return null;
            }

            @Override
            public int getRemainingTimeInMillis() {
                return 0;
            }

            @Override
            public int getMemoryLimitInMB() {
                return 0;
            }

            @Override
            public LambdaLogger getLogger() {
                return null;
            }
        };
    }
}