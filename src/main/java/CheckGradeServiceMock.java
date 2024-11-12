public class CheckGradeServiceMock {

    public boolean isGradeValid(int grade) {  // Заглушка для сервиса проверки оценки
        return grade >= 1 && grade <= 5;
    }
}

