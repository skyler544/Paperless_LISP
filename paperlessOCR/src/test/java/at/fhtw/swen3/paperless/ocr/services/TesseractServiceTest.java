package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.services.interfaces.OcrExecutorService;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TesseractServiceTest {

    @Mock
    OcrExecutorService tesseractService;

    @Test
    public void tesseractServiceReturnOcr() throws TesseractException {

        //given
        File file = new File("");
        String fileContent = "File content";
        Mockito.when(tesseractService.executeOcr(file)).thenReturn(fileContent);

        //when
        String result = tesseractService.executeOcr(file);

        //then
        assertEquals(fileContent, result);
    }

}