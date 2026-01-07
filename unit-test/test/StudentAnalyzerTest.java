import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();


    @Test
    public void testCountExcellentStudents_NormalCase() {
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 8.0);
        assertEquals(3, analyzer.countExcellentStudents(scores), "Phải đếm đúng số lượng học sinh giỏi bỏ qua điểm sai");
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()), "Danh sách rỗng phải trả về 0");
    }

    @Test
    public void testCountExcellentStudents_AllInvalid() {
        List<Double> scores = Arrays.asList(-5.0, 15.0, 10.1);
        assertEquals(0, analyzer.countExcellentStudents(scores), "Không có điểm hợp lệ nào thì kết quả là 0");
    }

    @Test
    public void testCountExcellentStudents_BoundaryValues() {
        List<Double> scores = Arrays.asList(7.9, 8.0, 10.0, 0.0);
        // Mong đợi: 2 (8.0 và 10.0)
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    // --- Test cho hàm calculateValidAverage ---

    @Test
    public void testCalculateValidAverage_NormalCase() {
        // Danh sách: 9.0, 8.5, 7.0, 11.0 (bỏ), -1.0 (bỏ)
        // Hợp lệ: 9.0 + 8.5 + 7.0 = 24.5
        // Số lượng: 3
        // Trung bình: 24.5 / 3 = 8.16666...
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01, "Tính trung bình phải chính xác với sai số 0.01");
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Nếu toàn bộ điểm không hợp lệ, không thể chia cho 0
        List<Double> scores = Arrays.asList(-1.0, 20.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }
}