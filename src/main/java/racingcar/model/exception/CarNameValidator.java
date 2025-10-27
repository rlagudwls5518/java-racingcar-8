package racingcar.model.exception;

public class CarNameValidator implements Validator{
    @Override
    public void validate(String name) {
        validateNameLength(name);
        validateNameNotBlank(name);
    }

    private void validateNameNotBlank(String name){
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_CANNOT_BE_BLANK);
        }
    }
    private void validateNameLength(String name){
        if (name.length() >= 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EXCEEDS_MAX_LENGTH + name);
        }
    }
}
