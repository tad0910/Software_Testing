# Báo cáo Thực hành Kiểm thử Phần mềm

Repo này chứa các bài tập thực hành và báo cáo kết quả kiểm thử phần mềm.
---

## Phần 1: Báo cáo Kết quả Self-Test UI/UX

### 1. Thông tin thực hiện
- **Bài test:** [Can't Unsee](https://cantunsee.space/)
- **Mục tiêu:** Kiểm tra khả năng nhận diện chi tiết trong thiết kế giao diện (padding, typography, contrast, v.v.).

### 2. 🏆 Kết quả
- **Điểm số đạt được:** 7930
- **Đánh giá:** Hoàn thành tốt các bài kiểm tra về độ tương phản và bố cục.

### 3. Ảnh minh chứng
![Kết quả Cantunsee](./images/ket-qua-cantunsee.png)

---

## Phần 2: Bài tập thực hành kiểm thử với JUnit
**Chủ đề:** Phân tích dữ liệu điểm số học sinh.

### 1. Giới thiệu
Dự án xây dựng class `StudentAnalyzer` để xử lý danh sách điểm số học sinh và thực hiện các Unit Test sử dụng thư viện **JUnit 5**.

### 2. Chức năng chính
- `countExcellentStudents`: Đếm số học sinh giỏi (điểm >= 8.0). Tự động bỏ qua các điểm số không hợp lệ (<0 hoặc >10).
- `calculateValidAverage`: Tính điểm trung bình cộng của các điểm hợp lệ có trong danh sách.

### 3. Cấu trúc thư mục
- `unit-test/src/`: Chứa mã nguồn Java (`StudentAnalyzer.java`).
- `unit-test/test/`: Chứa mã nguồn kiểm thử (`StudentAnalyzerTest.java`).

### 4. Cách chạy kiểm thử
- **Yêu cầu môi trường:** JDK 8+ và thư viện JUnit 5.
- **Cách thực hiện:**
  1. Mở dự án bằng IDE (IntelliJ IDEA, Eclipse hoặc VS Code).
  2. Tìm đến file `StudentAnalyzerTest.java`.
  3. Click chuột phải và chọn **Run** (hoặc **Run 'StudentAnalyzerTest'**).

### 5. Kết quả kiểm thử
![Kết quả chạy JUnit](./images/ket-qua-junit.png)
