package at.fhtw.swen3.paperless.services.messageQueue;

public interface MessageQueueService {

    void processMessage(String message);

}
