# Báo cáo Thực hành Kiểm thử Phần mềm 



Repo này chứa các bài tập thực hành và báo cáo kết quả kiểm thử phần mềm.



---



## Phần 1: Báo cáo Kết quả Self-Test UI/UX



### 1. Thông tin thực hiện

- **Ngày:** 05/01/2026

- **Bài test:** [Can't Unsee](https://cantunsee.space/)

- **Mục tiêu:** Kiểm tra khả năng nhận diện chi tiết trong thiết kế giao diện (padding, typography, contrast, v.v.).



### 2. 🏆 Kết quả

- **Điểm số đạt được:** 7930



### 3. Ảnh minh chứng

![Kết quả Cantunsee](./images/ket-qua-cantunsee.png)



---



## Phần 2: Bài tập thực hành kiểm thử với JUnit

**Chủ đề:** Phân tích dữ liệu điểm số học sinh



### 1. Giới thiệu

Dự án này bao gồm class `StudentAnalyzer` để xử lý danh sách điểm số học sinh và các unit test tương ứng sử dụng JUnit 5.



### 2. Chức năng chính

- `countExcellentStudents`: Đếm số học sinh giỏi (>= 8.0), bỏ qua các điểm không hợp lệ (<0 hoặc >10).

- `calculateValidAverage`: Tính điểm trung bình của các điểm hợp lệ.



### 3. Cấu trúc thư mục

* `unit-test/src/`: Chứa mã nguồn Java.

* `unit-test/test/`: Chứa mã nguồn kiểm thử.



### 4. Cách chạy kiểm thử

- **Yêu cầu:** JDK 8+ và thư viện JUnit 5.

- **Thực hiện:** Chạy trực tiếp trên IDE (IntelliJ/Eclipse/VS Code) bằng cách click chuột phải vào file `StudentAnalyzerTest.java` và chọn **Run**.



### 5. Kết quả

![Kết quả chạy JUnit](./images/ket-qua-junit.png)
