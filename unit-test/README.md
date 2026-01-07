# Bài tập thực hành kiểm thử với JUnit
## Chủ đề: Phân tích dữ liệu điểm số học sinh

### 1. Giới thiệu
Dự án này bao gồm class `StudentAnalyzer` để xử lý danh sách điểm số học sinh và các unit test tương ứng sử dụng JUnit 5.

### 2. Chức năng
* **countExcellentStudents**: Đếm số học sinh giỏi (>= 8.0), bỏ qua các điểm không hợp lệ (<0 hoặc >10).
* **calculateValidAverage**: Tính điểm trung bình của các điểm hợp lệ.

### 3. Cấu trúc thư mục
* `src/`: Chứa mã nguồn Java.
* `test/`: Chứa mã nguồn kiểm thử.

### 4. Cách chạy kiểm thử
Yêu cầu: JDK 8+ và thư viện JUnit 5.
Chạy trực tiếp trên IDE (IntelliJ/Eclipse/VS Code) bằng cách click chuột phải vào file `StudentAnalyzerTest.java` và chọn **Run**.