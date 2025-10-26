package racingcar.model.exception;

public class Exception {

    public void exceptionCarNameCheck(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 null 또는 공백일 수 없습니다.");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 공백만으로 구성될 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다: " + name);
        }
    }
    public void exceptionTryCountCheck(String count){
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다: " + count);
        }
        if (count.isBlank()) {
            throw new IllegalArgumentException("시도 횟수는  공백일 수 없습니다.");
        }
    }


}
