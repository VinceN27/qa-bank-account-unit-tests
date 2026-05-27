# Bank Account Automated Unit Testing Project

A Java unit testing portfolio project demonstrating real-world QA 
practices using JUnit 5 and Mockito.

## Project Overview

This project simulates a simple banking system with user authentication.
It was built to demonstrate the full QA process from design to execution
including test planning, test case documentation, and bug reporting.

## System Features

- Bank Account — deposit, withdraw, balance management
- Transaction Service — processes transactions and sends notifications
- Notification Service — sends alerts (mocked in tests)
- User Login — user authentication with input validation

## Tech Stack

| Tool | Purpose |
|---|---|
| Java 8 | Programming language |
| JUnit 5 | Unit testing framework |
| Mockito 4 | Mocking framework |
| Maven | Build and dependency management |
| VS Code | IDE |

## QA Documentation

| Document | Description |
|---|---|
| Requirements | Functional and non-functional requirements |
| Test Plan | Testing approach, scope, environment, risks |
| Test Cases | 23 detailed test cases with inputs and expected results |
| Bug Report | Bugs found during testing with root cause and fix |
| UML Class Diagram | System design showing classes and relationships |
| Flowchart | Logic flow for deposit, withdrawal and login |

## Test Summary

| Class | Tests | Status |
|---|---|---|
| BankAccountTest | 10 | ✅ All Passing |
| TransactionServiceTest | 5 | ✅ All Passing |
| UserLoginTest | 8 | ✅ All Passing |
| **Total** | **23** | ✅ **All Passing** |

## Key Concepts Demonstrated

- AAA Pattern — Arrange, Act, Assert
- Mocking with Mockito — NotificationService mocked in tests
- Validated correct exception handling for invalid inputs 
   and invalid system states using assertThrows()
- Ensured full test independence using @BeforeEach 
   to reset system state before each test execution
- Behavior based test naming
- Mock interaction verification with verify() and verifyNoInteractions()

## How to Run Tests
-mvn test

## Bugs Found During Testing

| Bug ID | Description | Status |
|---|---|---|
| BUG001 | Password length not validated in login() method | Fixed |


