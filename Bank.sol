// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {
    uint256 private balance;

    function deposit(uint256 amount) public {
        require(amount > 0, "Amount must be greater than 0");
        balance += amount;
    }

    function withdraw(uint256 amount) public {
        require(amount > 0, "Amount must be greater than 0");
        require(amount <= balance, "Insufficient balance");
        balance -= amount;
    }

    function checkBalance() public view returns (uint256) {
        return balance;
    }
}
