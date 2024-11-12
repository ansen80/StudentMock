import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Student {

    @Getter
    @Setter
    private String name;
    private List<Integer> grades = new ArrayList<>();
    private CheckGradeServiceMock checkGradeService;

    public Student(String name, CheckGradeServiceMock checkGradeService) {
        this.name = name;
        this.checkGradeService = checkGradeService;
    }

    public List<Integer> getGrades() {
        return new ArrayList<>(grades);
    }

    @SneakyThrows
    public void addGrade(int grade) {
        if (!checkGradeService.isGradeValid(grade)) {
            throw new IllegalArgumentException(grade + " это неправильная оценка");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int rating() {
        return grades.stream().mapToInt(Integer::intValue).sum();
    }
}


