package at.fhtw.swen3.paperless.ocr.services.interfaces;

import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public interface OcrExecutorService {

    String executeOcr(File file) throws TesseractException;

}
