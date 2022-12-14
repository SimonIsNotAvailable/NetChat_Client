import java.io.*;

import Client.ClientRegistration;
import Logger.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.only;

public class ClientRegistrationTest {

    private ClientRegistration clientReg;

    @Test
    public void testRegister() throws IOException {
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("Type your Username:", "Welcome to chat! please enter your messages in the console:");
        PrintWriter out = mock(PrintWriter.class);
        Logger logger = mock(Logger.class);

        String input = "TEST NAME";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        clientReg = new ClientRegistration(in, out);
        clientReg.setLogger(logger);
        boolean actual = clientReg.register();

        verify(in, times(2)).readLine();
        verify(out, only()).println(anyString());

        assertTrue(actual);
    }
}
