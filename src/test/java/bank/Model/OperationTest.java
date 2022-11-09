package bank.Model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationTest {

    @Test
    //can_not_be_able_to_create_invalid_operation
    public void OperationTestWithInvalidParamertes() {
        assertThrows(Exception.class, () -> new Operation(null, null, null));
    }
}
