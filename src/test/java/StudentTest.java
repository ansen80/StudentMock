import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testAddGrade() { //Заглушка для сервиса
        CheckGradeServiceMock mockService = new CheckGradeServiceMock();

        Student student = new Student("Андрей", mockService);
        student.addGrade(3);
        student.addGrade(5);

        assertEquals(2, student.getGrades().size());
        assertTrue(student.getGrades().contains(3));
        assertTrue(student.getGrades().contains(5));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(6);
        });
        assertEquals("6 это неправильная оценка", exception.getMessage());
    }
}
