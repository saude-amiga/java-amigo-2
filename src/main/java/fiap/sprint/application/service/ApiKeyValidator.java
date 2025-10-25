package fiap.sprint.application.service;

public interface ApiKeyValidator {
    boolean isValid(String apiKey);
    boolean isPresent(String apiKey);
}
