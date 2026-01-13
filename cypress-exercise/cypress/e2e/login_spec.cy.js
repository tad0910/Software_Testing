describe("Login Test Cases", () => {
  // Kịch bản 1: Đăng nhập thành công
  it("Should login successfully with valid credentials", () => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("standard_user");
    cy.get("#password").type("secret_sauce");
    cy.get("#login-button").click();

    // Kiểm tra URL thay đổi là cách chắc chắn nhất
    cy.url().should("include", "/inventory.html");
  });

  // Kịch bản 2: Đăng nhập thất bại
  it("Should show error message with invalid credentials", () => {
    cy.visit("https://www.saucedemo.com");
    cy.get("#user-name").type("invalid_user");
    cy.get("#password").type("wrong_password");
    cy.get("#login-button").click();

    // Kiểm tra thông báo lỗi xuất hiện
    cy.get(".error-message-container").should(
      "contain",
      "Username and password do not match"
    );
  });
});
