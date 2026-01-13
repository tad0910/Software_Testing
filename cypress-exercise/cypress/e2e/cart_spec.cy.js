describe("Cart and Checkout Flow", () => {
  // Hook này chạy trước MỖI bài test (it) trong block này
  // Giúp em luôn ở trạng thái đã đăng nhập sẵn sàng
  beforeEach(() => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("standard_user");
    cy.get("#password").type("secret_sauce");
    cy.get("#login-button").click();
  });

  // Kịch bản 3: Thêm sản phẩm vào giỏ
  it("Should add a product to the cart", () => {
    // Chọn nút Add to cart đầu tiên
    cy.get(".inventory_item").first().find(".btn_inventory").click();
    // Kiểm tra badge giỏ hàng hiện số 1
    cy.get(".shopping_cart_badge").should("have.text", "1");
  });

  // Kịch bản 4: Sắp xếp sản phẩm
  it("Should sort products by price low to high", () => {
    cy.get(".product_sort_container").select("lohi"); // lohi = Low to High
    // Kiểm tra giá sản phẩm đầu tiên là $7.99
    cy.get(".inventory_item_price").first().should("have.text", "$7.99");
  });

  // --- PHẦN BÀI TẬP YÊU CẦU THÊM ---

  // Yêu cầu 1: Xóa sản phẩm khỏi giỏ hàng
  it("Should remove a product from the cart", () => {
    // Bước 1: Thêm vào trước
    cy.get(".inventory_item").first().find(".btn_inventory").click();
    cy.get(".shopping_cart_badge").should("exist"); // Đảm bảo đã thêm

    // Bước 2: Nhấn nút Remove (Trên SauceDemo, nút Add đổi thành Remove ngay tại chỗ)
    // Hoặc em có thể vào hẳn trang giỏ hàng để xóa, nhưng cách nhanh nhất là click lại nút đó
    cy.get(".inventory_item").first().find(".btn_inventory").click();

    // Bước 3: Xác minh badge giỏ hàng biến mất (trên web này số 0 nó sẽ ẩn luôn badge)
    cy.get(".shopping_cart_badge").should("not.exist");
  });

  // Yêu cầu 2: Quy trình thanh toán (Checkout flow)
  it("Should complete the checkout flow", () => {
    // 1. Thêm sản phẩm
    cy.get(".inventory_item").first().find(".btn_inventory").click();

    // 2. Vào giỏ hàng
    cy.get(".shopping_cart_link").click();
    cy.url().should("include", "/cart.html");

    // 3. Nhấn Checkout
    cy.get("#checkout").click();
    cy.url().should("include", "/checkout-step-one.html");

    // 4. Điền thông tin
    cy.get("#first-name").type("John");
    cy.get("#last-name").type("Doe");
    cy.get("#postal-code").type("12345");

    // 5. Nhấn Continue
    cy.get("#continue").click();

    // 6. Xác minh chuyển sang trang bước 2
    cy.url().should("include", "/checkout-step-two.html");

    // (Bonus của thầy) Em nên verify thêm là tổng tiền đã hiển thị để bài test chặt chẽ hơn
    cy.get(".summary_total_label").should("exist");
  });
});
