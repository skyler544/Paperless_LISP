package at.fhtw.swen3.paperless.ocr.services;

import at.fhtw.swen3.paperless.ocr.services.interfaces.OcrExecutorService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TesseractService implements OcrExecutorService {

    private final String tesseractDataPath;

    public TesseractService(@Value("${tesseract.data.path}") String tesseractDataPath) {
        this.tesseractDataPath = tesseractDataPath;
    }

    private ITesseract instantiateTesseract() {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(this.tesseractDataPath);
        return tesseract;
    }

    @Override
    public String executeOcr(File file) throws TesseractException {

        ITesseract tesseract = this.instantiateTesseract();
        return tesseract.doOCR(file);

    }

}
