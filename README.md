# 📌 Task 4 – Bank Account Simulation with Exception Handling

## 📝 Description
This project is a simple **Bank Account Simulation** program in Java that demonstrates the use of **Object-Oriented Programming (OOP)** concepts such as **classes**, **objects**, and **methods**, combined with **exception handling** to make the program more robust.

The program allows the user to:
- Deposit money into an account.
- Withdraw money with insufficient balance checks.
- View current balance.
- View transaction history.

A custom exception class `InsufficientBalanceException` is used to handle withdrawal attempts where the requested amount exceeds the available balance.

---

## 🎯 Objectives
- Understand and implement **Java exception handling**.
- Learn how to create and use **custom exceptions**.
- Apply OOP principles in a small banking simulation.
- Maintain and display a **transaction history**.

---

## 🛠 Features
- **Deposit funds** with positive amount validation.
- **Withdraw funds** with:
  - Positive amount check.
  - Insufficient balance detection using a custom exception.
- **View balance** at any time.
- **View transaction history** for all deposits and withdrawals.
- User-friendly messages for successful and failed operations.

---

## 📖 Example Output
Enter Account Number: 12345
Enter Initial Balance: 5000

1. Deposit
2. Withdraw
3. Balance
4. Transactions
5. Exit
Choose an option: 2
Enter withdrawal amount: 6000
❌ Withdrawal failed: Insufficient balance.

1. Deposit
2. Withdraw
3. Balance
4. Transactions
5. Exit
Choose an option: 3
💰 Current Balance: 5000.0
