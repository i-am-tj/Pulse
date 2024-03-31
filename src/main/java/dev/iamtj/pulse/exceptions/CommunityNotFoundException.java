package dev.iamtj.pulse.exceptions;

public class CommunityNotFoundException extends RuntimeException {
    public CommunityNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
