package racingcar.model.exception;

public class Exception {

    public void exceptionCarNameCheck(String name){
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_CANNOT_BE_BLANK);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EXCEEDS_MAX_LENGTH + name);
        }
    }
    public void exceptionTryCountCheck(String count){
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_MUST_BE_NUMBER + count);
        }
        if (count.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_CANNOT_BE_BLANK);
        }
    }


}
