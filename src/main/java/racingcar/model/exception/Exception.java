package racingcar.model.exception;

public class Exception {

    public void exceptionCarNameCheck(String name){
        validateNameLength(name);
        validateNameNotBlank(name);
    }
    private void validateNameNotBlank(String name){
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_CANNOT_BE_BLANK);
        }
    }
    private void validateNameLength(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EXCEEDS_MAX_LENGTH + name);
        }
    }

    public void exceptionTryCountCheck(String count){
        validateTryCountIsNumber(count);
        validateTryCountNotBlank(count);

    }
    private void validateTryCountIsNumber(String count){
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_MUST_BE_NUMBER + count);
        }
    }
    private void validateTryCountNotBlank(String count){
        if (count.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_CANNOT_BE_BLANK);
        }
    }
}
