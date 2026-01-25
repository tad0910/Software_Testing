import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentAnalyzerTest {

    private final StudentAnalyzer analyzer = new StudentAnalyzer();

    // --- Helper Methods ---

    private void assertExcellentCount(double score, int expectedCount) {
        List<Double> scores = Collections.singletonList(score);
        assertEquals(expectedCount, analyzer.countExcellentStudents(scores), "Failed at score: " + score);
    }

    private void assertAverage(List<Double> scores, double expectedAvg) {
        assertEquals(expectedAvg, analyzer.calculateValidAverage(scores), 0.001, "Average mismatch");
    }

    // ==================================================================================
    // SECTION 1: EQUIVALENCE PARTITIONING (EP)
    // Mục tiêu: Kiểm thử các lớp giá trị hợp lệ, không hợp lệ, rỗng, null.
    // ==================================================================================

    // --- EP for countExcellentStudents ---

    @Test
    public void testCountExcellentStudents_NullInput() {
        // EP Class: Input is Null -> Return 0
        assertEquals(0, analyzer.countExcellentStudents(null), "Input null phải trả về 0");
    }

    @Test
    public void testCountExcellentStudents_EmptyList() {
        // EP Class: Input is Empty -> Return 0
        assertEquals(0, analyzer.countExcellentStudents(Collections.emptyList()), "Danh sách rỗng phải trả về 0");
    }

    @Test
    public void testCountExcellentStudents_NormalCase() {
        // EP Class: Valid List with Mixed Values (Standard Happy Path)
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0, 8.0);
        assertEquals(3, analyzer.countExcellentStudents(scores),
                "Phải đếm đúng số lượng học sinh giỏi bỏ qua điểm sai");
    }

    @Test
    public void testCountExcellentStudents_InvalidScores_Negative() {
        // EP Class: Score < 0 (Invalid) -> Ignore
        List<Double> scores = Arrays.asList(-1.0, -10.0, -0.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_InvalidScores_GreaterThan10() {
        // EP Class: Score > 10 (Invalid) -> Ignore
        List<Double> scores = Arrays.asList(10.1, 100.0, 11.0);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_AllInvalid() {
        // EP Class: List containing ONLY invalid values -> Return 0
        List<Double> scores = Arrays.asList(-5.0, 15.0, 10.1);
        assertEquals(0, analyzer.countExcellentStudents(scores));
    }

    // --- EP for calculateValidAverage ---

    @Test
    public void testCalculateValidAverage_NullInput() {
        // EP Class: Input is Null -> Return 0.0
        assertEquals(0.0, analyzer.calculateValidAverage(null), 0.001);
    }

    @Test
    public void testCalculateValidAverage_EmptyList() {
        // EP Class: Input is Empty -> Return 0.0
        assertEquals(0.0, analyzer.calculateValidAverage(Collections.emptyList()), 0.001);
    }

    @Test
    public void testCalculateValidAverage_NormalCase() {
        // EP Class: Valid List -> Calculate Average
        List<Double> scores = Arrays.asList(9.0, 8.5, 7.0, 11.0, -1.0);
        assertEquals(8.17, analyzer.calculateValidAverage(scores), 0.01);
    }

    @Test
    public void testCalculateValidAverage_AllInvalid() {
        // EP Class: All Invalid -> Return 0.0 (Avoid Div by Zero)
        List<Double> scores = Arrays.asList(-1.0, -5.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    @Test
    public void testCalculateValidAverage_InvalidScores_GreaterThan10() {
        // EP Class: Score > 10 -> Ignore
        List<Double> scores = Arrays.asList(10.1, 15.0);
        assertEquals(0.0, analyzer.calculateValidAverage(scores), 0.001);
    }

    // ==================================================================================
    // SECTION 2: BOUNDARY VALUE ANALYSIS (BVA)
    // Mục tiêu: Kiểm thử tại các điểm biên chính xác và lân cận (epsilon).
    // ==================================================================================

    @Test
    public void testCountExcellentStudents_BoundaryValues() {
        // BVA: Standard Boundaries (Exact hits)
        List<Double> scores = Arrays.asList(7.9, 8.0, 10.0, 0.0);
        assertEquals(2, analyzer.countExcellentStudents(scores));
    }

    @Test
    public void testCountExcellentStudents_BoundaryPrecision() {
        // BVA: High Precision (Just-Below and Just-Above)
        assertExcellentCount(7.9999, 0); // Just below 8
        assertExcellentCount(8.0001, 1); // Just above 8
        assertExcellentCount(10.0001, 0); // Just above 10 (Invalid)
        assertExcellentCount(-0.0001, 0); // Just below 0 (Invalid)
    }

    @Test
    public void testCalculateValidAverage_BoundaryPrecision() {
        // BVA: High Precision for Average
        // 0.0 Boundary
        assertAverage(Arrays.asList(-0.0001), 0.0);
        assertAverage(Arrays.asList(0.0), 0.0);
        assertAverage(Arrays.asList(0.0001), 0.0001);

        // 10.0 Boundary
        assertAverage(Arrays.asList(10.0), 10.0);
        assertAverage(Arrays.asList(9.9999), 9.9999);
        assertAverage(Arrays.asList(10.0001), 0.0);

        // Mixed
        assertAverage(Arrays.asList(0.0, 10.0, -0.0001, 10.0001), 5.0);
    }

    // ==================================================================================
    // SECTION 3: DECISION TABLE & ROBUSTNESS
    // Mục tiêu: Kiểm thử các Rules logic phức tạp và xử lý lỗi (Exception
    // handling).
    // ==================================================================================

    @Test
    public void testCountExcellentStudents_ListWithNullElement() {
        // DT Rule: Element is Null -> Ignore (Skip)
        List<Double> scores = Arrays.asList(8.0, null, 9.0);
        assertEquals(2, analyzer.countExcellentStudents(scores), "Phải bỏ qua phần tử null trong list");
    }

    @Test
    public void testCalculateValidAverage_ListWithNullElement() {
        // DT Rule: Element is Null -> Ignore (Skip)
        List<Double> scores = Arrays.asList(8.0, null, 8.0);
        assertEquals(8.0, analyzer.calculateValidAverage(scores), 0.001);
    }
}