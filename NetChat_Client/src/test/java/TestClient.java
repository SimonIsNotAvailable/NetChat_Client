import Client.Client;
import Client.ClientRegistration;
import Client.MessageListener;
import Client.MessageSender;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

public class TestClient {

    private Client client;

    @Test
    public void connectToServerTestFalse() {
        ClientRegistration registerService = mock(ClientRegistration.class);

        client = new Client();
        client.setRegisterService(registerService);

        assertFalse(client.connectToServer());
    }
}
