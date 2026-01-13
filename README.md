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
