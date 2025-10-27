package racingcar.model.exception;

public class TryCountValidator implements Validator{
    @Override
    public void validate(String count) {
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
