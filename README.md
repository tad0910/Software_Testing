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

### 6. Kết quả Code Coverage
Đã thực hiện đo lường độ bao phủ mã nguồn (Code Coverage) cho class `StudentAnalyzer`. Kết quả đạt độ bao phủ tuyệt đối:

| Element | Class, % | Method, % | Line, % | Branch, % |
| :--- | :--- | :--- | :--- | :--- |
| **StudentAnalyzer** | 100% (1/1) | 100% (2/2) | 100% (19/19) | 100% (24/24) |

![Kết quả Coverage](./images/coverage-result.png)

---

## Phần 3: Bài tập thực hành kiểm thử tự động End-to-End với Cypress
**Chủ đề:** Kiểm thử luồng chức năng trang web thương mại điện tử (E-commerce)

### 1. Giới thiệu
Sử dụng **Cypress** để thực hiện kiểm thử tự động End-to-End (E2E) cho trang web mẫu [Swag Labs (SauceDemo)](https://www.saucedemo.com). Bài tập tập trung vào việc mô phỏng hành vi người dùng thực tế từ đăng nhập đến thanh toán.

### 2. Các kịch bản kiểm thử (Test Scenarios)
Dự án bao gồm 2 file kiểm thử chính nằm trong thư mục `cypress/e2e/`:

* **`login_spec.cy.js` (Kiểm thử Đăng nhập):**
    * ✅ Đăng nhập thành công với tài khoản hợp lệ (`standard_user`).
    * ✅ Hiển thị thông báo lỗi chính xác khi nhập sai thông tin (`invalid_user`).

* **`cart_spec.cy.js` (Kiểm thử Giỏ hàng & Thanh toán):**
    * ✅ Thêm sản phẩm vào giỏ hàng và kiểm tra số lượng (Badge count).
    * ✅ Sắp xếp danh sách sản phẩm theo giá (Thấp đến Cao).
    * ✅ Xóa sản phẩm khỏi giỏ hàng.
    * ✅ Thực hiện quy trình thanh toán đầy đủ (Checkout Flow): Giỏ hàng -> Điền thông tin -> Xác nhận -> Hoàn tất.

### 3. Cách cài đặt và chạy
Mở Terminal tại thư mục gốc của dự án và thực hiện các lệnh sau:

1.  **Di chuyển vào thư mục bài tập:**
    ```bash
    cd cypress-exercise
    ```

2.  **Cài đặt các thư viện (nếu chưa có):**
    ```bash
    npm install
    ```

3.  **Mở giao diện Cypress:**
    ```bash
    npx cypress open
    ```
    *Chọn **E2E Testing** -> Chọn trình duyệt (Chrome/Electron) -> Click vào file spec muốn chạy.*

### 4. Kết quả kiểm thử (Evidence)

**Kết quả kịch bản Đăng nhập:**

![Kết quả Login](./cypress-exercise/evidence/login-test-result.png)

**Kết quả kịch bản Giỏ hàng & Thanh toán:**

![Kết quả Cart & Checkout](./cypress-exercise/evidence/cart-checkout-result.png)

## Phần 4: Báo cáo Áp dụng Kỹ thuật Kiểm thử Hộp đen
Dưới đây là tổng hợp kết quả áp dụng 3 kỹ thuật kiểm thử hộp đen vào chức năng phân tích điểm học sinh (`StudentAnalyzer`).

### 1. Kỹ thuật Phân hoạch Tương đương (Equivalence Partitioning - EP)
Chia miền giá trị đầu vào thành các lớp tương đương để giảm số lượng test case cần thiết mà vẫn đảm bảo độ bao phủ.
*   **Lớp hợp lệ (Valid):** `0.0 <= score <= 10.0`
*   **Lớp không hợp lệ (Invalid):** `score < 0.0` hoặc `score > 10.0`
*   **Lớp đặc biệt:** Input là `null` hoặc danh sách rỗng (Empty List).
*   **Kết quả:** Đã phát hiện và xử lý thành công các trường hợp đầu vào ngoại lệ (Null/Empty Loop) để tránh lỗi Runtime.

### 2. Kỹ thuật Phân tích Giá trị Biên (Boundary Value Analysis - BVA)
Tập trung kiểm thử tại các điểm biên của miền giá trị, nơi dễ xảy ra lỗi nhất.
*   **Các biên quan trọng:** `0.0`, `8.0` (mốc Giỏi), `10.0`.
*   **Độ chính xác cao (High Precision):** Kiểm thử cả các giá trị lân cận (`epsilon`) để đảm bảo logic so sánh (`>=`) hoạt động chính xác tuyệt đối.
    *   Ví dụ: `7.9999` (Không giỏi), `8.0001` (Giỏi), `10.0001` (Invalid).

### 3. Kỹ thuật Bảng Quyết Định (Decision Table Testing)
Sử dụng để kiểm thử các tổ hợp điều kiện logic phức tạp.
*   **Quy tắc (Rules):** Thiết lập bảng quy tắc xử lý cho các trường hợp: (1) List Null, (2) List Empty, (3) List chứa phần tử Null, (4) List chứa giá trị Invalid xen kẽ Valid.
*   **Kết quả:** Đảm bảo tính "Robustness" (Độ bền vững) của hệ thống. Chương trình có khả năng tự loại bỏ các giá trị "rác" (Null/Invalid) trong một danh sách hỗn hợp và tính toán đúng trên các giá trị còn lại.

---
*(Xem chi tiết code kiểm thử tại `unit-test/test/StudentAnalyzerTest.java`)*
