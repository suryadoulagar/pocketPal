package com.xayrus.pocketPal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xayrus.pocketPal.model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}