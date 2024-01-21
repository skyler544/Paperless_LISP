package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.services.interfaces.DispatcherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsumerServiceTest {

    //Create a mock to inject into
    @Mock
    private DispatcherService dispatcherService;

    //injectMocks annotation used to inject mocks into the ConsumerService class
    @InjectMocks
    private ConsumerService consumerService;
    @Test
    public void whenMsgReceivedDispatcherCalled() {

        //Given
        String message = "Incoming message";

        //when
        consumerService.receive(message);

        // Then
        Mockito.verify(dispatcherService, Mockito.times(1)).handleMessage(message);
    }

}