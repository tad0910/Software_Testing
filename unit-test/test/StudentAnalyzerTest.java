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
        assertEquals(3, analyzer.countExcellentStudents(scores),
                "Phải đếm đúng số lượng học sinh giỏi bỏ qua điểm sai");
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
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01,
                "Tính trung bình phải chính xác với sai số 0.01");
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // Nếu toàn bộ điểm không hợp lệ (Negative), không thể chia cho 0
        List<Double> scores = Arrays.asList(-1.0, -5.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCountExcellentStudents_NullInput() {
        // Lớp tương đương: Null Input -> Return 0
        assertEquals(0, analyzer.countExcellentStudents(null), "Input null phải trả về 0");
    }

    @Test
    public void testCountExcellentStudents_InvalidScores_Negative() {
        // Lớp tương đương: Điểm < 0 -> Bỏ qua
        List<Double> scores = Arrays.asList(-1.0, -10.0, -0.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_InvalidScores_GreaterThan10() {
        // Lớp tương đương: Điểm > 10 -> Bỏ qua
        List<Double> scores = Arrays.asList(10.1, 100.0, 11.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCalculateValidAverage_NullInput() {
        // Lớp tương đương: Null Input -> Return 0.0
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.001, "Input null phải trả về 0.0");
    }

    @Test
    public void testCalculateValidAverage_InvalidScores_GreaterThan10() {
        // Lớp tương đương: Điểm > 10 -> Bỏ qua
        List<Double> scores = Arrays.asList(10.1, 15.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCountExcellentStudents_ListWithNullElement() {
        // Robustness: List chứa phần tử null -> Bỏ qua phần tử đó, không crash
        List<Double> scores = Arrays.asList(8.0, null, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), "Phải bỏ qua phần tử null trong list");
    }

    @Test
    public void testCalculateValidAverage_ListWithNullElement() {
        // Robustness: List chứa phần tử null -> Bỏ qua
        List<Double> scores = Arrays.asList(8.0, null, 8.0); // T.bình = 8.0
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // --- Bổ sung Test Case BVA (High Precision) ---

    // --- Helper Methods to reduce duplication ---

    private void assertExcellentCount(double score, int expectedCount) {
        List<Double> scores = Collections.singletonList(score);
        assertEquals(expectedCount, analyzer.countExcellentStudents(scores), "Failed at score: " + score);
    }

    private void assertAverage(List<Double> scores, double expectedAvg) {
        assertEquals(expectedAvg, analyzer.calculateValidAverage(scores), 0.001, "Average mismatch");
    }

    // --- Refactored & New BVA Tests ---

    @Test
    public void testCountExcellentStudents_BoundaryPrecision() {
        // Refactored to use helper method
        assertExcellentCount(7.9999, 0); // Just below 8
        assertExcellentCount(8.0001, 1); // Just above 8
        assertExcellentCount(10.0001, 0); // Just above 10 (Invalid)
        assertExcellentCount(-0.0001, 0); // Just below 0 (Invalid)
    }

    @Test
    public void testCalculateValidAverage_BoundaryPrecision() {
        // BVA High Precision for Average

        // 1. Boundary 0.0
        // -0.0001 -> Invalid (Ignored) -> Average 0.0 (empty valid list)
        assertAverage(Arrays.asList(-0.0001), 0.0);

        // 0.0 -> Valid -> Average 0.0
        assertAverage(Arrays.asList(0.0), 0.0);

        // 0.0001 -> Valid -> Average 0.0001
        assertAverage(Arrays.asList(0.0001), 0.0001);

        // 2. Boundary 10.0
        // 10.0 -> Valid -> Average 10.0
        assertAverage(Arrays.asList(10.0), 10.0);

        // 9.9999 -> Valid -> Average 9.9999
        assertAverage(Arrays.asList(9.9999), 9.9999);

        // 10.0001 -> Invalid (Ignored) -> Average 0.0
        assertAverage(Arrays.asList(10.0001), 0.0);

        // Mixed Boundary Case
        // 0.0 (Valid) + 10.0 (Valid) + -0.0001 (Ignored) + 10.0001 (Ignored)
        // Sum = 10.0, Count = 2 => Avg = 5.0
        assertAverage(Arrays.asList(0.0, 10.0, -0.0001, 10.0001), 5.0);
    }
}